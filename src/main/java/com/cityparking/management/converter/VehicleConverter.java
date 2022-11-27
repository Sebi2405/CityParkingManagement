package com.cityparking.management.converter;

import com.cityparking.management.dto.VehicleDTO;
import com.cityparking.management.model.Vehicle;

public class VehicleConverter {
    public static VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        if (vehicle.getCity() != null) {
            dto.setCityCode(vehicle.getCity().getCode());
        }
        dto.setParked(vehicle.isParked());
        dto.setParkingFacilityId(vehicle.getParkingFacilityId());
        return dto;
    }
}
