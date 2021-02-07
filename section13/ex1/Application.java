package section13.ex1;

import section13.ex1.entities.Department;
import section13.ex1.entities.HourContract;
import section13.ex1.entities.Worker;
import section13.ex1.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static final SimpleDateFormat dateMonthYearDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat monthYearDateFormatter = new SimpleDateFormat("MM/yyyy");


    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        Department department = new Department(scanner.next());

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = scanner.next();

        System.out.print("level: ");
        String workerLevel = scanner.next();
        WorkerLevel level = WorkerLevel.valueOf(workerLevel);

        System.out.print("Base salary: ");
        Double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(workerName, level, baseSalary, department);

        System.out.println("How many contracts to this worker?");
        int numberOfContracts = scanner.nextInt();

        for (int i = 0; i < numberOfContracts; i++) {
            System.out.printf("Enter contract #%d data:%n", i+1);
            System.out.print("Date (DD/MM/YYYY):");
            Date date = dateMonthYearDateFormatter.parse(scanner.next());

            System.out.print("Value per hour:");
            Double valuePerHour = scanner.nextDouble();

            System.out.print("Duration (hours):");
            int duration = scanner.nextInt();

            worker.addContract(new HourContract(date, valuePerHour, duration));
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthYearInput = scanner.next();
        Date monthYear = monthYearDateFormatter.parse(monthYearInput);

        Calendar  calendar = Calendar.getInstance();
        calendar.setTime(monthYear);

        String message = "Name: %s\nDepartment: %s\nIncome for %s: %.2f";
        System.out.printf(message, worker.getName(), worker.getDepartment(), monthYearInput, worker.income(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)));

        scanner.close();
    }
}
