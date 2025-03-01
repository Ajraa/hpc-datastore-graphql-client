package client;

import client.base.GraphQLClient;
import client.base.GraphQLException;
import models.DataReturn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static client.base.StaticStrings.*;

public class BigDataService {
    private final GraphQLClient _client;

    public BigDataService(GraphQLClient client) {
        _client = client;
    }

    public DataReturn getJsonList(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("jSONList", GET_JSON_LIST, vars, DataReturn.class);
    }

    public DataReturn getCell(String uuid, String version, String p) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(VERSION_PARAM, version);
        vars.put(P_PARAM, p);

        return _client.CallAPI("cell", GET_CELL, vars, DataReturn.class);
    }

    public DataReturn getSettings(String uuid, String version) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(VERSION_PARAM, version);

        return _client.CallAPI("settings", GET_SETTINGS, vars, DataReturn.class);
    }

    public DataReturn getBDVThumbnail(String uuid, String version) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(VERSION_PARAM, version);

        return _client.CallAPI("BDVThumbnail", GET_BDV_THUMBNAIL, vars, DataReturn.class);
    }

    private final String GET_JSON_LIST = "query GetJSONList($uuid: String!) {\n" +
            "  jSONList(uuid: $uuid) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private final String GET_CELL = "query GetCell($p: String!, $uuid: String!, $versionParam: String) {\n" +
            "  cell(p: $p, uuid: $uuid, versionParam: $versionParam) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private final String GET_SETTINGS = "query GetSettings($uuid: String!, $versionParam: String) {\n" +
            "  settings(uuid: $uuid, versionParam: $versionParam) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private final String GET_BDV_THUMBNAIL = "query GetBDVThumbnail($uuid: String!, $versionParam: String) {\n" +
            "  BDVThumbnail(uuid: $uuid, versionParam: $versionParam) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";
}
