package client;

import client.base.GraphQLClient;
import client.base.GraphQLException;
import models.ConnectionParameters;
import models.DataReturn;

import static client.base.StaticStrings.*;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SharedDatasetServerService implements IDatasetServerService {
    private final GraphQLClient _client;
    private final ConnectionParameters _params;


    public SharedDatasetServerService(GraphQLClient client, ConnectionParameters params) {
        _client = client;
        _params = params;
    }

    public SharedDatasetServerService(String endpoint, ConnectionParameters params) {
        _client = GraphQLClient.getInstance(endpoint);
        _params = params;
    }

    @Override
    public DataReturn getStatus() throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, _params.getUuid());
        vars.put(R_X_PARAM, _params.getRx());
        vars.put(R_Y_PARAM, _params.getRy());
        vars.put(R_Z_PARAM, _params.getRz());
        vars.put(VERSION_PARAM, _params.getVersion());

        return _client.CallAPI("SharedStatus", GET_SHARED_STATUS, vars, DataReturn.class);
    }

    @Override
    public DataReturn readBlock(long x, long y, long z, int time, int channel, int angle, String blocks) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, _params.getUuid());
        vars.put(R_X_PARAM, _params.getRx());
        vars.put(R_Y_PARAM, _params.getRy());
        vars.put(R_Z_PARAM, _params.getRz());
        vars.put(VERSION_PARAM, _params.getVersion());
        vars.put(X_PARAM, x);
        vars.put(Y_PARAM, y);
        vars.put(Z_PARAM, z);
        vars.put(TIME_PARAM, time);
        vars.put(CHANNEL_PARAM, channel);
        vars.put(ANGLE_PARAM, angle);
        vars.put(BLOCKS_PARAM, blocks);

        return _client.CallAPI("ReadSharedBlock", READ_SHARED_BLOCK, vars, DataReturn.class);
    }

    @Override
    public DataReturn writeBlock(long x, long y, long z, int time, int channel, int angle, String blocks, String data) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, _params.getUuid());
        vars.put(R_X_PARAM, _params.getRx());
        vars.put(R_Y_PARAM, _params.getRy());
        vars.put(R_Z_PARAM, _params.getRz());
        vars.put(VERSION_PARAM, _params.getVersion());
        vars.put(X_PARAM, x);
        vars.put(Y_PARAM, y);
        vars.put(Z_PARAM, z);
        vars.put(TIME_PARAM, time);
        vars.put(CHANNEL_PARAM, channel);
        vars.put(ANGLE_PARAM, angle);
        vars.put(BLOCKS_PARAM, blocks);
        vars.put(INPUT_STREAM, data);

        return _client.CallAPI("WriteSharedBlock", WRITE_SHARED_BLOCK, vars, DataReturn.class);
    }

    @Override
    public DataReturn getType(int time, int channel, int angle) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, _params.getUuid());
        vars.put(R_X_PARAM, _params.getRx());
        vars.put(R_Y_PARAM, _params.getRy());
        vars.put(R_Z_PARAM, _params.getRz());
        vars.put(VERSION_PARAM, _params.getVersion());
        vars.put(TIME_PARAM, time);
        vars.put(CHANNEL_PARAM, channel);
        vars.put(ANGLE_PARAM, angle);

        return _client.CallAPI("SharedType", GET_SHARED_TYPE, vars, DataReturn.class);
    }

    private static final String GET_SHARED_STATUS = "query GetSharedStatus($uuid: String!, $versionParam: String, $RxParam: Int!, $RyParam: Int!, $RzParam: Int!) {\n" +
            "  SharedStatus(\n" +
            "    uuid: $uuid, \n" +
            "    versionParam: $versionParam, \n" +
            "    RxParam: $RxParam, \n" +
            "    RyParam: $RyParam, \n" +
            "    RzParam: $RzParam\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private static final String READ_SHARED_BLOCK = "query ReadSharedBlock($uuid: String!, $versionParam: String, $ANGLE: Int!, $CHANNEL: Int!, $TIME: Int!, $BLOCKS: String, $RxParam: Int!, $RyParam: Int!, $RzParam: Int!, $x: BigInteger!, $y: BigInteger!, $z: BigInteger!) {\n" +
            "  ReadSharedBlock(\n" +
            "    uuid: $uuid, \n" +
            "    versionParam: $versionParam, \n" +
            "    ANGLE: $ANGLE, \n" +
            "    CHANNEL: $CHANNEL, \n" +
            "    TIME: $TIME, \n" +
            "    BLOCKS: $BLOCKS, \n" +
            "    RxParam: $RxParam, \n" +
            "    RyParam: $RyParam, \n" +
            "    RzParam: $RzParam, \n" +
            "    x: $x, \n" +
            "    y: $y, \n" +
            "    z: $z\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private static final String WRITE_SHARED_BLOCK = "mutation WriteSharedBlock($uuid: String!, $versionParam: String, $ANGLE: Int!, $CHANNEL: Int!, $TIME: Int!, $BLOCKS: String, $RxParam: Int!, $RyParam: Int!, $RzParam: Int!, $inputStream: String, $x: BigInteger!, $y: BigInteger!, $z: BigInteger!) {\n" +
            "  WriteSharedBlock(\n" +
            "    uuid: $uuid, \n" +
            "    versionParam: $versionParam, \n" +
            "    ANGLE: $ANGLE, \n" +
            "    CHANNEL: $CHANNEL, \n" +
            "    TIME: $TIME, \n" +
            "    BLOCKS: $BLOCKS, \n" +
            "    RxParam: $RxParam, \n" +
            "    RyParam: $RyParam, \n" +
            "    RzParam: $RzParam, \n" +
            "    inputStream: $inputStream,\n" +
            "    x: $x, \n" +
            "    y: $y, \n" +
            "    z: $z\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    public static final String GET_SHARED_TYPE = "query GetSharedType($uuid: String!, $versionParam: String, $ANGLE: Int!, $CHANNEL: Int!, $TIME: Int!, $RxParam: Int!, $RyParam: Int!, $RzParam: Int!) {\n" +
            "  SharedType(\n" +
            "    uuid: $uuid, \n" +
            "    versionParam: $versionParam, \n" +
            "    ANGLE: $ANGLE, \n" +
            "    CHANNEL: $CHANNEL, \n" +
            "    TIME: $TIME, \n" +
            "    RxParam: $RxParam, \n" +
            "    RyParam: $RyParam, \n" +
            "    RzParam: $RzParam\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";
}