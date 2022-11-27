package com.cityparking.management.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "City")
public class City {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column(length = 4)
    private String code;

    @OneToMany
    private Set<ParkingFacility> parkingFacilities = new HashSet<>();

    public City() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setParkingFacilities(Set<ParkingFacility> parkingFacilities) {
        this.parkingFacilities = parkingFacilities;
    }
}
