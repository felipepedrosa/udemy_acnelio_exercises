package section19.exercise1;

import section19.exercise1.entities.Product;
import section19.exercise1.services.CalculationService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        File file = new File("/home/felipepedrosa/IdeaProjects/teste_intellik/src/section19/exercise1/input.csv");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<Product> products = bufferedReader.lines()
                    .map(line -> {
                        System.out.println(line);

                        String[] columns = line.split(",");
                        return new Product(columns[0], Double.parseDouble(columns[1]));
                    }).collect(Collectors.toList());

            System.out.println("Most expensive : ");

            Product mostExpensiveProduct = CalculationService.getMax(products);
            System.out.println(mostExpensiveProduct);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
