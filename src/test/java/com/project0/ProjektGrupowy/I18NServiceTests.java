package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class I18NServiceTests {

    @Autowired
    private I18NService i18NService;

    //	Test i18n local message (Poprawnosc komunikatow lokalnych)
    @Test
    public void testMessageByLocaleService() throws Exception {
        String expectedResult = "Coders Team";
        String messageId = "navbar.coder.text";
        String actual = i18NService.getMessage(messageId);
        Assert.assertEquals("The actual and expected Strings don't match", expectedResult, actual);
    }
}
