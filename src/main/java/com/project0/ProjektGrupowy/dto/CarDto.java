package com.project0.ProjektGrupowy.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CarDto {

    private String carName;
    private String className;
    private int peopleNo;
    private int doorNo;
    private String fuel;
    private String consumption;
    private double capacity;
    private String power;
    private String luggage;
    private String gearbox;
    private String aircondition;
    private String picture;

    public CarDto() {
    }

    public CarDto(String carName, String className, int peopleNo, int doorNo, String fuel, String consumption, double capacity, String power, String luggage, String gearbox, String aircondition, String picture) {
        this.carName = carName;
        this.className = className;
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
