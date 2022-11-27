package com.cityparking.management.restapi.repository;

import com.cityparking.management.model.City;
import com.cityparking.management.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    List<Vehicle> findByCity(City city);
}
