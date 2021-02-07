package section17.exercise.application;

import section17.exercise.application.model.Product;

import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        File sourceFile = new File("/home/felipepedrosa/IdeaProjects/teste_intellik/src/section17/exercise/application/input.csv");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            List<Product> productList = bufferedReader.lines().map(line -> {
                String[] columns = line.split(",");
                String name = columns[0];
                Double price = Double.parseDouble(columns[1]);
                int quantity = Integer.parseInt(columns[2]);

                return new Product(name, price, quantity);
            })
                    .collect(Collectors.toList());

            // It will create the output dir
            new File(sourceFile.getParent() + "/out").mkdir();
            String targetFilePath = sourceFile.getParent() + "/out/input.csv";

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFilePath))) {
                for (Product product : productList) {
                    bufferedWriter.write(product.getName() + ", " + String.format("%.2f", product.getTotal()));
                    bufferedWriter.newLine();
                }

                System.out.println("Output file created at: " + targetFilePath);
            } catch (Exception ex) {
                System.err.println("Error while writing output file: " + ex.getMessage());
            }

        } catch (Exception ex) {
            System.err.println("Error while reading input file: " + ex.getMessage());
        }
    }
}
