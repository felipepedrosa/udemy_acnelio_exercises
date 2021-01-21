package poo.exercises.rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rectangle width: ");
        double width = scanner.nextDouble();

        System.out.println("Enter rectangle height: ");
        double height = scanner.nextDouble();

        Rectangle rectangle = new Rectangle(width, height);
        System.out.println(rectangle.toString());
        scanner.close();
    }
}
