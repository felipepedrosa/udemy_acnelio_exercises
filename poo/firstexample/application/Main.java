package poo.firstexample.application;

import poo.firstexample.entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("Enter product data: ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        String name = scanner.next();

        System.out.println("Price: ");
        double price = scanner.nextDouble();

        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(name, price, quantity);
        System.out.println("Product data: " + product.toString());

        System.out.println("Enter the quantity to be added in stock: ");
        int quantityToAdd = scanner.nextInt();
        product.addProducts(quantityToAdd);
        System.out.println("Updated product data: " + product.toString());

        System.out.println("Enter the quantity to be removed from stock: ");
        int quantityToRemove = scanner.nextInt();
        product.removeProducts(quantityToRemove);
        System.out.println("Updated product data: " + product.toString());

        scanner.close();
    }
}
