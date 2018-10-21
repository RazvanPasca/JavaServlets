package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@AllArgsConstructor
@Value
class City {

    private String name;
    private double lattitude;
    private double longitude;
}
