package repository;

import entities.Flight;

import java.util.Arrays;
import java.util.List;

public class FlightsRepo {

    private Flight f1 = Flight.builder().flightNr(123).build();
    private Flight f2 = Flight.builder().flightNr(456).build();

    public List<Flight> findAllFlights() {
        return Arrays.asList(f2, f1);
    }


}
