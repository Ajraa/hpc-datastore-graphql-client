package client.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class GraphQLQuery {

    private String query;
    private Map<String, Object> variables;


    public GraphQLQuery(String query, Map<String, Object> variables) {
        this.query = query;
        this.variables = variables;
    }
}
