package com.cityparking.management.restapi.controller;

import com.cityparking.management.converter.VehicleConverter;
import com.cityparking.management.dto.CreateVehicleDTO;
import com.cityparking.management.dto.VehicleDTO;
import com.cityparking.management.model.City;
import com.cityparking.management.model.ParkingFacility;
import com.cityparking.management.model.Vehicle;
import com.cityparking.management.restapi.service.CityService;
import com.cityparking.management.restapi.service.ParkingFacilityService;
import com.cityparking.management.restapi.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    private final CityService cityService;

    private final ParkingFacilityService parkingFacilityService;

    public VehicleController(VehicleService vehicleService, CityService cityService,
                             ParkingFacilityService parkingFacilityService) {
        this.vehicleService = vehicleService;
        this.cityService = cityService;
        this.parkingFacilityService = parkingFacilityService;
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody CreateVehicleDTO dto) {
        City foundCity = cityService.getByCode(dto.getCityCode());
        if (foundCity == null) {
            return ResponseEntity.notFound().build();
        }
        Vehicle vehicle = vehicleService.createVehicle(dto, foundCity);
        return ResponseEntity.ok(VehicleConverter.toDTO(vehicle));
    }

    @GetMapping("/city/{cityCode}")
    public ResponseEntity<List<VehicleDTO>> getAllByCityCode(@PathVariable String cityCode) {
        City foundCity = cityService.getByCode(cityCode);
        if (foundCity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehicleService.getAllByCityCode(foundCity).stream()
                .map(VehicleConverter::toDTO)
                .collect(Collectors.toList()));
    }

    @PutMapping("/park/vehicleId/{vehicleId}/parkingFacilityId/{parkingFacilityId}")
    public ResponseEntity<Boolean> parkVehicle(@PathVariable String vehicleId, @PathVariable String parkingFacilityId) {
        Vehicle vehicle = vehicleService.getById(vehicleId);
        ParkingFacility parkingFacility = parkingFacilityService.getById(parkingFacilityId);
        if (vehicle == null || parkingFacility == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicleService.parkVehicle(vehicle, parkingFacility));
    }

    @PutMapping("/unpark/vehicleId/{vehicleId}/parkingFacilityId/{parkingFacilityId}")
    public ResponseEntity<Boolean> unparkVehicle(@PathVariable String vehicleId, @PathVariable String parkingFacilityId) {
        Vehicle vehicle = vehicleService.getById(vehicleId);
        ParkingFacility parkingFacility = parkingFacilityService.getById(parkingFacilityId);
        if (vehicle == null || parkingFacility == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicleService.unparkVehicle(vehicle, parkingFacility));
    }

}
