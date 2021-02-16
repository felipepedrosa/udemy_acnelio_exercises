package section19.fixationExercise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter full file path: ");
        String filePath = scanner.next();
        scanner.close();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
            Map<String, Integer> votesByCandidate = bufferedReader.lines()
                    .map(line -> line.split(","))
                    .collect(Collectors.groupingBy(obj -> obj[0],
                            Collectors.summingInt(obj -> Integer.parseInt(obj[1]))));

            votesByCandidate.forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
