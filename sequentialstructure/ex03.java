package sequentialstructure;

import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Insert the value of A: ");
            int a = scanner.nextInt();

            System.out.println("Insert the value of B: ");
            int b = scanner.nextInt();

            System.out.println("Insert the value of C: ");
            int c = scanner.nextInt();

            System.out.println("Insert the value of D: ");
            int d = scanner.nextInt();

            System.out.println("Diferença = " + ((a * b) - (c * d)));
            System.out.println("===================================");
        }

        scanner.close();
    }
}
