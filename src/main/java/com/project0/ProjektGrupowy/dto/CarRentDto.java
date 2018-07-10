package com.project0.ProjektGrupowy.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class CarRentDto {

    private Long carId;
    private Timestamp rentDate;
    private Timestamp returnDate;
    private Long clientId;
    private String abroad;
    private String navigation;
    private String booster;
    private String driver;

    public CarRentDto(){}

    public CarRentDto(Long carId, Timestamp rentDate, Timestamp returnDate, Long clientId, String abroad, String navigation, String booster, String driver) {
        this.carId = carId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.clientId = clientId;
        this.abroad = abroad;
        this.navigation = navigation;
        this.booster = booster;
        this.driver = driver;
    }
}
