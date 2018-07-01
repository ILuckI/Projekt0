package com.project0.ProjektGrupowy.repository;

import com.project0.ProjektGrupowy.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAllByCarNameContaining(String like);
}
