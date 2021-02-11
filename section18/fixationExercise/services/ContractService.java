package section18.fixationExercise.services;

import section18.fixationExercise.entities.Contract;
import section18.fixationExercise.entities.Quota;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private final IOnlinePaymentService onlinePaymentService;

    public ContractService(IOnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuotaValue = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            Date quotaDueDate = getQuotaDueDate(contract.getDate(), i);
            double interest = onlinePaymentService.getInterest(basicQuotaValue, i);
            double fee = onlinePaymentService.getFee(basicQuotaValue + interest);

            Double quotaValue = basicQuotaValue + fee + interest;

            contract.getQuotas().add(new Quota(quotaDueDate, quotaValue));
        }
    }

    private Date getQuotaDueDate(Date contractDate, int quoteNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(contractDate);
        calendar.add(Calendar.MONTH, quoteNumber);

        return calendar.getTime();
    }
}
