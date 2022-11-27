package com.cityparking.management.dto;

public class VehicleDTO {
    private String id;
    private String cityCode;
    private boolean isParked;
    private String parkingFacilityId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public String getParkingFacilityId() {
        return parkingFacilityId;
    }

    public void setParkingFacilityId(String parkingFacilityId) {
        this.parkingFacilityId = parkingFacilityId;
    }
}
