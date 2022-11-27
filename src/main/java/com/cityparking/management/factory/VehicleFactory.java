package com.cityparking.management.factory;

import com.cityparking.management.dto.CreateVehicleDTO;
import com.cityparking.management.model.Bike;
import com.cityparking.management.model.Car;
import com.cityparking.management.model.Vehicle;
import com.cityparking.management.model.VehicleType;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    public Vehicle createVehicle(CreateVehicleDTO dto) {
        Vehicle vehicle;
        if (VehicleType.CAR.equals(dto.getType())) {
            vehicle = new Car();
        } else if (VehicleType.BIKE.equals(dto.getType())) {
            vehicle = new Bike();
        } else {
            return null;
        }

        vehicle.setParked(false);
        vehicle.setParkingFacilityId(dto.getParkingFacilityId());

        return vehicle;
    }
}
