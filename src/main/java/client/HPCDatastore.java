package client;

import static client.base.StaticStrings.*;

import client.base.GraphQLClient;
import client.base.GraphQLException;
import models.DataReturn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HPCDatastore {
    private final GraphQLClient _client;

    public HPCDatastore(GraphQLClient client) {
        _client = client;
    }

    public HPCDatastore(String endpoint) {_client = GraphQLClient.getInstance(endpoint);}

    public DataReturn jsonListDatastoreLoader(String uuid, String uri) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(URI, uri);

        return _client.CallAPI("JSONListDatastoreLoader", JSON_LIST_DATASTORE_LOADER, vars, DataReturn.class);
    }

    public DataReturn metadataXML(String uuid, String version, String uri) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(VERSION_PARAM, version);
        vars.put(URI, uri);

        return _client.CallAPI("MetadataXML", METADATA_XML, vars, DataReturn.class);
    }

    public DataReturn HPCThumbnail(String uuid, String version) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(VERSION_PARAM, version);

        return _client.CallAPI("HPCThumbnail", HPC_THUMBNAIL, vars, DataReturn.class);
    }

    private static final String JSON_LIST_DATASTORE_LOADER = "query JSONListDatastoreLoader($uri: String!, $uuid: String!) {\n" +
            "  JSONListDatastoreLoader(uri: $uri, uuid: $uuid) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}\n";

    private static final String METADATA_XML = "query MetadataXML($uri: String!, $uuid: String!, $versionParam: String!) {\n" +
            "  MetadataXML(uri: $uri, uuid: $uuid, versionParam: $versionParam) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}\n";

    private static final String HPC_THUMBNAIL = "query HPCThumbnail($uuid: String!, $versionParam: String!) {\n" +
            "  HPCThumbnail(uuid: $uuid, versionParam: $versionParam) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}\n";
}
