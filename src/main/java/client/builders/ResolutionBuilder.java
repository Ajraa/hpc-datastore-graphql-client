package client.builders;

import models.QLResolution;

public class ResolutionBuilder {
    private StringBuilder sb;

    public ResolutionBuilder() {
        this.sb = new StringBuilder();
    }
    public ResolutionBuilder name() {
        sb.append("name\n");
        return this;
    }

    public ResolutionBuilder rowPackedmatrix() {
        sb.append("rowPackedMatrix\n");
        return this;
    }

    public String build() {
        return sb.toString();
    }
}
