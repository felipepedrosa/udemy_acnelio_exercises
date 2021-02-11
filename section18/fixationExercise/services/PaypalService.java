package section18.fixationExercise.services;

public class PaypalService implements IOnlinePaymentService{

    private static final double FEE_PERCENTAGE = .02;
    private static final double MONTHLY_INTEREST_PERCENTAGE = .01;
    @Override
    public double getFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double getInterest(double amount, int quotaNumber) {
        return (amount * MONTHLY_INTEREST_PERCENTAGE) * quotaNumber ;
    }
}
