package poo.exercises.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of employee:");
        String name = scanner.next();

        System.out.println("enter the employee gross salary:");
        double grossSalary = scanner.nextDouble();

        System.out.println("Enter the tax on employee salary:");
        double tax = scanner.nextDouble();

        Employee employee = new Employee(name, grossSalary, tax);

        System.out.println("Employee: " + employee);

        System.out.println("Which percentage to increase salary? ");
        double percentageToIncrease = scanner.nextDouble();
        employee.increaseSalary(percentageToIncrease);

        System.out.println("Updated data: " + employee);

        scanner.close();
    }
}
