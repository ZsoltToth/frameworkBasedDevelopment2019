package hu.uni.eszterhazy.framework.api;

import hu.uni.eszterhazy.framework.dao.ProductRepository;

import java.util.Arrays;
import java.util.Collection;

public class ProductQueryServiceImpl implements ProductQueryService {

    private ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Collection<Product> allProducts() {
        return (Collection<Product>) productRepository.findAll();
    }
}
