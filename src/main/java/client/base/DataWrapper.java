package client.base;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DataWrapper<T> {
    private Map<String, T> queryResults = new HashMap<>();

    @JsonAnySetter
    public void setQueryResult(String key, T value) {
        queryResults.put(key, value);
    }
}
