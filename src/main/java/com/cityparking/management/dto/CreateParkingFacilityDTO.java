package com.cityparking.management.dto;

import com.cityparking.management.model.ParkingFacilityType;

public class CreateParkingFacilityDTO {
    private String cityCode;
    private String name;
    private int capacity;
    private int availableCapacity;

    private ParkingFacilityType type;

    public String getCityCode() {
        return cityCode;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public ParkingFacilityType getType() {
        return type;
    }
}
