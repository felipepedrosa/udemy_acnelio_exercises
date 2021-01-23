package section14.fixationexercise2;

import section14.fixationexercise2.entities.LegalPerson;
import section14.fixationexercise2.entities.Person;
import section14.fixationexercise2.entities.PhysicalPerson;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int numberOfPayers = scanner.nextInt();

        ArrayList<Person> personList = new ArrayList<>(numberOfPayers);

        for (int i = 0; i < numberOfPayers; i++) {
            System.out.printf("Tax payer #%d data:", i + 1);

            System.out.println("Individual or company? (i/c)? ");
            char type = scanner.next().charAt(0);

            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Annual income: ");
            Double annualIncome = scanner.nextDouble();

            if (type == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = scanner.nextDouble();

                personList.add(new PhysicalPerson(name, annualIncome, healthExpenditures));

            } else if (type == 'c') {
                System.out.print("Number of employees: ");
                Integer employeesNumber = scanner.nextInt();

                personList.add(new LegalPerson(name, annualIncome, employeesNumber));
            }
        }
        scanner.close();

        System.out.println();
        System.out.println("TAXES PAID:");
        personList.forEach(person -> System.out.printf("%s: $ %.2f%n", person.getName(), person.calculateTax()));
        System.out.println();

        System.out.printf("TOTAL TAXES: $%.2f", personList.stream().mapToDouble(Person::calculateTax).sum());

    }
}
