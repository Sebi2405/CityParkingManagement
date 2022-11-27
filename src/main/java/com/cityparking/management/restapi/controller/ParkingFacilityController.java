package com.cityparking.management.restapi.controller;

import com.cityparking.management.converter.ParkingFacilityConverter;
import com.cityparking.management.dto.CreateParkingFacilityDTO;
import com.cityparking.management.dto.ParkingFacilityDTO;
import com.cityparking.management.factory.ParkingFacilityFactory;
import com.cityparking.management.model.City;
import com.cityparking.management.model.ParkingFacility;
import com.cityparking.management.restapi.service.CityService;
import com.cityparking.management.restapi.service.ParkingFacilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parkingFacility")
public class ParkingFacilityController {
    private final CityService cityService;

    private final ParkingFacilityService parkingFacilityService;

    public ParkingFacilityController(CityService cityService, ParkingFacilityService parkingFacilityService) {
        this.cityService = cityService;
        this.parkingFacilityService = parkingFacilityService;
    }

    @PostMapping
    public ResponseEntity<ParkingFacilityDTO> createParkingFacility(@RequestBody CreateParkingFacilityDTO dto) {
        City foundCity = cityService.getByCode(dto.getCityCode());
        if (foundCity == null) {
            return ResponseEntity.notFound().build();
        }
        ParkingFacility parkingFacility = parkingFacilityService.createParkingFacility(dto, foundCity);
        return ResponseEntity.ok(ParkingFacilityConverter.toDTO(parkingFacility));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingFacilityDTO> getById(@PathVariable String id) {
        ParkingFacility parkingFacility = parkingFacilityService.getById(id);
        if (parkingFacility != null) {
            return ResponseEntity.ok(ParkingFacilityConverter.toDTO(parkingFacility));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/city/{cityCode}")
    public ResponseEntity<List<ParkingFacilityDTO>> getAllByCityCode(@PathVariable String cityCode) {
        City city = cityService.getByCode(cityCode);
        if (city == null) {
            return ResponseEntity.notFound().build();
        }

        Set<ParkingFacility> parkingFacilities = city.getParkingFacilities();
        return ResponseEntity.ok(parkingFacilities.stream()
                .map(ParkingFacilityConverter::toDTO)
                .collect(Collectors.toList()));
    }

}
