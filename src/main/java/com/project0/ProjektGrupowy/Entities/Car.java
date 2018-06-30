import com.project0.ProjektGrupowy.Entities.CarClass;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")

public class Car {
    @Id
    @GeneratedValue
    @Column(name = "carId", nullable = false)
    private Long carId;

    @OneToMany(mappedBy = "car")
    private List<CarClass> cc = new ArrayList<>();

    public List<CarClass> getCc() {
        return cc;
    }

    public void setCc(List<CarClass> cc) {
        this.cc = cc;
    }

    private String carName;
    @Column(name = "className", nullable = false)
    private String className;
    @Column(name = "peopleNo", nullable = false)
    private int peopleNo;
    @Column(name = "doorNo", nullable = false)
    private int doorNo;
    @Column(name = "fuel", nullable = false)
    private String fuel;
    @Column(name = "consumption", nullable = false )
    private String consumption;
    @Column(name = "capacity", nullable = false)
    private double capacity;
    @Column(name = "power", nullable = false)
    private String power;
    @Column(name = "luggage", nullable = false)
    private String luggage;
    @Column(name = "gearbox", nullable = false)
    private String gearbox;
    @Column(name = "aircondition", nullable = false)
    private String aircondition;
    @Column(name = "picture", nullable = false)
    private String picture;

    protected Car(){}

    public Car(String carName, int peopleNo, int doorNo, String fuel, String consumption, double capacity, String power, String luggage, String gearbox, String aircondition, String picture) {
        this.carName = carName;
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

    //gety i sety



    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPeopleNo() {
        return peopleNo;
    }

    public void setPeopleNo(int peopleNo) {
        this.peopleNo = peopleNo;
    }

    public int getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(int doorNo) {
        this.doorNo = doorNo;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getAircondition() {
        return aircondition;
    }

    public void setAircondition(String aircondition) {
        this.aircondition = aircondition;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getCarId() {
        return carId;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", carId=" + carId +
                ", carName='" + carName + '\'' +
                ", className='" + className + '\'' +
                ", peopleNo=" + peopleNo +
                ", doorNo=" + doorNo +
                ", fuel='" + fuel + '\'' +
                ", consumption='" + consumption + '\'' +
                ", capacity=" + capacity +
                ", power='" + power + '\'' +
                ", luggage='" + luggage + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", aircondition='" + aircondition + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
