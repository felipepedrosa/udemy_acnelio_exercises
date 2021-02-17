package section20.Function;

import section20.Function.models.Product;

import java.util.function.Function;

/**
 * Class that implements function to be used to set product name to uppercase.
 */
public class ProductNameToUppercaseFunction implements Function<Product, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}