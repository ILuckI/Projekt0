package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.dto.ClientDto;
import com.project0.ProjektGrupowy.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTests {

    @Autowired
    ClientService clientService;

    @Test
    public void testGetAllClients() {
        List<ClientDto> allClientsList = clientService.getAllClients();
        Assert.assertNotNull(allClientsList);
    }

    @Test
    public void testFindClientByAllData1(){
        ClientDto client = clientService.findClientByAllData("Jan Kowalski",
                "Warszawska 1/15","jan.kowalski@email.com","123456789","ABC 123456");
        Assert.assertNotNull(client);
    }

    @Test
    public void testFindClientByAllData2(){
        ClientDto client = clientService.findClientByAllData("Tomasz Kowalski",
                "Warszawska 1/15","omek@email.com","123456789","ABC 123456");
        Assert.assertNull(client);
    }

    @Test
    public void testFindClientIdByAllData1(){
        Assert.assertEquals( 10000000,clientService.findClientIdByAllData("Jan Kowalski",
                "Warszawska 1/15","jan.kowalski@email.com","123456789","ABC 123456"));
    }


}
