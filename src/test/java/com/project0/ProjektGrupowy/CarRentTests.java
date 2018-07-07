package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.service.CarRentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRentTests {

    @Autowired
    private CarRentService carRentService;

    @Test
    public void testIsCarFree1(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-30 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-07-30 00:00:00.00");
        Assert.assertTrue(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

    @Test
    public void testIsCarFree2(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-01 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-06-10 00:00:00.00");
        Assert.assertTrue(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

    @Test
    public void testIsCarFree3(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-29 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-07-30 00:00:00.00");
        Assert.assertFalse(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

    @Test
    public void testIsCarFree4(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-10 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-06-22 00:00:00.00");
        Assert.assertFalse(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

    @Test
    public void testIsCarFree5(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-24 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-06-30 00:00:00.00");
        Assert.assertFalse(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

    @Test
    public void testIsCarFree6(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-18 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-06-26 00:00:00.00");
        Assert.assertFalse(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

    @Test
    public void testIsCarFree7(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-24 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-06-26 00:00:00.00");
        Assert.assertFalse(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

    @Test
    public void testIsCarFree8(){
        Timestamp rentDate = Timestamp.valueOf("2018-06-18 00:00:00.00");
        Timestamp returnDate = Timestamp.valueOf("2018-06-30 00:00:00.00");
        Assert.assertFalse(carRentService.isCarFree("Fiat Panda", rentDate, returnDate));
    }

}
