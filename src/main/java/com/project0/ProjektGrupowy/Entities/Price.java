package com.project0.ProjektGrupowy.Entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "carRentId", nullable = false)
    private Long carRentId;

    @Column(name = "carId", nullable = false)
    private Long carId;
    @Column(name = "rentDate", nullable = false)
    private Date rentDate;
    @Column(name = "returnDate", nullable = false)
    private Date returnDate;

    protected Price(){}

    public Price(Long carId, Date rentDate, Date returnDate) {
        this.carId = carId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

}
