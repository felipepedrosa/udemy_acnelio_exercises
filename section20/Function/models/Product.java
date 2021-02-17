package section20.Function.models;

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

    /**
     * Creating a static predicate to use with method reference.
     * Static methods will use arguments to return value.
     */
    public static String staticProductFunction(Product product) {
        return product.getName().toUpperCase();
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
     * Creating a non-static predicate to use with method reference.
     * Non-static methods will use the instance of object to return value.
     */
    public String nonStaticProductFunction() {
        return this.getName().toUpperCase();
    }
}
