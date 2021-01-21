package secao13.fixationexercise;

import secao13.fixationexercise.entities.Client;
import secao13.fixationexercise.entities.Order;
import secao13.fixationexercise.entities.OrderItem;
import secao13.fixationexercise.entities.Product;
import secao13.fixationexercise.entities.enums.OrderStatus;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String clientName = scanner.next();

        System.out.print("Email: ");
        String clientEmail = scanner.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String clientBirthDate = scanner.next();

        Client client = new Client(clientName, clientEmail, Client.sdf.parse(clientBirthDate));

        System.out.println("Enter order data:");

        System.out.print("Status: ");
        String orderStatus = scanner.next();

        Order order = new Order(client, OrderStatus.valueOf(orderStatus));

        System.out.print("How many items to this order: ");
        Integer orderItemsQuantity = scanner.nextInt();

        for (int i = 0; i < orderItemsQuantity; i++) {
            System.out.printf("Enter #%d item data:\n", i + 1 );

            System.out.print("Product name: ");
            String productName = scanner.next();

            System.out.print("Product price: ");
            Double productPrice= scanner.nextDouble();

            System.out.print("Product quantity: ");
            Integer productQuantity= scanner.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order.toString());
        scanner.close();
    }
}
