package com.project0.ProjektGrupowy.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class ClientDto {

    private String name;
    private String address;
    private String email;
    private String phone;
    private String dowod;
    private String acceptMail;
    private String acceptSMS;

    protected ClientDto(){}

    public ClientDto(String name, String address, String email, String phone, String dowod, String acceptMail, String acceptSMS) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dowod = dowod;
        this.acceptMail = acceptMail;
        this.acceptSMS = acceptSMS;
    }
}
