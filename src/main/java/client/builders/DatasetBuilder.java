package client.builders;

public class DatasetBuilder {
    private StringBuilder sb;

    public DatasetBuilder() {
        this.sb = new StringBuilder();
    }

    public String build() {
        return sb.toString();
    }

    public void uuid() {
        sb.append("uuid\n");
    }

    public void angles() {
        sb.append("angles\n");
    }

    public void channels() {
        sb.append("channels\n");
    }

    public void timepoints() {
        sb.append("timepoints\n");
    }

    public void dimensions() {
        sb.append("dimensions\n");
    }

    public void voxelType() {
        sb.append("voxelType\n");
    }

    public void voxelUnit() {
        sb.append("voxelUnit\n");
    }

    public void voxelResolution() {
        sb.append("voxelResolution\n");
    }

    public void compression() {
        sb.append("compression\n");
    }

    public void label () {
        sb.append("label\n");
    }

    public void datasetType() {
        sb.append("datasetType\n");
    }

    public void versions() {
        sb.append("versions\n");
    }

    public void timepointIds() {
        sb.append("timepointIds\n");
    }

    public void angleResolution(ResolutionBuilder b) {
        sb.append("angleResolution {\n");
        sb.append(b.build());
        sb.append("}\n");
    }

    public void channelResolution(ResolutionBuilder b) {
        sb.append("channelResolution {\n");
        sb.append(b.build());
        sb.append("}\n");
    }

    public void timepointResolution(ResolutionBuilder b) {
        sb.append("timepointResolution {\n");
        sb.append(b.build());
        sb.append("}\n");
    }

    public void resolutionLevels(ResolutionLevelBuilder b) {
        sb.append("resolutionLevels {\n");
        sb.append(b.build());
        sb.append("}\n");
    }

    public void viewRegistration(ViewRegistrationBuilder b) {
        sb.append("viewRegistration {\n");
        sb.append(b.build());
        sb.append("}\n");
    }

    public void transformations(ViewTransformBuilder b) {
        sb.append("transformations {\n");
        sb.append(b.build());
        sb.append("}\n");
    }
}
