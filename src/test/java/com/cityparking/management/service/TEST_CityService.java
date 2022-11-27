package com.cityparking.management.service;

import com.cityparking.management.model.City;
import com.cityparking.management.restapi.repository.CityRepository;
import com.cityparking.management.restapi.service.impl.CityServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TEST_CityService {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    public void createCity() {
        City city = new City();
        city.setCode("code");
        city.setName("Cluj");
        city.setId("id");
        when(cityRepository.save(Mockito.any())).thenReturn(city);

        City createdCity = cityService.createCity(city);

        assertEquals("code", createdCity.getCode());
        assertEquals("Cluj", createdCity.getName());
        assertEquals("id", createdCity.getId());
    }

}
