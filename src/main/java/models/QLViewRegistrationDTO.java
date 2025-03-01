package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QLViewRegistrationDTO {
    private int angle;
    private int channel;
    private int time;
    private List<QLViewTransformDTO> transformations;
}
