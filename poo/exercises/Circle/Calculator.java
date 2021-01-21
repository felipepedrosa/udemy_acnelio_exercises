package poo.exercises.Circle;

public class Calculator {

    public static double getCircunference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double getVolume(double radius) {
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }

}
