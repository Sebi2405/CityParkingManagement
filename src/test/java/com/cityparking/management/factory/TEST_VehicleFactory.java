package com.cityparking.management.factory;

import com.cityparking.management.dto.CreateVehicleDTO;
import com.cityparking.management.model.Bike;
import com.cityparking.management.model.Car;
import com.cityparking.management.model.Vehicle;
import com.cityparking.management.model.VehicleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TEST_VehicleFactory {

    @InjectMocks
    private VehicleFactory vehicleFactory;

    @Test
    public void createVehicle_car() {
        CreateVehicleDTO dto = new CreateVehicleDTO();
        dto.setParkingFacilityId("12");
        dto.setType(VehicleType.CAR);

        Vehicle vehicle = vehicleFactory.createVehicle(dto);

        assertEquals("12", vehicle.getParkingFacilityId());
        assertFalse(vehicle.isParked());
        assertTrue(vehicle instanceof Car);
    }

    @Test
    public void createVehicle_bike() {
        CreateVehicleDTO dto = new CreateVehicleDTO();
        dto.setParkingFacilityId("12");
        dto.setType(VehicleType.BIKE);

        Vehicle vehicle = vehicleFactory.createVehicle(dto);

        assertEquals("12", vehicle.getParkingFacilityId());
        assertFalse(vehicle.isParked());
        assertTrue(vehicle instanceof Bike);
    }

    @Test
    public void createVehicle_withoutType() {
        CreateVehicleDTO dto = new CreateVehicleDTO();
        dto.setParkingFacilityId("12");

        Vehicle vehicle = vehicleFactory.createVehicle(dto);

        assertNull(vehicle);
    }

}
