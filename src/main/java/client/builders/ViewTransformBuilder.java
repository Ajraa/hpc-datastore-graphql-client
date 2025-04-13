package client.builders;

public class ViewTransformBuilder {
    private StringBuilder sb;

    public ViewTransformBuilder() {
        sb = new StringBuilder();
    }

    public void name() {
        sb.append("name\n");
    }

    public void rowPackedMatrix() {
        sb.append("rowPackedMatrix\n");
    }

    public String build() {
        return sb.toString();
    }
}
