package section20.fixationexercise;

import section20.fixationexercise.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter full file path: ");
        String filePath = scanner.next();

        System.out.println("Enter value: ");
        double value = scanner.nextDouble();
        scanner.close();

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // Streams can be consumed once, so I create a employee list to be "streamed" many times.
            List<Employee> employeeList = bufferedReader.lines()
                    .filter(line -> line != null && line.trim().length() > 0)
                    .map(line -> {
                        String[] columns = line.split(",");
                        return new Employee(columns[0], columns[1], Double.parseDouble(columns[2]));
                    })
                    .collect(Collectors.toList());

            // Throws exception if file has no content.
            if (employeeList.isEmpty()) {
                throw new IllegalStateException("File has no content!");
            }

            // Filtering employees whose wage is greater or equal asked value.
            List<String> wageGreaterThanValueEmployees = employeeList.stream()
                    .filter(employee -> employee.getWage() >= value)
                    .map(Employee::getEmail)
                    .sorted()
                    .collect(Collectors.toList());

            if (wageGreaterThanValueEmployees.size() > 0) {
                System.out.printf("Email of people whose salary is more than %s:\n", currencyFormatter.format(value));
                wageGreaterThanValueEmployees.forEach(System.out::println);
            }

            // Filtering employees with M at first letter of name and printing the sum of their wage.
            employeeList.stream()
                    .filter(employee -> employee.getName().charAt(0) == 'M')
                    .map(Employee::getWage)
                    .reduce(Double::sum)
                    .ifPresent(wageSum -> System.out.println("Sum of wage of people whose name starts with \"M\": "
                            /* */ + currencyFormatter.format(wageSum)));
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
