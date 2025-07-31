package problems.carrentalsystem.models;

import java.math.BigDecimal;

public class Car {

//    make, model, year, license plate number, rental price per day
    private String id;
    private String manufacturer;
    private String model;
    private String licensePlateNumber;
    private BigDecimal pricePerDay;
    private CarType carType;

    public Car(String id, String manufacturer, String model, String licensePlateNumber, BigDecimal pricePerDay, CarType carType) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.licensePlateNumber = licensePlateNumber;
        this.pricePerDay = pricePerDay;
        this.carType = carType;
    }

    public String getId() {
        return id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public CarType getCarType() {
        return carType;
    }
}
