package sequentialstructure;

import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {

            System.out.println("Insert de value of A: ");
            float a = scanner.nextFloat();

            System.out.println("Insert de value of B: ");
            float b = scanner.nextFloat();

            System.out.println("Insert de value of C: ");
            float c = scanner.nextFloat();

            System.out.printf("Triangle area: %.3f%n", (a * c) / 2);
            System.out.printf("Circle area: %.3f%n", 3.14159 * c * c);
            System.out.printf("trapezio area: %.3f%n", (a + b) / 2 * c);
            System.out.printf("square area: %.3f%n", b * b);
            System.out.printf("rectangle area: %.3f%n", a * b);

            System.out.println("==================================");
        }

        scanner.close();
    }
}
