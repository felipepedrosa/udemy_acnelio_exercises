package section14.ex01;

import section14.ex01.entities.Employee;
import section14.ex01.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = scanner.nextInt();

        List<Employee> employeeList = new ArrayList<>(numberOfEmployees);

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee #%d data:%n", i + 1);
            System.out.print("Outsourced? (y/n) ");
            String isOutsourcedText = scanner.next();

            boolean isOutsourced =  isOutsourcedText.equalsIgnoreCase("y");

            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Hours: ");
            int hours = scanner.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();

            double additionalCharge = 0;
            if (isOutsourced) {
                System.out.print("Additional charge: ");
                additionalCharge = scanner.nextDouble();
            }

            Employee employee = isOutsourced
                    ? new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge)
                    : new Employee(name, hours, valuePerHour);

            employeeList.add(employee);
        }

        System.out.println("PAYMENTS: ");
        employeeList.forEach(employee -> System.out.println(employee.payment()));

        scanner.close();
    }

}
