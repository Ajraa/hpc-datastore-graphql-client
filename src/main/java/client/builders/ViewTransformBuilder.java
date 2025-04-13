package client.builders;

public class ViewTransformBuilder {
    private StringBuilder sb;

    public ViewTransformBuilder() {
        sb = new StringBuilder();
    }

    public ViewTransformBuilder name() {
        sb.append("name\n");
        return this;
    }

    public ViewTransformBuilder rowPackedMatrix() {
        sb.append("rowPackedMatrix\n");
        return this;
    }

    public String build() {
        return sb.toString();
    }
}
