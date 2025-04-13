package client.builders;

import models.QLResolution;

public class ResolutionBuilder {
    private StringBuilder sb;

    public ResolutionBuilder() {
        this.sb = new StringBuilder();
    }
    public void name() {
        sb.append("name\n");
    }

    public void rowPackedmatrix() {
        sb.append("rowPackedMatrix\n");
    }

    public String build() {
        return sb.toString();
    }
}
