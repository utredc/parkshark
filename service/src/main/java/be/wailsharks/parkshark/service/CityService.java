package be.wailsharks.parkshark.service;


import be.wailsharks.parkshark.domain.common.City;
import be.wailsharks.parkshark.domain.common.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getCityByID(long id) {
        return cityRepository.findById(id).get();
    }
}
