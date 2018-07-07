package com.project0.ProjektGrupowy.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class CarRentDto {

    private Long carId;
    private Timestamp rentDate;
    private Timestamp returnDate;

    public CarRentDto(Long carId, Timestamp rentDate, Timestamp returnDate) {
        this.carId = carId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
