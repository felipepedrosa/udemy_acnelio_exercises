package section15.customexception.model.entities;

import section15.customexception.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        if (checkout.before(checkin)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public long duration() {
        return TimeUnit.DAYS.convert(checkout.getTime() - checkin.getTime(), TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) {
        Date now = new Date();

        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }

        if (checkout.before(checkin)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Reservation: "
                + "Room " + roomNumber
                + ", checkin " + sdf.format(checkin)
                + ", checkout " + sdf.format(checkout)
                + ", " + duration() + "  nights";
    }
}