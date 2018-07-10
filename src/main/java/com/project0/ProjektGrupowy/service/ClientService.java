package com.project0.ProjektGrupowy.service;

import com.project0.ProjektGrupowy.Entities.Client;
import com.project0.ProjektGrupowy.dto.ClientDto;
import com.project0.ProjektGrupowy.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<ClientDto> getAllClients() {
        Iterable<Client> clients = clientRepository.findAll();
        return StreamSupport.stream(clients.spliterator(), false)
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    public ClientDto findClientByAllData(String name, String address, String email, String phone, String dowod) {
        Client clientByAll =
                clientRepository.findByNameAndAddressAndEmailAndPhoneAndDowod(name, address, email, phone, dowod);
        if (clientByAll == null) {
            return null;
        } else {
            return modelMapper.map(clientByAll, ClientDto.class);
        }
    }

    public long findClientIdByAllData(String name, String address, String email, String phone, String dowod) {
        Client clientByAll =
                clientRepository.findByNameAndAddressAndEmailAndPhoneAndDowod(name, address, email, phone, dowod);
        if (clientByAll == null) {
            return 9999999999L;
        } else {
            return clientByAll.getClientId();
        }
    }

    public void save(ClientDto clientToSave) {
        Client entityToSave = modelMapper.map(clientToSave, Client.class);
        clientRepository.save(entityToSave);
    }

}
