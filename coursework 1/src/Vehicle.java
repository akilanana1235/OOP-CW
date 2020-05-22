import java.math.BigDecimal;

public abstract class Vehicle {

    private String vehiclePlateNumber;
    private String vehicleMake;
    private BigDecimal pricePerKM;

    public Vehicle(String vehiclePlateNumber, String vehicleMake) {
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.vehicleMake = vehicleMake;
    }

    public Vehicle(String vehiclePlateNumber, String vehicleMake, BigDecimal pricePerKM) {
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.vehicleMake = vehicleMake;
        this.pricePerKM = pricePerKM;
    }

    public Vehicle() {

    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public BigDecimal getPricePerKM() {
        return pricePerKM;
    }

    public void setPricePerKM(BigDecimal pricePerKM) {
        this.pricePerKM = pricePerKM;
    }

    public abstract String vehicleType();

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", pricePerKM=" + pricePerKM +
                '}';
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
