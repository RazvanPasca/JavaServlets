package entities;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Flight {

    private long flightNr;
    private String airplaneType;
    private City departureCity;
    private City arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

}
