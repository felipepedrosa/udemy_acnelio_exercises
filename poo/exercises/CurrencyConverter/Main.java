package poo.exercises.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        double dollarPrice = sc.nextDouble();

        System.out.print("How many dollars will be bought? ");
        double amount = sc.nextDouble();


        double valueToPayInReais = CurrencyConverter.calculateValueToPayInReals(dollarPrice, amount);
        System.out.printf("Amount to be paid in reais: %.2f", valueToPayInReais);

        sc.close();
    }

    public static class CurrencyConverter{
        public static double IOF = .06;

        public static double calculateValueToPayInReals(double dollarPrice, double amount){
            return (amount * dollarPrice) + (amount * dollarPrice * IOF);
        }
    }
}
