package com.cityparking.management.converter;

import com.cityparking.management.dto.CityDTO;
import com.cityparking.management.model.City;

public class CityConverter {
    public static City fromDTO(CityDTO dto) {
        if (dto == null) {
            return null;
        }
        City city = new City();
        city.setCode(dto.getCode());
        city.setName(dto.getName());
        return city;
    }

    public static CityDTO toDTO(City city) {
        if (city == null) {
            return null;
        }
        CityDTO dto = new CityDTO();
        dto.setId(city.getId());
        dto.setCode(city.getCode());
        dto.setName(city.getName());
        return dto;
    }
}
