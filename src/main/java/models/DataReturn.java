package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataReturn {

    private String data;
    private ReturnType returnType;

    public enum ReturnType {
        BASE64, HTML, JSON, SUCCESS, TEXT, XML
    }

}
