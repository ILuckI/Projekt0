package com.project0.ProjektGrupowy.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarClass {
    @Id
    @GeneratedValue
    @Column(name = "priceId", nullable = false)
    private Long priceId;


    @Column(name = "className", nullable = false)
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

    //gety i sety

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getDay3() {
        return day3;
    }

    public void setDay3(int day3) {
        this.day3 = day3;
    }

    public int getDay7() {
        return day7;
    }

    public void setDay7(int day7) {
        this.day7 = day7;
    }

    public int getDay7more() {
        return day7more;
    }

    public void setDay7more(int day7more) {
        this.day7more = day7more;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public Long getPriceId() {
        return priceId;
    }

    @Override
    public String toString() {
        return "CarClass{" +
                "priceId=" + priceId +
                ", className='" + className + '\'' +
                ", day3=" + day3 +
                ", day7=" + day7 +
                ", day7more=" + day7more +
                ", deposit=" + deposit +
                '}';
    }
}
