package section19.fixationExercise;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        Set<Integer> studentsCode = new HashSet<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students for course A? ");
        int studentsQuantity = scanner.nextInt();

        for (int i = 0; i < studentsQuantity; i++) {
            studentsCode.add(scanner.nextInt());
        }

        System.out.print("How many students for course B? ");
        studentsQuantity = scanner.nextInt();

        for (int i = 0; i < studentsQuantity; i++) {
            studentsCode.add(scanner.nextInt());
        }

        System.out.print("How many students for course C? ");
        studentsQuantity = scanner.nextInt();

        for (int i = 0; i < studentsQuantity; i++) {
            studentsCode.add(scanner.nextInt());
        }
        scanner.close();

        System.out.println("Total students: " + studentsCode.size());
    }
}
