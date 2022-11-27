package com.cityparking.management.dto;

import com.cityparking.management.model.VehicleType;

public class CreateVehicleDTO {
    private String cityCode;
    private String parkingFacilityId;
    private VehicleType type;

    public String getCityCode() {
        return cityCode;
    }

    public String getParkingFacilityId() {
        return parkingFacilityId;
    }

    public VehicleType getType() {
        return type;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setParkingFacilityId(String parkingFacilityId) {
        this.parkingFacilityId = parkingFacilityId;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
