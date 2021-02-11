package section18.example.services;

import section18.example.entities.CarRental;
import section18.example.entities.Invoice;

import java.time.temporal.ChronoUnit;

public class RentalService {
    private final Double pricePerDay;
    private final Double pricePerHour;
    private final TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void processInvoice(CarRental carRental) {
        long elapsedTime = ChronoUnit.MILLIS.between(carRental.getStart().toInstant(), carRental.getFinish().toInstant());
        double hours = (double) elapsedTime / 1000 / 60 / 60;

        double basicPayment = hours <= 12
                ? Math.ceil(hours) * pricePerHour
                : Math.ceil(hours / 24) * pricePerDay;

        double tax = taxService.getTax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
