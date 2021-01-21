package sequentialstructure;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Insert the employee code: ");
            int employeeCode = scanner.nextInt();

            System.out.println("Insert the amount of worked hours: ");
            int workedHours = scanner.nextInt();

            System.out.println("Insert the value per hour: ");
            double valuePerHour = scanner.nextDouble();

            System.out.println("Employee code: " + employeeCode);
            System.out.println(String.format("Calculated salary: U$ %.2f", workedHours * valuePerHour));

            System.out.println("===================================================");
        }

        scanner.close();
    }
}
