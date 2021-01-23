package section14.abstractExample;

import section14.abstractExample.entities.Circle;
import section14.abstractExample.entities.Rectangle;
import section14.abstractExample.entities.Shape;
import section14.abstractExample.entities.enums.Color;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int numberOfShapes = scanner.nextInt();

        ArrayList<Shape> shapes = new ArrayList<>(numberOfShapes);

        for (int i = 0; i < numberOfShapes; i++) {
            System.out.printf("Shape #%d data:%n", i + 1);

            System.out.print("Rectangle or Circle (r/c)? ");
            char type = scanner.next().charAt(0);

            System.out.print("Color (BLACK/BLUE/RED)? ");
            String color = scanner.next();

            switch (type) {
                case 'r':
                    System.out.print("Width? ");
                    double width = scanner.nextDouble();

                    System.out.print("Height? ");
                    double height = scanner.nextDouble();

                    shapes.add(new Rectangle(Color.valueOf(color), width,height));
                    break;

                case 'c':
                    System.out.print("Radius? ");
                    double radius = scanner.nextDouble();

                    shapes.add(new Circle(Color.valueOf(color), radius));
                    break;
            }
        }

        System.out.println("AREAS");
        shapes.forEach(shape -> System.out.printf("%.2f%n", shape.area()));
        scanner.close();
    }
}
