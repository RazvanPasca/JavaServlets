package service;

import entities.FlightEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import repository.FlightsRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class FlightsService {

    private FlightsRepo flightsRepo;

    private static Map<Integer, FlightEntity> flightsMap;

    public List<FlightEntity> findAllFlights() {

        List<FlightEntity> flightEntities = flightsRepo.findAllFlights();

        flightsMap = flightEntities.stream().collect(Collectors.toMap(FlightEntity::getId, e -> e));

        return flightEntities;
    }

    public FlightEntity getFlightById(int id) {
        return flightsMap.get(id);
    }

}
