package com.cityparking.management.factory;

import com.cityparking.management.dto.CreateParkingFacilityDTO;
import com.cityparking.management.model.BikeRack;
import com.cityparking.management.model.CarPark;
import com.cityparking.management.model.ParkingFacility;
import com.cityparking.management.model.ParkingFacilityType;
import org.springframework.stereotype.Component;

@Component
public class ParkingFacilityFactory {

    public ParkingFacility createParkingFacility(CreateParkingFacilityDTO dto) {
        ParkingFacility parkingFacility;
        if (ParkingFacilityType.CARPARK.equals(dto.getType())) {
            parkingFacility = new CarPark();
        } else if (ParkingFacilityType.BIKERACK.equals(dto.getType())) {
            parkingFacility = new BikeRack();
        } else {
            return null;
        }

        parkingFacility.setCapacity(dto.getCapacity());
        parkingFacility.setAvailableCapacity(dto.getAvailableCapacity());
        parkingFacility.setName(dto.getName());

        return parkingFacility;
    }
}
