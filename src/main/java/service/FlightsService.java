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

    private static Map<Integer, FlightEntity> flightsMap = null;

    public List<FlightEntity> findAllFlights() {

        if (flightsMap == null) {
            List<FlightEntity> flightEntities = flightsRepo.findAllFlights();
            flightsMap = flightEntities.stream().collect(Collectors.toMap(FlightEntity::getId, e -> e));
            return flightEntities;
        }
        return (List<FlightEntity>) flightsMap.values();
    }

    public FlightEntity getFlightById(int id) {
        return flightsMap.get(id);
    }

}
