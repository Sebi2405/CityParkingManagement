package com.cityparking.management.restapi.service.impl;

import com.cityparking.management.dto.CreateVehicleDTO;
import com.cityparking.management.factory.VehicleFactory;
import com.cityparking.management.model.City;
import com.cityparking.management.model.ParkingFacility;
import com.cityparking.management.model.Vehicle;
import com.cityparking.management.restapi.repository.ParkingFacilityRepository;
import com.cityparking.management.restapi.repository.VehicleRepository;
import com.cityparking.management.restapi.service.CityService;
import com.cityparking.management.restapi.service.VehicleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    private final VehicleFactory vehicleFactory;

    private final ParkingFacilityRepository parkingFacilityRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleFactory vehicleFactory,
                              ParkingFacilityRepository parkingFacilityRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleFactory = vehicleFactory;
        this.parkingFacilityRepository = parkingFacilityRepository;
    }

    @Override
    public Vehicle createVehicle(CreateVehicleDTO dto, City city) {
        Vehicle vehicle = vehicleFactory.createVehicle(dto);
        if (vehicle == null) {
            return null;
        }

        vehicle.setCity(city);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllByCityCode(City city) {
        return vehicleRepository.findByCity(city);
    }

    @Override
    public Vehicle getById(String id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.orElse(null);
    }

    @Override
    @Transactional
    public boolean parkVehicle(Vehicle vehicle, ParkingFacility parkingFacility) {
        if (vehicle.isParked()) {
            return false;
        }
        if (parkingFacility.getAvailableCapacity() == 0) {
            return false;
        }

        parkingFacility.setAvailableCapacity(parkingFacility.getAvailableCapacity() - 1);
        parkingFacilityRepository.save(parkingFacility);

        vehicle.setParkingFacilityId(parkingFacility.getId());
        vehicle.setParked(true);
        vehicleRepository.save(vehicle);

        return true;
    }

    @Override
    @Transactional
    public boolean unparkVehicle(Vehicle vehicle, ParkingFacility parkingFacility) {
        if (!vehicle.isParked()) {
            return false;
        }

        parkingFacility.setAvailableCapacity(parkingFacility.getAvailableCapacity() + 1);
        parkingFacilityRepository.save(parkingFacility);

        vehicle.setParked(false);
        vehicleRepository.save(vehicle);

        return true;
    }

}
