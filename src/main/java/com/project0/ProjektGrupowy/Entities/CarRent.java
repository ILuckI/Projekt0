package com.project0.ProjektGrupowy.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "car_Rent")
@Data
public class CarRent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_Rent_Id", nullable = false)
    private Long carRentId;

    @Column(name = "car_Id", nullable = false)
    private Long carId;
    @Column(name = "rent_Date", nullable = false)
    private Timestamp rentDate;
    @Column(name = "return_Date", nullable = false)
    private Timestamp returnDate;
    @Column(name = "client_Id", nullable = false)
    private Long clientId;
    @Column(name = "abroad", nullable = false)
    private String abroad;
    @Column(name = "navigation", nullable = false)
    private String navigation;
    @Column(name = "booster", nullable = false)
    private String booster;
    @Column(name = "driver", nullable = false)
    private String driver;

    protected CarRent() {
    }

    public CarRent(Long carId, Timestamp rentDate, Timestamp returnDate, Long clientId, String abroad, String navigation, String booster, String driver) {
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
