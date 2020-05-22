import java.math.BigDecimal;

public class Car extends Vehicle {

    private int numberOfDoors;
    private String fuelType;

    public Car(String vehiclePlateNumber, String vehicleMake, int numberOfDoors, String fuelType) {
        super(vehiclePlateNumber, vehicleMake);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    public Car() {
        super();
    }


    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String vehicleType(){
        return "Car";
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfDoors=" + numberOfDoors +
                ", fuelType='" + fuelType + '\'' +
                "} " + super.toString();
    }

    public Car(String vehiclePlateNumber, String vehicleMake) {
        super(vehiclePlateNumber, vehicleMake);
    }

    public Car(String vehiclePlateNumber, String vehicleMake, BigDecimal pricePerKM) {
        super(vehiclePlateNumber, vehicleMake, pricePerKM);
    }

    @Override
    public String getVehiclePlateNumber() {
        return super.getVehiclePlateNumber();
    }

    @Override
    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        super.setVehiclePlateNumber(vehiclePlateNumber);
    }

    @Override
    public String getVehicleMake() {
        return super.getVehicleMake();
    }

    @Override
    public void setVehicleMake(String vehicleMake) {
        super.setVehicleMake(vehicleMake);
    }

    @Override
    public BigDecimal getPricePerKM() {
        return super.getPricePerKM();
    }

    @Override
    public void setPricePerKM(BigDecimal pricePerKM) {
        super.setPricePerKM(pricePerKM);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
