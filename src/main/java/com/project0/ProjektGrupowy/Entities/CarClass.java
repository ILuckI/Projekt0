package com.project0.ProjektGrupowy.Entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "carClass")
@Data
public class CarClass {
    @Id
    @GeneratedValue
    @Column(name = "carClassId", nullable = false)
    private Long carClassId;

    @Column(name = "carClassName", nullable = false)
    private String carClassName;

    public CarClass(String carClassName) {
        this.carClassName = carClassName;
    }
}







