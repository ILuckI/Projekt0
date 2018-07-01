package com.project0.ProjektGrupowy.Entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_Rent")
@Data
public class CarRent {
    @Id
    @GeneratedValue
    @Column(name = "car_Rent_Id", nullable = false)
    private Long carRentId;

    @Column(name = "car_Id", nullable = false)
    private Long carId;
    @Column(name = "rent_Date", nullable = false)
    private Date rentDate;
    @Column(name = "return_Date", nullable = false)
    private Date returnDate;


    protected CarRent(){}

    public CarRent(Long carId, Date rentDate, Date returnDate) {
        this.carId = carId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

}
