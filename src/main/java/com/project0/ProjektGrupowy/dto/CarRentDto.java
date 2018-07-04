package com.project0.ProjektGrupowy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CarRentDto {

    private Long carId;
    private Date rentDate;
    private Date returnDate;

    public CarRentDto(Long carId, Date rentDate, Date returnDate) {
        this.carId = carId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
