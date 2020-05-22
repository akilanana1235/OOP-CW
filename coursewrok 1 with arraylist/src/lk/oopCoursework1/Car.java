package lk.oopCoursework1;

import java.util.Objects;

public class Car extends Vehicle{
    private int numberOfAirbags;
    private int fuelType;
    private int numberOfSeats;
    private static int countC =0;

    public Car(String plateNumber, String make, int numberOfPassengers, double pricePerKm, String vehicleType, int numberOfAirbags, int fuelType, int numberOfSeats) {
        super(plateNumber, make, numberOfPassengers, pricePerKm, vehicleType);
        this.numberOfAirbags = numberOfAirbags;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        countC +=1;
    }

    public Car() {
    }

    public static int getCountC() {
        return countC;
    }

    public int getNumberOfAirbags() {
        return numberOfAirbags;
    }

    public void setNumberOfAirbags(int numberOfAirbags) {
        this.numberOfAirbags = numberOfAirbags;
    }

    public int getFuelType() {
        return fuelType;
    }

    public void setFuelType(int fuelType) {
        this.fuelType = fuelType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfAirbags=" + numberOfAirbags +
                ", fuelType=" + fuelType +
                ", numberOfSeats=" + numberOfSeats +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return numberOfAirbags == car.numberOfAirbags &&
                fuelType == car.fuelType &&
                numberOfSeats == car.numberOfSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfAirbags, fuelType, numberOfSeats);
    }
}
