package com.project0.ProjektGrupowy.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "price_Id", nullable = false)
    private Long priceId;

    @Column(name = "car_Class_Id", nullable = false)
    private Long carClassId;
    @Column(name = "day3", nullable = false)
    private int day3;
    @Column(name = "day7", nullable = false)
    private int day7;
    @Column(name = "day7more", nullable = false)
    private int day7more;
    @Column(name = "deposit", nullable = false)
    private int deposit;

    protected Price(){}

    public Price(Long carClassId, int day3, int day7, int day7more, int deposit) {
        this.carClassId = carClassId;
        this.day3 = day3;
        this.day7 = day7;
        this.day7more = day7more;
        this.deposit = deposit;
    }
}
