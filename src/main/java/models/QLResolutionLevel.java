package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QLResolutionLevel {
    private List<Integer> blockDimensions;
    private List<Integer> resolutions;
}

