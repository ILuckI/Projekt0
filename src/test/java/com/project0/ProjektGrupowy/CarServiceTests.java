package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.service.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTests {

    @Autowired
    private CarService carService;

    @Test
    public void testGetAllCars() {
        List<CarDto> allCarsList = carService.getAllCars();
        Assert.assertNotNull(allCarsList);
    }

    @Test
    public void testFindByNameFragment() {
        List<CarDto> carsByNameFragment = carService.findByNameFragment("BMW");
        Assert.assertEquals("BMW 318 GT", carsByNameFragment.get(0).getCarName());
    }

    @Test
    public void testFindByNme() {
        Assert.assertEquals(10L, carService.findCarIdByName("Mercedes Vito"));
    }



}
