package section18.fixationExercise.services;

public interface IOnlinePaymentService {
    double getFee(double amount);
    double getInterest(double amount, int quotaNumber);
}
