package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionParameters {
    private URI uri;
    private String uuid;

    @JsonProperty("rX")
    private long rx;

    @JsonProperty("rY")
    private long ry;

    @JsonProperty("rZ")
    private long rz;

    private String version;
}
