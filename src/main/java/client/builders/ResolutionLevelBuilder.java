package client.builders;

public class ResolutionLevelBuilder {
    private StringBuilder sb;

    public ResolutionLevelBuilder() {
        sb = new StringBuilder();
    }

    public void blockDimensions() {
        sb.append("blockDimensions\n");
    }

    public void resolutions() {
        sb.append("resolutions\n");
    }

    public String build() {
        return sb.toString();
    }
}
