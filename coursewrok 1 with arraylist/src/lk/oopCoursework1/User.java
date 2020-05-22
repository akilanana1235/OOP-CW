package lk.oopCoursework1;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private final SimpleStringProperty vehicleType;
    private final SimpleStringProperty vehiclePlateNumber;
    private final SimpleDoubleProperty pricePerKm;
    private final SimpleIntegerProperty fuelType;
    private final SimpleIntegerProperty numberOfHelmets;
    private final SimpleIntegerProperty numberOfPassengers;
    private final SimpleIntegerProperty numberOfAirbags;
    private final SimpleIntegerProperty numberOfSeats;
    private final SimpleIntegerProperty numberOfGears;
    private final SimpleIntegerProperty wheelDiameter;
    private final SimpleStringProperty vehicleMake;

    public User(String type, String plateNumber, double price, int fuel, int helmets, int passengers, int airbags, int seats, int gears, int diameter, String make) {
        this.vehicleType = new SimpleStringProperty(type);
        this.vehiclePlateNumber = new SimpleStringProperty(plateNumber);
        this.pricePerKm = new SimpleDoubleProperty(price);
        this.fuelType = new SimpleIntegerProperty(fuel);
        this.numberOfHelmets = new SimpleIntegerProperty(helmets);
        this.numberOfPassengers = new SimpleIntegerProperty(passengers);
        this.numberOfAirbags = new SimpleIntegerProperty(airbags);
        this.numberOfSeats = new SimpleIntegerProperty(seats);
        this.numberOfGears = new SimpleIntegerProperty(gears);
        this.wheelDiameter = new SimpleIntegerProperty(diameter);
        this.vehicleMake = new SimpleStringProperty(make);
    }

    public String getVehicleType(){
        return vehicleType.get();
    }

    public String getVehiclePlateNumber(){
        return vehiclePlateNumber.get();
    }

    public double getPricePerKM(){
        return pricePerKm.get();
    }

    public int getFuelType() {
        return fuelType.get();
    }

    public int getNumberOfHelmets() {
        return numberOfHelmets.get();
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers.get();
    }

    public int getNumberOfAirbags() {
        return numberOfAirbags.get();
    }

    public int getNumberOfSeats() {
        return numberOfSeats.get();
    }

    public int getNumberOfGears() {
        return numberOfGears.get();
    }

    public int getWheelDiameter() {
        return wheelDiameter.get();
    }

    public String getVehicleMake() {
        return vehicleMake.get();
    }

    public void setVehicleType(String type){
        vehicleType.set(type);
    }

    public void setVehiclePlateNumber(String plateNumber){
        vehiclePlateNumber.set(plateNumber);
    }

    public void setPricePerKm(double price){
        pricePerKm.set(price);
    }

    public void setFuelType(int fuel){
        fuelType.set(fuel);
    }

    public void setNumberOfHelmets(int helmets){
        numberOfHelmets.set(helmets);
    }

    public void setNumberOfPassengers(int passengers){
        numberOfPassengers.set(passengers);
    }

    public void setNumberOfAirbags(int airbags){
        numberOfPassengers.set(airbags);
    }

    public void setNumberOfSeats(int seats){
        numberOfSeats.set(seats);
    }

    public void setNumberOfGears(int gears){
        numberOfGears.set(gears);
    }

    public void setWheelDiameter(int diameter){
        wheelDiameter.set(diameter);
    }

    public void setVehicleMake(String make){
        vehicleMake.set(make);
    }
}
