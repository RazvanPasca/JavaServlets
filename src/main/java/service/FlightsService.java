package service;

import entities.CityEntity;
import entities.FlightEntity;
import lombok.Getter;
import lombok.Setter;
import repository.CityRepo;
import repository.FlightsRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class FlightsService {

    private FlightsRepo flightsRepo;
    private CityRepo cityRepo;

    public FlightsService(FlightsRepo flightsRepo) {
        this.flightsRepo = flightsRepo;
    }

    private static Map<Integer, FlightEntity> flightsMap = null;

    public List<FlightEntity> findAllFlights() {

        if (flightsMap == null) {
            List<FlightEntity> flightEntities = flightsRepo.findAllFlights();
            flightsMap = flightEntities.stream().collect(Collectors.toMap(FlightEntity::getId, e -> e));
            return flightEntities;
        }
        return new ArrayList<>(flightsMap.values());
    }

    public FlightEntity getFlightById(int id) {
        return flightsMap.get(id);
    }

    public void saveFlight(String airplaneType, String departureCity, LocalDateTime departureDate,
                           String arrivalCity, LocalDateTime arrivalDate) {

        CityEntity arrivalCityEntity = cityRepo.findCitiesByName(arrivalCity).get(0);
        CityEntity departureCityEntity = cityRepo.findCitiesByName(departureCity).get(0);

        FlightEntity flightEntity = FlightEntity.builder().airplaneType(airplaneType).arrivalCity(arrivalCityEntity)
                                                .departureCity(departureCityEntity).arrivalTime(arrivalDate)
                                                .departureTime(departureDate).build();

        flightsRepo.saveFlight(flightEntity);
    }
}
