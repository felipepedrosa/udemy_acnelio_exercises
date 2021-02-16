package section19.exercise2;


import section19.exercise2.entities.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.time.Instant;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter full file path: ");
        String filePath = scanner.next();
        scanner.close();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))){
            Set<Log> logs = bufferedReader.lines().map(line -> {
                String[] columns = line.split(" ");

                return new Log(columns[0], Date.from(Instant.parse(columns[1])));
            }).collect(Collectors.toSet());

            System.out.println("Total users: " + logs.size() );


        }catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
