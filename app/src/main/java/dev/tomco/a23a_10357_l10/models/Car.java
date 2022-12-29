package dev.tomco.a23a_10357_l10.models;

public class Car {

    public enum CarType {
        NA,
        GASOLINE,
        DIESEL,
        HYBRID,
        ELECTRIC
    }

    private String licensePlate = "";
    private String model = "";
    private CarType type = CarType.NA;
    private double odometer = 0.0;
    private double KmPerLiter = 0.0;
    private long price = 0;
    private boolean isFourWheelDrive = false;

    public Car() {    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Car setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public CarType getType() {
        return type;
    }

    public Car setType(CarType type) {
        this.type = type;
        return this;
    }

    public double getOdometer() {
        return odometer;
    }

    public Car setOdometer(double odometer) {
        this.odometer = odometer;
        return this;
    }

    public double getKmPerLiter() {
        return KmPerLiter;
    }

    public Car setKmPerLiter(double kmPerLiter) {
        KmPerLiter = kmPerLiter;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Car setPrice(long price) {
        this.price = price;
        return this;
    }

    public boolean isFourWheelDrive() {
        return isFourWheelDrive;
    }

    public Car setFourWheelDrive(boolean fourWheelDrive) {
        isFourWheelDrive = fourWheelDrive;
        return this;
    }
}
