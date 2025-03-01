package client.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraphQLError {

    private String message;
    private ArrayList<Location> locations;
    private ArrayList<String> path;
    private GraphQLExtension extensions;

    @Getter
    public static class Location {
        private int line;
        private int column;
    }

    @Getter
    @Setter
    public static class GraphQLExtension {
        private String classification;
    }

    @Override
    public String toString() {
        return "Error: " + message + "\nLocations: " + locations + "\nPath: " + path + "\nExtensions: " + extensions.toString();
    }
}


