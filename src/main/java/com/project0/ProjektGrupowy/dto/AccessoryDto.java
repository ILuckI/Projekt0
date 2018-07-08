package com.project0.ProjektGrupowy.dto;

import lombok.Data;

@Data
public class AccessoryDto {

    private String name;
    private int price;

    public AccessoryDto(){}

    public AccessoryDto(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
