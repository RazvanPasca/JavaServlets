package service;

import entities.CityEntity;
import repository.CityRepo;

import java.util.concurrent.ThreadLocalRandom;

public class CityService {
    private CityRepo cityRepo;
    private final int min = 0;
    private final int max = 50;

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public CityEntity saveCity(String cityName) {

        int id = ThreadLocalRandom.current().nextInt(0, max * max * max);
        double longitude = roundToTwo(ThreadLocalRandom.current().nextDouble(min, max));
        double lattitude = roundToTwo(ThreadLocalRandom.current().nextDouble(min, max));
        CityEntity cityEntity = CityEntity.builder().name(cityName).lattitude(lattitude).longitude(longitude).id(id)
                                          .build();
        return cityRepo.saveCity(cityEntity);
    }

    public CityEntity findCityByName(String cityName) {
        return cityRepo.findCityByName(cityName);
    }

    private double roundToTwo(double number){
        return Math.floor(number * 100) / 100;
    }

}
