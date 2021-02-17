package section20.consumer.models;

import java.util.Objects;

public class Product {
    private String name;
    private Double price;

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s, R$ %.2f", this.getName(), this.getPrice());
    }

    /**
     * Creating a static Consumer to use with method reference.
     * Static methods will use arguments to return value.
     */
    public static void staticProductConsumer(Product product){
        System.out.println("Printing product name and price");
        System.out.println(product);
        System.out.println();
    }

    /**
     * Creating a non-static predicate to use with method reference.
     * Non-static methods will use the instance of object to return value.
     */
    public void nonStaticProductConsumer(){
        System.out.println("Printing product name and price");
        System.out.println(this);
        System.out.println();
    }
}
