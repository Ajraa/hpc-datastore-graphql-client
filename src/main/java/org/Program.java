package org;

import client.RegisterService;
import client.base.GraphQLClient;
import client.base.GraphQLException;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IOException, GraphQLException {
        GraphQLClient client = GraphQLClient.getInstance("http://localhost:8080/graphql");
        RegisterService registerService = new RegisterService(client);
        UUID id = registerService.createEmptyDataset(getDatasetDTO());
        String idString = id.toString();
        URI url = registerService.startServer(idString, 1, 1, 1, "new", 60000, "write");

    }

    private static models.QLDatasetDTO getDatasetDTO() {
        models.QLDatasetDTO ret = new models.QLDatasetDTO();

        ret.setVoxelType("uint32");
        List<Long> dimensions = new ArrayList<>();
        dimensions.add(1000L);
        dimensions.add(1000L);
        dimensions.add(1L);

        ret.setDimensions(dimensions);
        ret.setTimepoints(2);
        ret.setChannels(2);
        ret.setAngles(2);
        ret.setVoxelUnit("um");

        List<Float> voxelResolution = new ArrayList<>();
        voxelResolution.add(0.4f);
        voxelResolution.add(0.4f);
        voxelResolution.add(1.0f);
        ret.setVoxelResolution(voxelResolution);

        ret.setTimepointResolution(new models.QLResolution("min", 1));
        ret.setChannelResolution(new models.QLResolution(null, 0));
        ret.setAngleResolution(new models.QLResolution(null, 0));

        ret.setCompression("raw");

        List<models.QLResolutionLevel> resolutionLevels = new ArrayList<>();
        resolutionLevels.add(new models.QLResolutionLevel(Arrays.asList(1, 1, 1), Arrays.asList(64, 64, 64)));
        resolutionLevels.add(new models.QLResolutionLevel(Arrays.asList(2, 2, 1), Arrays.asList(64, 64, 64)));

        ret.setResolutionLevels(resolutionLevels);
        return ret;
    }
}
