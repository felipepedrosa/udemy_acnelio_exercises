package conditionalstructure;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Insert the initial hour: ");
            int initialHour = scanner.nextInt();

            System.out.println("Insert the final number: ");
            int finalHour = scanner.nextInt();

            int elapsedHours;
                                           if (initialHour < finalHour) {
                elapsedHours = finalHour - initialHour;
            } else {
                elapsedHours = 24 - initialHour + finalHour;
            }

            System.out.printf("The game elapsed %s hours%n", elapsedHours);
        }

        scanner.close();
    }
}

