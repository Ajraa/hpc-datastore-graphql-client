package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QLViewTransformDTO {
    private String name;
    private List<Float> rowPackedMatrix;
}
