package com.project0.ProjektGrupowy.repository;

import com.project0.ProjektGrupowy.Entities.Accessory;
import org.springframework.data.repository.CrudRepository;

public interface AccessoryRepository extends CrudRepository<Accessory, Long> {
    Accessory findByName (String name);
}
