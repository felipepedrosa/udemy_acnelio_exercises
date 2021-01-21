package sequentialstructure;

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Insert the code of first product: ");
            int productOneCode = scanner.nextInt();

            System.out.println("Insert the quantity of first product: ");
            int firstProductQuantity = scanner.nextInt();

            System.out.println("Insert the unit value of first product: ");
            double firstProductValue = scanner.nextDouble();

            double firstProductTotalValue = firstProductValue * firstProductQuantity;

            System.out.println("Insert the code of second product: ");
            int secondProductCode = scanner.nextInt();

            System.out.println("Insert the quantity of first product: ");
            int secondProductQuantity = scanner.nextInt();

            System.out.println("Insert the unit value of first product: ");
            double secondProductValue = scanner.nextDouble();

            double secondProductTotalValue = secondProductValue * secondProductQuantity;

            System.out.printf("Valor a pagar: R$ %.2f%n", firstProductTotalValue + secondProductTotalValue);
            System.out.println("=========================================================");
        }

        scanner.close();
    }
}

