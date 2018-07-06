package com.project0.ProjektGrupowy.repository;

import com.project0.ProjektGrupowy.Entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Luck
 */
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAllByCarNameContaining(String like);
    Car findByCarName(String name);
}
