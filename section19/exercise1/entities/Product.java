package section19.exercise1.entities;

public class Product implements Comparable<Product>{
    private String name;
    private Double value;

    public Product() {
    }

    public Product(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s, %.2f", this.name, this.value);
    }

    @Override
    public int compareTo(Product o) {
        return this.getValue().compareTo(o.getValue());
    }
}
