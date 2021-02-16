package section20.comparatorexample.models;

import java.util.Comparator;

/**
 * Custom comparator to compare {@link Product}.
 */
public class ProductCustomComparator implements Comparator<Product> {
    /**
     * {@inheritDoc}
     */
    @Override
    public int compare(Product product, Product other) {
        return product.getName().compareToIgnoreCase(other.getName());
    }
}
