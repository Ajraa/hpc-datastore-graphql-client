package client.builders;

public class DatasetBuilder {
    private StringBuilder sb;

    public DatasetBuilder() {
        this.sb = new StringBuilder();
    }

    public String build() {
        return sb.toString();
    }

    public DatasetBuilder uuid() {
        sb.append("uuid\n");
        return this;
    }

    public DatasetBuilder angles() {
        sb.append("angles\n");
        return this;
    }

    public DatasetBuilder channels() {
        sb.append("channels\n");
        return this;
    }

    public DatasetBuilder timepoints() {
        sb.append("timepoints\n");
        return this;
    }

    public DatasetBuilder dimensions() {
        sb.append("dimensions\n");
        return this;
    }

    public DatasetBuilder voxelType() {
        sb.append("voxelType\n");
        return this;
    }

    public DatasetBuilder voxelUnit() {
        sb.append("voxelUnit\n");
        return this;
    }

    public DatasetBuilder voxelResolution() {
        sb.append("voxelResolution\n");
        return this;
    }

    public DatasetBuilder compression() {
        sb.append("compression\n");
        return this;
    }

    public DatasetBuilder label () {
        sb.append("label\n");
        return this;
    }

    public DatasetBuilder datasetType() {
        sb.append("datasetType\n");
        return this;
    }

    public DatasetBuilder versions() {
        sb.append("versions\n");
        return this;
    }

    public DatasetBuilder timepointIds() {
        sb.append("timepointIds\n");
        return this;
    }

    public DatasetBuilder angleResolution(ResolutionBuilder b) {
        sb.append("angleResolution {\n");
        sb.append(b.build());
        sb.append("}\n");
        return this;
    }

    public DatasetBuilder channelResolution(ResolutionBuilder b) {
        sb.append("channelResolution {\n");
        sb.append(b.build());
        sb.append("}\n");
        return this;
    }

    public DatasetBuilder timepointResolution(ResolutionBuilder b) {
        sb.append("timepointResolution {\n");
        sb.append(b.build());
        sb.append("}\n");
        return this;
    }

    public DatasetBuilder resolutionLevels(ResolutionLevelBuilder b) {
        sb.append("resolutionLevels {\n");
        sb.append(b.build());
        sb.append("}\n");
        return this;
    }

    public DatasetBuilder viewRegistration(ViewRegistrationBuilder b) {
        sb.append("viewRegistration {\n");
        sb.append(b.build());
        sb.append("}\n");
        return this;
    }

    public DatasetBuilder transformations(ViewTransformBuilder b) {
        sb.append("transformations {\n");
        sb.append(b.build());
        sb.append("}\n");
        return this;
    }
}
