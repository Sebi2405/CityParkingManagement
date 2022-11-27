package com.cityparking.management.converter;

import com.cityparking.management.dto.VehicleDTO;
import com.cityparking.management.model.Bike;
import com.cityparking.management.model.Car;
import com.cityparking.management.model.City;
import com.cityparking.management.model.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TEST_VehicleConverter {

    @Test
    public void convertVehicleToDTO_nullModel() {
        Vehicle vehicle = null;
        VehicleDTO dto = VehicleConverter.toDTO(vehicle);

        assertNull(dto);
    }

    @Test
    public void convertVehicleToDTO_completeModel() {
        Vehicle vehicle = new Car();
        vehicle.setParked(false);
        City city = new City();
        city.setCode("code");
        vehicle.setCity(city);
        vehicle.setId("12");
        vehicle.setParkingFacilityId("13");

        VehicleDTO dto = VehicleConverter.toDTO(vehicle);

        assertEquals("12", dto.getId());
        assertEquals("13", dto.getParkingFacilityId());
        assertEquals("code", dto.getCityCode());
        assertFalse(dto.isParked());
    }

    @Test
    public void convertVehicleToDTO_missingCity() {
        Vehicle vehicle = new Bike();
        vehicle.setParked(true);
        vehicle.setId("12");
        vehicle.setParkingFacilityId("13");

        VehicleDTO dto = VehicleConverter.toDTO(vehicle);

        assertEquals("12", dto.getId());
        assertEquals("13", dto.getParkingFacilityId());
        assertTrue(dto.isParked());
    }
}
