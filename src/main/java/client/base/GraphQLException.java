package client.base;


import java.util.ArrayList;

public class GraphQLException extends Exception {
    ArrayList<GraphQLError> Errors;

    public GraphQLException(ArrayList<GraphQLError> errors) {
        Errors = errors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (GraphQLError error : Errors) {
            sb.append(error.toString())
                    .append("\n");
        }
        return sb.toString();
    }
}
