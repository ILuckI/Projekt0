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

    protected CarRent() {
    }

    public CarRent(Long carId, Timestamp rentDate, Timestamp returnDate) {
        this.carId = carId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

}
