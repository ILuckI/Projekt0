package com.project0.ProjektGrupowy.repository;

import com.project0.ProjektGrupowy.Entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
    Client findByNameAndAddressAndEmailAndPhoneAndDowod (String name, String address, String email, String phone, String dowod);
}
