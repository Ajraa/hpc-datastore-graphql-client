package client.builders;

public class ResolutionLevelBuilder {
    private StringBuilder sb;

    public ResolutionLevelBuilder() {
        sb = new StringBuilder();
    }

    public ResolutionLevelBuilder blockDimensions() {
        sb.append("blockDimensions\n");
        return this;
    }

    public ResolutionLevelBuilder resolutions() {
        sb.append("resolutions\n");
        return this;
    }

    public String build() {
        return sb.toString();
    }
}
