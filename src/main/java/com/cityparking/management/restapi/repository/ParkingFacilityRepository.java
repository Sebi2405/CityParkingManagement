package com.cityparking.management.restapi.repository;

import com.cityparking.management.model.ParkingFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingFacilityRepository extends JpaRepository<ParkingFacility, String> {
}
