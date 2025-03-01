package client;

import client.base.GraphQLClient;
import client.base.GraphQLException;
import models.DataReturn;
import models.QLDatasetDTO;

import static client.base.StaticStrings.*;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RegisterService {
    private final GraphQLClient _client;

    public RegisterService(GraphQLClient client) {
        _client = client;
    }

    public RegisterService(String endpoint) {_client = GraphQLClient.getInstance(endpoint);}

    //START DATASERVER

    public URI startServer( String uuid,  int rX, int rY, int rZ,
                            String version, long timeout, String modeName) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(R_X_PARAM, rX);
        vars.put(R_Y_PARAM, rY);
        vars.put(R_Z_PARAM, rZ);
        vars.put(VERSION_PARAM, version);
        vars.put(TIMEOUT_PARAM, timeout);
        vars.put(MODE_PARAM, modeName);

        return _client.CallAPI("StartDataserver", START_DATASERVER, vars, URI.class);

    }

    // StartWriteDataserver
    public URI startServer( String uuid,  int rX, int rY, int rZ,
                            String version, long timeout) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(R_X_PARAM, rX);
        vars.put(R_Y_PARAM, rY);
        vars.put(R_Z_PARAM, rZ);
        vars.put(VERSION_PARAM, version);
        vars.put(TIMEOUT_PARAM, timeout);

        return _client.CallAPI("StartWriteDataserver", START_WRITE_DATASERVER, vars, URI.class);
    }

    public UUID createEmptyDataset(QLDatasetDTO dataset) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put("datasetDTO", dataset);

        return _client.CallAPI("CreateEmptyDataset", CREATE_EMPTY_DATASET, vars, UUID.class);
    }

    public DataReturn addExistingDataset(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("AddExistingDataset", ADD_EXISTING_DATASET, vars, DataReturn.class);
    }

    public QLDatasetDTO queryDataset(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("QueryDataset", QUERY_DATASET, vars, QLDatasetDTO.class);
    }

    public DataReturn deleteDataset(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("DeleteDataset", DELETE_DATASET, vars, DataReturn.class);
    }

    public DataReturn deleteDatasetVersions(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("DeleteDatasetVersions", DELETE_DATASET_VERSION, vars, DataReturn.class);
    }

    public DataReturn getCommonMetadata(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("GetCommonMetadata", GET_COMMON_METADATA, vars, DataReturn.class);
    }

    public DataReturn setCommonMetadata(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("SetCommonMetadata", SET_COMMON_METADATA, vars, DataReturn.class);
    }

    public DataReturn addChannels(String uuid, String channels) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(CHANNEL_PARAM, channels);

        return _client.CallAPI("AddChannels", ADD_CHANNELS, vars, DataReturn.class);
    }

    public QLDatasetDTO getChannels(String uuid) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);

        return _client.CallAPI("GetChannels", GET_CHANNELS, vars, QLDatasetDTO.class);
    }

    public DataReturn rebuildDataset(String uuid, int version,
                                     int time, int channel, int angle
    ) throws IOException, GraphQLException {
        Map<String, Object> vars = new HashMap<>();
        vars.put(UUID, uuid);
        vars.put(VERSION_PARAM, version);
        vars.put(TIME_PARAM, time);
        vars.put(CHANNEL_PARAM, channel);
        vars.put(ANGLE_PARAM, angle);

        return _client.CallAPI("Rebuild", REBUILD, vars, DataReturn.class);
    }

    private static final String START_DATASERVER = "query StartDataServer(\n" +
            "  $uuid: String!, \n" +
            "  $RxParam: Int!, \n" +
            "  $RyParam: Int!, \n" +
            "  $RzParam: Int!, \n" +
            "  $mode: String!, \n" +
            "  $timeout: BigInteger!, \n" +
            "  $versionParam: String!\n" +
            ") {\n" +
            "  StartDataserver(\n" +
            "    uuid: $uuid,\n" +
            "    RxParam: $RxParam,\n" +
            "    RyParam: $RyParam,\n" +
            "    RzParam: $RzParam,\n" +
            "    mode: $mode,\n" +
            "    timeout: $timeout,\n" +
            "    versionParam: $versionParam\n" +
            "  )\n" +
            "}";

    private static final String START_WRITE_DATASERVER = "query StartWriteDataserver(\n" +
            "  $RxParam: Int!, \n" +
            "  $RyParam: Int!, \n" +
            "  $RzParam: Int!, \n" +
            "  $resolutionParam: String!, \n" +
            "  $timeout: BigInteger!, \n" +
            "  $uuid: String!\n" +
            ") {\n" +
            "  StartWriteDataserver(\n" +
            "    RxParam: $RxParam\n" +
            "    RyParam: $RyParam\n" +
            "    RzParam: $RzParam\n" +
            "    resolutionParam: $resolutionParam\n" +
            "    timeout: $timeout\n" +
            "    uuid: $uuid\n" +
            "  )\n" +
            "}\n";

    private static final String CREATE_EMPTY_DATASET = "mutation CreateEmptyDataset($datasetDTO: QLDatasetDTOInput!) {\n" +
            "  CreateEmptyDataset(DatasetDTO: $datasetDTO)\n" +
            "}";

    private static final String ADD_EXISTING_DATASET = "mutation AddExistingDataset($uuid: String!) {\n" +
            "  AddExistingDataset(uuid: $uuid) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private static final String QUERY_DATASET = "query QueryDataset($uuid: String!) {\n" +
            "  QueryDataset(uuid: $uuid) {\n" +
            "    uuid\n" +
            "    angles\n" +
            "    channels\n" +
            "    timepoints\n" +
            "    dimensions\n" +
            "    voxelType\n" +
            "    voxelUnit\n" +
            "    voxelResolution\n" +
            "    compression\n" +
            "    label\n" +
            "    datasetType\n" +
            "    versions\n" +
            "    timepointIds\n" +
            "    angleResolution {\n" +
            "      value\n" +
            "      unit\n" +
            "    }\n" +
            "    channelResolution {\n" +
            "      value\n" +
            "      unit\n" +
            "    }\n" +
            "    timepointResolution {\n" +
            "      value\n" +
            "      unit\n" +
            "    }\n" +
            "    resolutionLevels {\n" +
            "      resolutions\n" +
            "      blockDimensions\n" +
            "    }\n" +
            "    viewRegistrations {\n" +
            "      angle\n" +
            "      channel\n" +
            "      time\n" +
            "      transformations {\n" +
            "        name\n" +
            "        rowPackedMatrix\n" +
            "      }\n" +
            "    }\n" +
            "    transformations\n" +
            "  }\n" +
            "}";

    private static final String DELETE_DATASET = "mutation DeleteDataset($uuid: String!) {\n" +
            "  DeleteDataset(uuid: $uuid) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private static final String DELETE_DATASET_VERSION = "mutation DeleteDatasetVersions(\n" +
            "  $uuid: String!,\n" +
            "  $versionParam: String!,\n" +
            "  $versionParams: String!\n" +
            ") {\n" +
            "  DeleteDatasetVersions(\n" +
            "    uuid: $uuid,\n" +
            "    versionParam: $versionParam,\n" +
            "    versionParams: $versionParams\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private static final String GET_COMMON_METADATA = "query GetCommonMetadata($uuid: String!) {\n" +
            "  GetCommonMetadata(uuid: $uuid) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private static final String SET_COMMON_METADATA = "mutation SetCommonMetadata(\n" +
            "  $uuid: String!,\n" +
            "  $metadata: String!\n" +
            ") {\n" +
            "  SetCommonMetadata(\n" +
            "    uuid: $uuid,\n" +
            "    metadata: $metadata\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}";

    private static final String ADD_CHANNELS = "mutation AddChannels($channels: String!, $uuid: String!) {\n" +
            "  AddChannels(channels: $channels, uuid: $uuid) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}\n";

    private static final String GET_CHANNELS = "query GetChannels($uuid: String!) {\n" +
            "  GetChannels(uuid: $uuid) {\n" +
            "    angleResolution {\n" +
            "      unit\n" +
            "      value\n" +
            "    }\n" +
            "    angles\n" +
            "    channelResolution {\n" +
            "      unit\n" +
            "      value\n" +
            "    }\n" +
            "    channels\n" +
            "    compression\n" +
            "    datasetType\n" +
            "    dimensions\n" +
            "    label\n" +
            "    resolutionLevels {\n" +
            "      blockDimensions\n" +
            "      resolutions\n" +
            "    }\n" +
            "    timepointIds\n" +
            "    timepointResolution {\n" +
            "      unit\n" +
            "      value\n" +
            "    }\n" +
            "    timepoints\n" +
            "    transformations\n" +
            "    uuid\n" +
            "    versions\n" +
            "    viewRegistrations {\n" +
            "      angle\n" +
            "      channel\n" +
            "      time\n" +
            "      transformations {\n" +
            "        name\n" +
            "        rowPackedMatrix\n" +
            "      }\n" +
            "    }\n" +
            "    voxelResolution\n" +
            "    voxelType\n" +
            "    voxelUnit\n" +
            "  }\n" +
            "}\n";

    private static final String REBUILD = "mutation Rebuild(\n" +
            "  $ANGLE: Int!, \n" +
            "  $CHANNEL: Int!, \n" +
            "  $TIME: Int!, \n" +
            "  $uuid: String!, \n" +
            "  $versionParam: Int!\n" +
            ") {\n" +
            "  Rebuild(\n" +
            "    ANGLE: $ANGLE\n" +
            "    CHANNEL: $CHANNEL\n" +
            "    TIME: $TIME\n" +
            "    uuid: $uuid\n" +
            "    versionParam: $versionParam\n" +
            "  ) {\n" +
            "    data\n" +
            "    returnType\n" +
            "  }\n" +
            "}\n";
}
