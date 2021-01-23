package section14.fixationexercise;

import section14.fixationexercise.entities.ImportedProduct;
import section14.fixationexercise.entities.Product;
import section14.fixationexercise.entities.UsedProduct;

import java.text.ParseException;
import java.util.*;

public class Application {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();

        List<Product> productList = new ArrayList<>(numberOfProducts);

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.printf("Product #%d data:%n", i + 1);

            System.out.print("Common, used or imported (c/u/i)? ");
            char type = scanner.next().charAt(0);

            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Price: ");
            Double price = scanner.nextDouble();

            switch (type) {
                case 'c':
                    productList.add(new Product(name, price));

                    break;

                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY):");
                    Date manufactureDate = UsedProduct.sdf.parse(scanner.next());
                    productList.add(new UsedProduct(name, price, manufactureDate));

                    break;

                case 'i':
                    System.out.print("Customs fee:");
                    double customFee = scanner.nextDouble();
                    productList.add(new ImportedProduct(name, price, customFee));

                    break;
            }
        }

        System.out.println("PRICE TAGS:");
        productList.forEach(product -> System.out.println(product.priceTag()));
        scanner.close();
    }
}
