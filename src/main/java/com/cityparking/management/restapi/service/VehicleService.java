package com.cityparking.management.restapi.service;

import com.cityparking.management.dto.CreateVehicleDTO;
import com.cityparking.management.model.City;
import com.cityparking.management.model.ParkingFacility;
import com.cityparking.management.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(CreateVehicleDTO dto, City city);

    List<Vehicle> getAllByCityCode(City city);

    Vehicle getById(String id);

    boolean parkVehicle(Vehicle vehicle, ParkingFacility parkingFacility);

    boolean unparkVehicle(Vehicle vehicle, ParkingFacility parkingFacility);
}
