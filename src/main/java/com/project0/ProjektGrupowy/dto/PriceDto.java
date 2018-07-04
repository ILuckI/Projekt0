package com.project0.ProjektGrupowy.dto;

import lombok.Data;

@Data
public class PriceDto {

    private Long carClassId;
    private String className;
    private int day3;
    private int day7;
    private int day7more;
    private int deposit;

    public PriceDto(){}

    public PriceDto(Long carClassId, String className, int day3, int day7, int day7more, int deposit) {
        this.carClassId = carClassId;
        this.className = className;
        this.day3 = day3;
        this.day7 = day7;
        this.day7more = day7more;
        this.deposit = deposit;
    }
}
