package com.cityparking.management.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ParkingFacility {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column
    private int capacity;

    @Column
    private int availableCapacity;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

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

    public void setCity(City city) {
        this.city = city;
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

    public City getCity() {
        return city;
    }
}
