package client;

import client.base.GraphQLClient;
import client.base.GraphQLException;
import models.DataReturn;

import java.io.IOException;

public class DataServerManagerService {
    private final GraphQLClient _client;

    public DataServerManagerService(GraphQLClient client) {
        _client = client;
    }
    public DataServerManagerService(String endpoint) {_client = GraphQLClient.getInstance(endpoint);}

    public DataReturn stop() throws IOException, GraphQLException {
        return _client.CallAPI("stop", STOP, null, DataReturn.class);
    }

    private final String STOP = "mutation StopDataServer {\n" +
            "  stop {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";
}
