package sequentialstructure;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            System.out.println("Insert the first value: ");
            int firstValue = scanner.nextInt();

            System.out.println("Insert the second value: ");
            int secondValue = scanner.nextInt();


            System.out.println("SUM = " + (firstValue + secondValue));
            System.out.println("=====================================");
        }

        scanner.close();
    }
}
