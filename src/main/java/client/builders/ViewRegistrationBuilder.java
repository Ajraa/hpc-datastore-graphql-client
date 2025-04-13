package client.builders;

public class ViewRegistrationBuilder {
    private StringBuilder sb;

    public ViewRegistrationBuilder() {
        sb = new StringBuilder();
    }

    public void angle() {
        sb.append("angle\n");
    }

    public void channel() {
        sb.append("channel\n");
    }

    public void time() {
        sb.append("time\n");
    }

    public void transformations(ViewTransformBuilder b) {
        sb.append("transformations {\n");
        sb.append(b.build());
        sb.append("}\n");
    }

    public String build() {
        return sb.toString();
    }
}
