package poo.firstexample.entities;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double totalValueInStock() {
        return this.getQuantity() * this.getPrice();
    }

    public void addProducts(int quantity) {
        this.setQuantity(this.getQuantity() + quantity);
    }

    public void removeProducts(int quantity) {
        this.setQuantity(this.getQuantity() - quantity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%s, $ %.2f, %d units, Total: $ %.2f", this.getName(), this.getPrice(),
                this.getQuantity(), totalValueInStock());
    }
}
