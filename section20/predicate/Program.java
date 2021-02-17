package section20.predicate;


import section20.predicate.models.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Predicate;

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
        Predicate<Product> productPriceGreaterThanTenPredicate = (product) -> product.getPrice() > 10;

        // Using predicate created above.
        products.removeIf(productPriceGreaterThanTenPredicate);

        // Creating a predicate inside "removeIf".
        products.removeIf(product -> product.getPrice() > 10);

        // Using static predicate with method reference
        products.removeIf(Product::staticProductPredicate);

        // Using non-static predicate with method reference.
        products.removeIf(Product::nonStaticProductPredicate);

        System.out.println();
        System.out.println("Printing after use predicate: ");
        products.forEach(System.out::println);
    }
}