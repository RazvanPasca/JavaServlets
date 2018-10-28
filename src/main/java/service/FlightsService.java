package service;

import entities.CityEntity;
import entities.FlightEntity;
import lombok.Getter;
import lombok.Setter;
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
    private CityService cityService;
    private static Map<Integer, FlightEntity> flightsMap = null;


    public FlightsService(FlightsRepo flightsRepo, CityService cityService) {
        this.flightsRepo = flightsRepo;
        this.cityService = cityService;
    }


    public List<FlightEntity> findAllFlights() {

        if (flightsMap == null || flightsRepo.wasDbChanged()) {
            List<FlightEntity> flightEntities = flightsRepo.findAllFlights();
            flightsMap = flightEntities.stream().collect(Collectors.toMap(FlightEntity::getId, e -> e));
            return flightEntities;
        } else
            return new ArrayList<>(flightsMap.values());
    }

    public FlightEntity getFlightById(int id) {
        return flightsMap.get(id);
    }

    public void saveFlight(String airplaneType, String departureCity, LocalDateTime departureDate,
                           String arrivalCity, LocalDateTime arrivalDate) {

        CityEntity arrivalCityEntity = cityService.findCityByName(arrivalCity);
        CityEntity departureCityEntity = cityService.findCityByName(departureCity);

        if (arrivalCityEntity == null) {
            arrivalCityEntity = cityService.saveCity(arrivalCity);
        }

        if (departureCityEntity == null) {
            departureCityEntity = cityService.saveCity(departureCity);
        }

        FlightEntity flightEntity = FlightEntity.builder().airplaneType(airplaneType).arrivalCity(arrivalCityEntity)
                                                .departureCity(departureCityEntity).arrivalTime(arrivalDate)
                                                .departureTime(departureDate).build();

        flightsRepo.saveFlight(flightEntity);
    }
}
