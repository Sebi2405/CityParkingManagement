package com.cityparking.management.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @Column
    private boolean isParked;

    @Column
    private String parkingFacilityId;

    public String getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public boolean isParked() {
        return isParked;
    }

    public String getParkingFacilityId() {
        return parkingFacilityId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public void setParkingFacilityId(String parkingFacilityId) {
        this.parkingFacilityId = parkingFacilityId;
    }
}
