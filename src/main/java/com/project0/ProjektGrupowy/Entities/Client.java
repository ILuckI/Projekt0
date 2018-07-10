package com.project0.ProjektGrupowy.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_Id", nullable = false)
    private Long clientId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "dowod", nullable = false)
    private String dowod;
    @Column(name = "accept_Mail", nullable = false)
    private String acceptMail;
    @Column(name = "accept_SMS", nullable = false)
    private String acceptSMS;

    protected Client(){}

    public Client(String name, String address, String email, String phone, String dowod) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dowod = dowod;
    }
}
