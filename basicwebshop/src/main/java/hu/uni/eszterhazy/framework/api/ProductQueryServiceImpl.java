package hu.uni.eszterhazy.framework.api;

import java.util.Arrays;
import java.util.Collection;

public class ProductQueryServiceImpl implements ProductQueryService {
    @Override
    public Collection<Product> allProducts() {
        return Arrays.asList(
                new Product(1, "apple", 3.0),
                new Product(2,"banana", 32.2),
                new Product(3,"cherry", 12.1)
        );
    }
}
