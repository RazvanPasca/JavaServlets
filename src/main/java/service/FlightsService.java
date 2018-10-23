package service;

import entities.FlightEntity;
import repository.FlightsRepo;

import java.util.List;

public class FlightsService {

    private FlightsRepo flightsRepo = new FlightsRepo();

    public List<FlightEntity> findAllFlights() {
        return flightsRepo.findAllFlights();
    }

}
