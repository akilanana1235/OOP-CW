package lk.oopCoursework1;

import java.util.Date;
import java.util.Objects;

public class Schedule {
    private Date pickUpDate;
    private Date dropOffDate;

    public Schedule(Date pickUpDate, Date dropOffDate) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(pickUpDate, schedule.pickUpDate) &&
                Objects.equals(dropOffDate, schedule.dropOffDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickUpDate, dropOffDate);
    }
}
