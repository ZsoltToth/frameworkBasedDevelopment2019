package hu.uni.eszterhazy.framework.api;

import java.util.Collection;

public interface ProductQueryService {

    Collection<Product> allProducts();
    Collection<Product> queryProductsByName(String name);

    Collection<Product> queryProductsCheaperThan(double price);
    Collection<Product> queryProductsMoreExpensiveThan(double price);

    void addProduct(Product product);

    void updateProduct(String name, double price);

    void deleteProduct(String name);
}
