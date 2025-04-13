package client.builders;

public class ViewRegistrationBuilder {
    private StringBuilder sb;

    public ViewRegistrationBuilder() {
        sb = new StringBuilder();
    }

    public ViewRegistrationBuilder angle() {
        sb.append("angle\n");
        return this;
    }

    public ViewRegistrationBuilder channel() {
        sb.append("channel\n");
        return this;
    }

    public ViewRegistrationBuilder time() {
        sb.append("time\n");
        return this;
    }

    public ViewRegistrationBuilder transformations(ViewTransformBuilder b) {
        sb.append("transformations {\n");
        sb.append(b.build());
        sb.append("}\n");
        return this;
    }

    public String build() {
        return sb.toString();
    }
}
