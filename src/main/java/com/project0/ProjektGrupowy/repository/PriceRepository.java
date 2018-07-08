package com.project0.ProjektGrupowy.repository;

import com.project0.ProjektGrupowy.Entities.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findByCarClassId (long carClassId);
}
