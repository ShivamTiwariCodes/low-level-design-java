package problems.carrentalsystem.models;

import java.math.BigDecimal;

public class Car {

//    make, model, year, license plate number, rental price per day
    private String id;
    private String manufacturer;
    private String model;
    private String licensePlateNumber;
    private BigDecimal pricePerDay;

    public Car(String id, String manufacturer, String model, String licensePlateNumber, BigDecimal pricePerDay) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.licensePlateNumber = licensePlateNumber;
        this.pricePerDay = pricePerDay;
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
}
