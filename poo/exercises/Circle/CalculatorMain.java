package poo.exercises.Circle;

import java.util.Locale;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter radius: ");
        double radius = sc.nextDouble();

        double circumference = Calculator.getCircunference(radius);
        double volume = Calculator.getVolume(radius);

        System.out.printf("Circumference: %.2f\n", circumference);
        System.out.printf("Volume: %.2f\n", volume);
        System.out.printf("PI Value: %.2f", Math.PI);
        sc.close();
    }
}
