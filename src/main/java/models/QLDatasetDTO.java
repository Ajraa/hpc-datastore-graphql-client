package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QLDatasetDTO {
    private QLResolution angleResolution;
    private int angles;
    private QLResolution channelResolution;
    private int channels;
    private String compression;
    private String datasetType;
    private List<Long> dimensions;
    private String label;
    private List<QLResolutionLevel> resolutionLevels;
    private List<Integer> timepointIds;
    private QLResolution timepointResolution;
    private int timepoints;
    private List<List<Float>> transformations;
    private String uuid;
    private List<Integer> versions;
    private List<QLViewRegistrationDTO> viewRegistrations;
    private List<Float> voxelResolution;
    private String voxelType;
    private String voxelUnit;
}
