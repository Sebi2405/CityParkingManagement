package com.cityparking.management.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ParkingFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id;

    @Column
    private String name;

    @Column
    private int capacity;

    @Column
    private int availableCapacity;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}
