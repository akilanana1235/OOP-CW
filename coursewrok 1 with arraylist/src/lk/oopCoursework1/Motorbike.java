package lk.oopCoursework1;

import java.util.Objects;

public class Motorbike extends Vehicle{

    private int numberOfGears;
    private int wheelDiameter;
    private int numberOfHelmets;
    private static int countM =0;

    public Motorbike(String plateNumber, String make, int numberOfPassengers, double pricePerKm, String vehicleType, int numberOfGears, int wheelDiameter, int numberOfHelmets) {
        super(plateNumber, make, numberOfPassengers, pricePerKm, vehicleType);
        this.numberOfGears = numberOfGears;
        this.wheelDiameter = wheelDiameter;
        this.numberOfHelmets = numberOfHelmets;
        countM +=1;
    }

    public Motorbike() {

    }

    public static int getCountM() {
        return countM;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public int getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public int getNumberOfHelmets() {
        return numberOfHelmets;
    }

    public void setNumberOfHelmets(int numberOfHelmets) {
        this.numberOfHelmets = numberOfHelmets;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "numberOfGears=" + numberOfGears +
                ", wheelDiameter=" + wheelDiameter +
                ", numberOfHelmets=" + numberOfHelmets +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorbike motorbike = (Motorbike) o;
        return numberOfGears == motorbike.numberOfGears &&
                wheelDiameter == motorbike.wheelDiameter &&
                numberOfHelmets == motorbike.numberOfHelmets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfGears, wheelDiameter, numberOfHelmets);
    }
}
