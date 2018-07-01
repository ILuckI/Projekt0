package com.project0.ProjektGrupowy.Entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "car_Class")
@Data
public class CarClass {
    @Id
    @GeneratedValue
    @Column(name = "car_Class_Id", nullable = false)
    private Long carClassId;

    @Column(name = "car_Class_Name", nullable = false)
    private String carClassName;

    public CarClass(String carClassName) {
        this.carClassName = carClassName;
    }

}







