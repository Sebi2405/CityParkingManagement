package com.cityparking.management.restapi.service.impl;

import com.cityparking.management.model.City;
import com.cityparking.management.restapi.repository.CityRepository;
import com.cityparking.management.restapi.service.CityService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City getById(String id) {
        Optional<City> city = cityRepository.findById(id);
        return city.orElse(null);
    }

    @Override
    public City getByCode(String code) {
        Optional<City> city = cityRepository.findByCode(code);
        return city.orElse(null);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
