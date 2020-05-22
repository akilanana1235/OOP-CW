package lk.oopCoursework1;

import java.util.Objects;

public abstract class Vehicle {
    private String plateNumber;
    private String make;
    private int numberOfPassengers; //for both motor bike and car
    private double pricePerKm;//for both motor bike and car
    private String vehicleType;
    public Vehicle(){}

    public Vehicle(String plateNumber, String make, int numberOfPassengers, double pricePerKm, String vehicleType) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.numberOfPassengers = numberOfPassengers;
        this.pricePerKm = pricePerKm;
        this.vehicleType = vehicleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", pricePerKm=" + pricePerKm +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return numberOfPassengers == vehicle.numberOfPassengers &&
                Double.compare(vehicle.pricePerKm, pricePerKm) == 0 &&
                Objects.equals(plateNumber, vehicle.plateNumber) &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(vehicleType, vehicle.vehicleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, make, numberOfPassengers, pricePerKm, vehicleType);
    }
}


