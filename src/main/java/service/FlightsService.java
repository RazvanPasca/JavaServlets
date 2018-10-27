package service;

import entities.FlightEntity;
import lombok.AllArgsConstructor;
import repository.FlightsRepo;

import java.util.List;

@AllArgsConstructor
public class FlightsService {

    private FlightsRepo flightsRepo;

    public List<FlightEntity> findAllFlights() {
        return flightsRepo.findAllFlights();
    }

}
