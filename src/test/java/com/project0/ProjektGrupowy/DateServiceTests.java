package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.service.DateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateServiceTests {

    @Autowired
    private DateService dateService;

    @Test
    public void testCountDays1() {
        Assert.assertEquals(8,dateService.countDays("2018-07-08","2018-07-15"));
    }

    @Test
    public void testCountDays2() {
        Assert.assertEquals(1,dateService.countDays("2018-01-20","2018-01-20"));
    }

}
