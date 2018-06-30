package com.project0.ProjektGrupowy.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class CarClass {
    @Id
    @GeneratedValue
    @Column(name = "priceId", nullable = false)
    private Long priceId;
    @Column(name = "carClassName", nullable = false)
    private String className;
    @Column(name = "day3", nullable = false)
    private int day3;
    @Column(name = "day7", nullable = false)
    private int day7;
    @Column(name = "day7more", nullable = false)
    private int day7more;
    @Column(name = "deposit", nullable = false)
    private int deposit;

    protected CarClass(){}

    public CarClass(String className, int day3, int day7, int day7more, int deposit) {
        this.className = className;
        this.day3 = day3;
        this.day7 = day7;
        this.day7more = day7more;
        this.deposit = deposit;
    }


}
