package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.dto.CarClassDto;
import com.project0.ProjektGrupowy.service.CarClassService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarClassServiceTests {

    @Autowired
    private CarClassService carClassService;

    @Test
    public void testFindCarClassById() {
        CarClassDto requestedCarClass = carClassService.findCarClassById(1L);
        Assert.assertEquals("Klasa miejska", requestedCarClass.getCarClassName());
    }

    @Test
    public void testGetAllCarClasses() {
        List<CarClassDto> allCarClassesList = carClassService.getAllCarClasses();
        Assert.assertNotNull(allCarClassesList);
    }
}
