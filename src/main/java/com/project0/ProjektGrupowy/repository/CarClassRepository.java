package com.project0.ProjektGrupowy.repository;

import com.project0.ProjektGrupowy.Entities.CarClass;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Matt
 */
public interface CarClassRepository extends CrudRepository<CarClass, Long> {
    CarClass findCarClassByCarClassId (Long id);
}
