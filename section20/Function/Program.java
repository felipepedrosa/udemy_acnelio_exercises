package section20.Function;


import section20.Function.models.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Function;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Rexona", 10.0));
        products.add(new Product("Band-aid", 4.99));
        products.add(new Product("Clear", 12.0));

        System.out.println("Printing before use predicate: ");
        products.forEach(System.out::println);

        // Creating a custom predicate to check if product value is greater than 10.
        Function<Product, String> productNameToUpperCaseFunction = (product) -> product.getName().toUpperCase();

        // Using function created above.
        products.stream().map(productNameToUpperCaseFunction).forEach(System.out::println);

        // Creating a function inside "removeIf".
        products.stream().map((product) -> product.getName().toUpperCase()).forEach(System.out::println);

        // Using static function with method reference
        products.stream().map(Product::staticProductFunction).forEach(System.out::println);

        // Using non-static function with method reference.
        products.stream().map(Product::nonStaticProductFunction).forEach(System.out::println);

        // Using class that implements function.
        products.stream().map(new ProductNameToUppercaseFunction()).forEach(System.out::println);
    }
}