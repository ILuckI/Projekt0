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

    @Autowired
    private DateService dateService;


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
    public void testFindByNme() {
        Assert.assertEquals(10L, carService.findCarIdByName("Mercedes Vito"));
    }

    @Test
    public void testCountDays1() {
        Assert.assertEquals(8,dateService.countDays("2018-07-08","2018-07-15"));
    }

    @Test
    public void testCountDays2() {
        Assert.assertEquals(1,dateService.countDays("2018-01-20","2018-01-20"));
    }

    @Test
    public void testGet3DaysPrice() {
    Assert.assertEquals(450, priceService.get3DaysPriceByCarClassId(4)); }

    @Test
    public void testGetDeposit() {
        Assert.assertEquals(1500, priceService.getDepositByCarClassId(1)); }
}
