package com.project0.ProjektGrupowy.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "carRentId", nullable = false)
    private Long carRentId;

    @Column(name = "carId", nullable = false)
    private Long carId;
    @Column(name = "rentDate", nullable = false)
    private Date rentDate;
    @Column(name = "returnDate", nullable = false)
    private Date returnDate;

    protected Price(){}

    public Price(Long carId, Date rentDate, Date returnDate) {
        this.carId = carId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    //gety i sety


    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Long getCarRentId() {
        return carRentId;
    }

    @Override
    public String toString() {
        return "Price{" +
                "carRentId=" + carRentId +
                ", carId=" + carId +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
