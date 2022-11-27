package com.cityparking.management.restapi.service;

import com.cityparking.management.dto.CreateParkingFacilityDTO;
import com.cityparking.management.model.City;
import com.cityparking.management.model.ParkingFacility;

public interface ParkingFacilityService {
    ParkingFacility createParkingFacility(CreateParkingFacilityDTO dto, City city);

    ParkingFacility getById(String id);
}
