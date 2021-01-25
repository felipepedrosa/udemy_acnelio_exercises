package section15.customexception;

import section15.customexception.model.entities.Reservation;
import section15.customexception.model.exceptions.DomainException;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                System.out.print("Room's number: ");
                int roomsNumber = scanner.nextInt();

                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkin = Reservation.sdf.parse(scanner.next());

                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date checkout = Reservation.sdf.parse(scanner.next());

                Reservation reservation = new Reservation(roomsNumber, checkin, checkout);
                System.out.println(reservation.toString());

                System.out.println("Enter data to update the reservation:");

                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkin = Reservation.sdf.parse(scanner.next());

                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkout = Reservation.sdf.parse(scanner.next());

                reservation.updateDates(checkin, checkout);
                System.out.println(reservation.toString());
            }
        } catch (ParseException | DomainException ex) {
            if (ex instanceof ParseException) {
                System.out.println("Invalid date format");
            } else if (ex instanceof DomainException) {
                System.out.println("Error in reservation: " + ex.getMessage());
            } else{
                System.out.println("Unexpected error");
            }
        }
    }
}
