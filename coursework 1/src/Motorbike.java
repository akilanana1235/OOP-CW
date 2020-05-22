import java.math.BigDecimal;

public class Motorbike extends Vehicle {

    private int numberOfHelmets;
    private double helmetSize;

    public Motorbike(String vehiclePlateNumber, String vehicleMake, int numberOfHelmets, double helmetSize) {
        super(vehiclePlateNumber, vehicleMake);
        this.numberOfHelmets = numberOfHelmets;
        this.helmetSize = helmetSize;
    }

    public Motorbike() {

    }

    public int getNumberOfHelmets() {
        return numberOfHelmets;
    }

    public void setNumberOfHelmets(int numberOfHelmets) {
        this.numberOfHelmets = numberOfHelmets;
    }

    public double getHelmetSize() {
        return helmetSize;
    }

    public void setHelmetSize(double helmetSize) {
        this.helmetSize = helmetSize;
    }

    public String vehicleType(){
        return "Bike";
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "numberOfHelmets=" + numberOfHelmets +
                ", helmetSize=" + helmetSize +
                "} " + super.toString();
    }

    public Motorbike(String vehiclePlateNumber, String vehicleMake) {
        super(vehiclePlateNumber, vehicleMake);
    }

    public Motorbike(String vehiclePlateNumber, String vehicleMake, BigDecimal pricePerKM) {
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
