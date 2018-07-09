package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.dto.AccessoryDto;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.service.AccessoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessoryServiceTests {

    @Autowired
    AccessoryService accessoryService;

    @Test
    public void testGetAllAccessories() {
        List<AccessoryDto> allAccessoriesList = accessoryService.getAllAccessories();
        Assert.assertNotNull(allAccessoriesList);
    }

    @Test
    public void testFindPriceByAccessoryName(){
        Assert.assertEquals(50,accessoryService.findPriceByAccessoryName("Dodatkowy kierowca"));
    }
}
