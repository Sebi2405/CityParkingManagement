package com.cityparking.management.converter;

import com.cityparking.management.dto.ParkingFacilityDTO;
import com.cityparking.management.model.ParkingFacility;

public class ParkingFacilityConverter {
    public static ParkingFacilityDTO toDTO(ParkingFacility parkingFacility) {
        if (parkingFacility == null) {
            return null;
        }

        ParkingFacilityDTO dto = new ParkingFacilityDTO();
        dto.setId(parkingFacility.getId());
        dto.setCapacity(parkingFacility.getCapacity());
        dto.setAvailableCapacity(parkingFacility.getAvailableCapacity());
        dto.setName(parkingFacility.getName());
        dto.setCity(parkingFacility.getCity().getCode());
        return dto;
    }
}
