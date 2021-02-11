package section18.example.services;

public class BrazilTaxService implements TaxService {
    public BrazilTaxService() {
    }

    @Override
    public double getTax(double amount) {
        return amount <= 100.00
                ? amount * .20
                : amount * .15;
    }
}
