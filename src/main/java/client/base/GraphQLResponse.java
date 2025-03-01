package client.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class GraphQLResponse<T> {

    @JsonProperty("data")
    private DataWrapper<T> Data;

    @JsonProperty("errors")
    ArrayList<GraphQLError> Errors;
}
