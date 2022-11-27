package com.cityparking.management.restapi.service;

import com.cityparking.management.model.City;

import java.util.List;

public interface CityService {
    City createCity(City city);

    City getById(String id);

    City getByCode(String code);

    List<City> getAll();
}
