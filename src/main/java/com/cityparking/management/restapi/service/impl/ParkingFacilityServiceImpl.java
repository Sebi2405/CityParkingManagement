package com.cityparking.management.restapi.service.impl;

import com.cityparking.management.dto.CreateParkingFacilityDTO;
import com.cityparking.management.factory.ParkingFacilityFactory;
import com.cityparking.management.model.City;
import com.cityparking.management.model.ParkingFacility;
import com.cityparking.management.restapi.repository.ParkingFacilityRepository;
import com.cityparking.management.restapi.service.ParkingFacilityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ParkingFacilityServiceImpl implements ParkingFacilityService {

    private final ParkingFacilityFactory parkingFacilityFactory;

    private final ParkingFacilityRepository parkingFacilityRepository;

    public ParkingFacilityServiceImpl(ParkingFacilityFactory parkingFacilityFactory, ParkingFacilityRepository parkingFacilityRepository) {
        this.parkingFacilityFactory = parkingFacilityFactory;
        this.parkingFacilityRepository = parkingFacilityRepository;
    }

    @Override
    @Transactional
    public ParkingFacility createParkingFacility(CreateParkingFacilityDTO dto, City city) {
        ParkingFacility parkingFacility = parkingFacilityFactory.createParkingFacility(dto);
        if (parkingFacility == null) {
            return null;
        }

        parkingFacility.setCity(city);
        parkingFacility = parkingFacilityRepository.save(parkingFacility);

        city.addParkingFacility(parkingFacility);

        return parkingFacility;
    }

    @Override
    public ParkingFacility getById(String id) {
        Optional<ParkingFacility> parkingFacility = parkingFacilityRepository.findById(id);
        return parkingFacility.orElse(null);
    }
}
