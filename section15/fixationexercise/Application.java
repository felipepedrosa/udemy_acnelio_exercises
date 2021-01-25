package section15.fixationexercise;

import section15.fixationexercise.model.entities.Account;
import section15.fixationexercise.model.exceptions.DomainException;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {

        try {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();

            System.out.print("Holder: ");
            String holder = sc.next();

            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));

            sc.close();
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

    }
}
