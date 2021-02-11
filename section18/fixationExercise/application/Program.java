package section18.fixationExercise.application;

import section18.fixationExercise.entities.Contract;
import section18.fixationExercise.services.ContractService;
import section18.fixationExercise.services.PaypalService;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter contract data");

        System.out.print("Number: ");
        String contractNumber = scanner.next();

        System.out.print("Date (dd/MM/yyyy): ");
        Date contractDate = Contract.DATE_FORMAT.parse(scanner.next());

        System.out.print("Value: ");
        Double contractValue = scanner.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);


        System.out.print("Enter the number of installments: ");
        int numberOfInstallments = scanner.nextInt();
        scanner.close();

        System.out.println("---- INSTALLMENTS ----");
        new ContractService(new PaypalService()).processContract(contract, numberOfInstallments);
        contract.getQuotas().forEach(quota -> System.out.printf("%s - %.2f\n",
                Contract.DATE_FORMAT.format(quota.getDueDate()), quota.getAmount()));
    }
}
