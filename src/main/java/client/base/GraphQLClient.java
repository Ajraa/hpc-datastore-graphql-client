package client.base;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GraphQLClient {

    private static GraphQLClient singleton;

    private final String graphQLEndpoint;
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public static synchronized GraphQLClient getInstance(String graphQLEndpoint) {
        if (singleton == null || !singleton.graphQLEndpoint.equals(graphQLEndpoint)) singleton = new GraphQLClient(graphQLEndpoint);
        return singleton;
    }

    public static synchronized GraphQLClient getInstance() {
        return singleton;
    }

    private GraphQLClient(String endpoint) {
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        this.graphQLEndpoint = endpoint;
    }

    public <T> T CallAPI(String queryName, String query, Map<String, Object> vars, Class<T> responseType) throws IOException, GraphQLException {
        return CallAPI(
                queryName,
                GraphQLQuery.builder().query(query).variables(vars).build(),
                responseType
        );
    }

    public <T> List<T> CallAPIList(String queryName, String query, Map<String, Object> vars, Class<T> responseType) throws IOException, GraphQLException {
        return CallAPIList(
                queryName,
                GraphQLQuery.builder().query(query).variables(vars).build(),
                responseType
        );
    }

    public <T> List<T> CallAPIList(String queryName, GraphQLQuery query, Class<T> responseType) throws IOException, GraphQLException {
        String jsonRequest = objectMapper.writeValueAsString(query);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonRequest);
        Request request = new Request.Builder()
                .url(graphQLEndpoint)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        GraphQLResponse<List<T>> gqlResponse = DeserializeList(response, responseType);

        if (gqlResponse.Errors != null && !gqlResponse.Errors.isEmpty())
            throw new GraphQLException(gqlResponse.Errors);

        return gqlResponse.getData().getQueryResults().get(queryName);
    }

    public <T> GraphQLResponse<T> CallAPI(GraphQLQuery query, Class<T> responseType) throws IOException, GraphQLException {
        String jsonRequest = objectMapper.writeValueAsString(query);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonRequest);
        Request request = new Request.Builder()
                .url(graphQLEndpoint)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        GraphQLResponse<T> gqlResponse = Deserialize(response, responseType);

        if (gqlResponse.Errors != null && !gqlResponse.Errors.isEmpty())
            throw new GraphQLException(gqlResponse.Errors);

        return gqlResponse;
    }

    public <T> T CallAPI(String queryName, GraphQLQuery query, Class<T> responseType) throws IOException, GraphQLException {
        String jsonRequest = objectMapper.writeValueAsString(query);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonRequest);
        Request request = new Request.Builder()
                .url(graphQLEndpoint)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        GraphQLResponse<T> gqlResponse = Deserialize(response, responseType);

        if (gqlResponse.Errors != null && !gqlResponse.Errors.isEmpty())
            throw new GraphQLException(gqlResponse.Errors);

        return gqlResponse.getData().getQueryResults().get(queryName);
    }

    public GraphQLResponse<Object> CallAPI(GraphQLQuery query) throws IOException, GraphQLException {
        String jsonRequest = objectMapper.writeValueAsString(query);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonRequest);
        Request request = new Request.Builder()
                .url(graphQLEndpoint)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        GraphQLResponse<Object> gqlResponse = Deserialize(response);

        if (gqlResponse.Errors != null && !gqlResponse.Errors.isEmpty())
            throw new GraphQLException(gqlResponse.Errors);

        return gqlResponse;
    }

    private <T> GraphQLResponse<T>  Deserialize(Response response, Class<T> responseType) throws IOException {
        assert response.body() != null;
        String res = response.body().string();

        JavaType specificType = objectMapper.getTypeFactory().constructType(responseType);
        JavaType wrapperType = objectMapper.getTypeFactory()
                .constructParametricType(GraphQLResponse.class, specificType);

        return objectMapper.readValue(res, wrapperType);
    }

    private  GraphQLResponse<Object>  Deserialize(Response response) throws IOException {
        assert response.body() != null;
        String res = response.body().string();

        JavaType specificType = objectMapper.getTypeFactory().constructType(Object.class);
        JavaType wrapperType = objectMapper.getTypeFactory()
                .constructParametricType(GraphQLResponse.class, specificType);

        return objectMapper.readValue(res, wrapperType);
    }

    private <T> GraphQLResponse<List<T>>  DeserializeList(Response response, Class<T> responseType) throws IOException {
        assert response.body() != null;

        JavaType specificType = objectMapper.getTypeFactory().constructType(responseType);
        JavaType listType = objectMapper.getTypeFactory().constructParametricType(List.class, specificType);
        JavaType wrapperType = objectMapper.getTypeFactory()
                .constructParametricType(GraphQLResponse.class, listType);

        return objectMapper.readValue(response.body().string(), wrapperType);
    }
}