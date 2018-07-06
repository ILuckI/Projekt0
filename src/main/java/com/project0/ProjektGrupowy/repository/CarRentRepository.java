package com.project0.ProjektGrupowy.repository;

import com.project0.ProjektGrupowy.Entities.CarRent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRentRepository extends CrudRepository<CarRent, Long>{

    List<CarRent> findAllByCarId (Long carId);
}
