package com.project0.ProjektGrupowy.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
public class Car  {
    @Id
    @GeneratedValue
    @Column(name = "carId", nullable = false)
    private Long carId;

    private String carName;
    @Column(name = "className", nullable = false)
    private String className;
    @Column(name = "peopleNo", nullable = false)
    private int peopleNo;
    @Column(name = "doorNo", nullable = false)
    private int doorNo;
    @Column(name = "fuel", nullable = false)
    private String fuel;
    @Column(name = "consumption", nullable = false )
    private String consumption;
    @Column(name = "capacity", nullable = false)
    private double capacity;
    @Column(name = "power", nullable = false)
    private String power;
    @Column(name = "luggage", nullable = false)
    private String luggage;
    @Column(name = "gearbox", nullable = false)
    private String gearbox;
    @Column(name = "aircondition", nullable = false)
    private String aircondition;
    @Column(name = "picture", nullable = false)
    private String picture;

    protected Car(){}

    public Car(String carName, int peopleNo, int doorNo, String fuel, String consumption, double capacity, String power, String luggage, String gearbox, String aircondition, String picture) {
        this.carName = carName;
        this.peopleNo = peopleNo;
        this.doorNo = doorNo;
        this.fuel = fuel;
        this.consumption = consumption;
        this.capacity = capacity;
        this.power = power;
        this.luggage = luggage;
        this.gearbox = gearbox;
        this.aircondition = aircondition;
        this.picture = picture;
    }
    //a
}
