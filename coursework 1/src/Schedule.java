import java.util.Date;

public class Schedule {
    private Date pickUpDate;
    private Date DropOffDate;

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return DropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        DropOffDate = dropOffDate;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", DropOffDate=" + DropOffDate +
                '}';
    }
}
