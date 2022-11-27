package com.cityparking.management.restapi.controller;

import com.cityparking.management.converter.CityConverter;
import com.cityparking.management.dto.CityDTO;
import com.cityparking.management.model.City;
import com.cityparking.management.restapi.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO city) {
        City createdCity = cityService.createCity(CityConverter.fromDTO(city));
        return ResponseEntity.ok(CityConverter.toDTO(createdCity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable String id) {
        City foundCity = cityService.getById(id);
        if (foundCity != null) {
            return ResponseEntity.ok(CityConverter.toDTO(foundCity));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CityDTO> getByCode(@PathVariable String code) {
        City foundCity = cityService.getByCode(code);
        if (foundCity != null) {
            return ResponseEntity.ok(CityConverter.toDTO(foundCity));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityDTO>> getAll() {
        return ResponseEntity.ok(cityService.getAll().stream()
                .map(CityConverter::toDTO)
                .collect(Collectors.toList()));
    }

}
