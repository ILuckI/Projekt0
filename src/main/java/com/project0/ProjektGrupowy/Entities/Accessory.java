package com.project0.ProjektGrupowy.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "accessory")
@Data
public class Accessory {
    @Id
    @GeneratedValue
    @Column(name = "accessory_Id", nullable = false)
    private Long accessoryId;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private int price;

    protected Accessory(){}

    public Accessory(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
