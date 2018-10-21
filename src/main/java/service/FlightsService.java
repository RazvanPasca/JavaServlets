package service;

import entities.Flight;
import repository.FlightsRepo;

import java.util.List;

public class FlightsService {

    private FlightsRepo flightsRepo = new FlightsRepo();

    public List<Flight> findAllFlights() {
        return flightsRepo.findAllFlights();
    }

}
