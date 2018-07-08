package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.controller.CarController;
import com.project0.ProjektGrupowy.dto.CarClassDto;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.dto.CarRentDto;
import com.project0.ProjektGrupowy.dto.PriceDto;
import com.project0.ProjektGrupowy.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjektGrupowyApplicationTests {

    @Autowired
    private I18NService i18NService;

    @Autowired
    private CarService carService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private CarClassService carClassService;

    @Autowired
    private CarController carController;

    @Autowired
    private CarRentService carRentService;


    //	Test i18n local message (Poprawnosc komunikatow lokalnych)
    @Test
    public void testMessageByLocaleService() throws Exception {
        String expectedResult = "Coders Team";
        String messageId = "navbar.coder.text";
        String actual = i18NService.getMessage(messageId);
        Assert.assertEquals("The actual and expected Strings don't match", expectedResult, actual);
    }

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
    public void testGetAllPrices() {
        List<PriceDto> allPricesList = priceService.getAllPrices();
        Assert.assertNotNull(allPricesList);
    }

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

    @Test
    public void testFindByNme(){
        Assert.assertEquals(10L,carService.findCarIdByName("Mercedes Vito"));
    }

//    @Test
//    public void testSave() {
//        Timestamp t1 = Timestamp.valueOf("2018-08-01 00:00:00.00");
//        Timestamp t2 = Timestamp.valueOf("2018-08-10 00:00:00.00");
//        CarRentDto carRentDto = new CarRentDto(5L,t1, t2);
//        carRentService.save(carRentDto);
//    }


}
