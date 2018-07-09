package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.dto.PriceDto;
import com.project0.ProjektGrupowy.service.PriceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceServiceTests {

    @Autowired
    private PriceService priceService;

    @Test
    public void testGetAllPrices() {
        List<PriceDto> allPricesList = priceService.getAllPrices();
        Assert.assertNotNull(allPricesList);
    }

    @Test
    public void testGet3DaysPrice() {
        Assert.assertEquals(450, priceService.get3DaysPriceByCarClassId(4)); }

    @Test
    public void testGetDeposit() {
        Assert.assertEquals(1500, priceService.getDepositByCarClassId(1)); }
}
