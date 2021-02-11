package section18.example.application;

import section18.example.entities.CarRental;
import section18.example.entities.Vehicle;
import section18.example.services.BrazilTaxService;
import section18.example.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the rental data: ");

        System.out.print("Car model: ");
        String carModel = scanner.nextLine();

        System.out.print("Pickup (dd/MM/yyyy HH:ss): ");
        Date pickup = DATE_FORMAT.parse(scanner.nextLine());

        System.out.print("Return (dd/MM/yyyy HH:ss): ");
        Date returnDate = DATE_FORMAT.parse(scanner.nextLine());

        CarRental carRental = new CarRental(pickup, returnDate, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        Double pricePerHour = scanner.nextDouble();

        System.out.print("Enter price per day: ");
        Double pricePerDay = scanner.nextDouble();
        scanner.close();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        System.out.println("## INVOICE ##");
        System.out.printf("Basic payment: $ %.2f\n", carRental.getInvoice().getBasicPayment());
        System.out.printf("Tax: $ %.2f\n", carRental.getInvoice().getTax());
        System.out.printf("Total: $ %.2f\n", carRental.getInvoice().getTotalPayment());
    }
}
