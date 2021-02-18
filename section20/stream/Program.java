package section20.stream;

import section20.stream.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.Comparator;
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
        scanner.close();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // Throws exception if file has no content.
            bufferedReader.lines().filter(line ->
                    line != null && line.trim().length() > 0)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("File has no content!"));

            // Streams can be consumed once, so I create a product list to be "streamed" many times.
            List<Product> productList = bufferedReader.lines()
                    .map(line -> {
                        String[] columns = line.split(",");
                        return new Product(columns[0], Double.parseDouble(columns[1]));
                    }).collect(Collectors.toList());

            // Collecting and printing average price of products.
            productList.stream()
                    .mapToDouble(Product::getPrice)
                    .average()
                    .ifPresent(price -> System.out.println(NumberFormat.getCurrencyInstance().format(price)));

            // Ordering reversed and printing product names.
            productList.stream()
                    .map(Product::getName)
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
