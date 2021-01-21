package poo.exercises.student;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the student name:");
        String name = scanner.next();

        System.out.println("Enter the student first note:");
        double firstNote = scanner.nextDouble();

        System.out.println("Enter the student second note:");
        double secondNote = scanner.nextDouble();

        System.out.println("Enter the student third note:");
        double thirdNote = scanner.nextDouble();

        Student student = new Student(name, firstNote, secondNote, thirdNote);
        System.out.println(student);
        scanner.close();
    }
}
