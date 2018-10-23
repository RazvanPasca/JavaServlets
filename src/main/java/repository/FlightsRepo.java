package repository;

import entities.CityEntity;
import entities.FlightEntity;

import java.util.Arrays;
import java.util.List;

public class FlightsRepo {

    private CityEntity c1 = CityEntity.builder().lattitude(12).longitude(13).name("Cluj").build();
    private CityEntity c2 = CityEntity.builder().lattitude(55).longitude(23).name("Madrid").build();


    private FlightEntity f1 = FlightEntity.builder().flightNr(123).departureCity(c1).build();
    private FlightEntity f2 = FlightEntity.builder().flightNr(456).departureCity(c2).build();

    public List<FlightEntity> findAllFlights() {
        return Arrays.asList(f2, f1);
    }


}
