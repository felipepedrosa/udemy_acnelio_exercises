package section20.consumer;

import section20.consumer.models.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Rexona", 10.0));
        products.add(new Product("Band-aid", 4.99));
        products.add(new Product("Clear", 12.0));

        // Creating a custom consumer to print product data.
        Consumer<Product> productCustomConsumer = (product) -> {
            System.out.println("Printing product name and price");
            System.out.println(product);
            System.out.println();
        };

        // Using consumer created above.
        products.forEach(productCustomConsumer);

        // Creating a consumer inside "forEach".
        products.forEach((product) -> {
            System.out.println("Printing product name and price");
            System.out.println(product);
            System.out.println();
        });

        // Using static consumer with method reference
        products.forEach(Product::staticProductConsumer);

        // Using non-static consumer with method reference.
        products.forEach(Product::nonStaticProductConsumer);
    }
}