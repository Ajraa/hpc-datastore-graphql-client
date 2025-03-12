package client;

import client.base.GraphQLClient;
import client.base.GraphQLException;
import models.ConnectionParameters;
import models.DataReturn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static client.base.StaticStrings.*;
import static client.base.StaticStrings.BLOCKS_PARAM;

public class DatasetServerService implements IDatasetServerService {
    private final GraphQLClient _client;

    public DatasetServerService(GraphQLClient client, ConnectionParameters params) {
        _client = client;
    }

    public DatasetServerService(String endpoint) {_client = GraphQLClient.getInstance(endpoint);}

    @Override
    public DataReturn getStatus() throws IOException, GraphQLException {
        return _client.CallAPI("status", GET_STATUS, null, DataReturn.class);
    }


    @Override
    public DataReturn readBlock(long x, long y, long z, int time, int channel, int angle, String blocks) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(X_PARAM, x);
        vars.put(Y_PARAM, y);
        vars.put(Z_PARAM, z);
        vars.put(TIME_PARAM, time);
        vars.put(CHANNEL_PARAM, channel);
        vars.put(ANGLE_PARAM, angle);
        vars.put(BLOCKS_PARAM, blocks);

        return _client.CallAPI("readBlock", READ_BLOCK, vars, DataReturn.class);
    }

    @Override
    public DataReturn writeBlock(long x, long y, long z, int time, int channel, int angle, String blocks, String data) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(X_PARAM, x);
        vars.put(Y_PARAM, y);
        vars.put(Z_PARAM, z);
        vars.put(TIME_PARAM, time);
        vars.put(CHANNEL_PARAM, channel);
        vars.put(ANGLE_PARAM, angle);
        vars.put(BLOCKS_PARAM, blocks);
        vars.put(INPUT_STREAM, data);

        return _client.CallAPI("writeBlock", WRITE_BLOCK, vars, DataReturn.class);
    }

    @Override
    public DataReturn getType(int time, int channel, int angle) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(TIME_PARAM, time);
        vars.put(CHANNEL_PARAM, channel);
        vars.put(ANGLE_PARAM, angle);

        return _client.CallAPI("type", GET_TYPE, vars, DataReturn.class);
    }

    private final String GET_STATUS = "query GetStatus {\n" +
            "  status {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private final String READ_BLOCK = "query ReadBlock($ANGLE: Int!, $CHANNEL: Int!, $TIME: Int!, $BLOCKS: String, $x: BigInteger!, $y: BigInteger!, $z: BigInteger!) {\n" +
            "  readBlock(\n" +
            "    ANGLE: $ANGLE, \n" +
            "    CHANNEL: $CHANNEL, \n" +
            "    TIME: $TIME, \n" +
            "    BLOCKS: $BLOCKS, \n" +
            "    x: $x, \n" +
            "    y: $y, \n" +
            "    z: $z\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private final String WRITE_BLOCK = "mutation WriteBlock($ANGLE: Int!, $CHANNEL: Int!, $TIME: Int!, $BLOCKS: String, $inputStream: String, $x: BigInteger!, $y: BigInteger!, $z: BigInteger!) {\n" +
            "  writeBlock(\n" +
            "    ANGLE: $ANGLE, \n" +
            "    CHANNEL: $CHANNEL, \n" +
            "    TIME: $TIME, \n" +
            "    BLOCKS: $BLOCKS, \n" +
            "    inputStream: $inputStream,\n" +
            "    x: $x, \n" +
            "    y: $y, \n" +
            "    z: $z\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private final String GET_TYPE = "query GetType($ANGLE: Int!, $CHANNEL: Int!, $TIME: Int!) {\n" +
            "  type(\n" +
            "    ANGLE: $ANGLE, \n" +
            "    CHANNEL: $CHANNEL, \n" +
            "    TIME: $TIME\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";
}