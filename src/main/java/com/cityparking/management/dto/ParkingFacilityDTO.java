package com.cityparking.management.dto;

public class ParkingFacilityDTO {
    private String id;
    private String name;
    private int capacity;
    private int availableCapacity;
    private String cityCode;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public void setCity(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getId() {
        return id;
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

    public String getCityCode() {
        return cityCode;
    }
}
