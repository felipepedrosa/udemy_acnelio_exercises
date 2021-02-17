package section20.comparator;

import section20.comparator.models.Product;
import section20.comparator.models.ProductCustomComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Rexona", 10.0));
        products.add(new Product("Band-aid", 4.99));
        products.add(new Product("Clear", 12.0));

        System.out.println("Without ordination: ");
        products.forEach(System.out::println);

        System.out.println("\nWith ordination: ");

        // Creating an anonymous comparator.
        Comparator<Product> anonymousComparator = new Comparator<>() {
            /**
             * {@inheritDoc}
             */
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareToIgnoreCase(p2.getName());
            }
        };

        // Creating a comparator using lambda/arrow function/anonymous function;
        Comparator<Product> lambdaComparator = (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName());

        // Using anonymous comparator.
        products.stream().sorted(anonymousComparator).forEach(System.out::println);

        // Using lambda comparator.
        products.stream().sorted(lambdaComparator).forEach(System.out::println);

        // Using custom comparator created using class.
        products.stream().sorted(new ProductCustomComparator()).forEach(System.out::println);

        // Using standard method from comparator.
        products.stream().sorted(Comparator.comparing(Product::getName)).forEach(System.out::println);
    }
}
