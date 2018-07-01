package com.project0.ProjektGrupowy.dto;

import lombok.Data;

@Data
public class CarClassDto {


    private String carClassName;

    public CarClassDto(){}

    public CarClassDto(String carClassName) {
        this.carClassName = carClassName;
    }
}
