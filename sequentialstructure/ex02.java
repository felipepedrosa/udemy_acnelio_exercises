package sequentialstructure;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pi = 3.14159;

        for (int i = 0; i < 3; i++) {
            System.out.println("Insert the value: ");
            double value = scanner.nextDouble();

            System.out.printf("The calculated area is: %.4f%n", pi * Math.pow(value, 2));
            System.out.println("====================================================");
        }

        scanner.close();
    }
}
