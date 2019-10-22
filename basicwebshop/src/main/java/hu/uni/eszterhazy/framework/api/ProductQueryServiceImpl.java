package hu.uni.eszterhazy.framework.api;

import hu.uni.eszterhazy.framework.dao.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

public class ProductQueryServiceImpl implements ProductQueryService {

    private Logger LOG = LoggerFactory.getLogger(ProductQueryServiceImpl.class);

    private ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Collection<Product> allProducts() {
        return (Collection<Product>) productRepository.findAll();
    }

    @Override
    public Collection<Product> queryProductsByName(String name) {
        return productRepository.findByNameStartingWith(name);
    }

    @Override
    public Collection<Product> queryProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    @Override
    public Collection<Product> queryProductsMoreExpensiveThan(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    public void addProduct(Product product) {
        if(productRepository.findByName(product.getName()).size() != 0){
            return;
        }
        productRepository.save(product);
    }

    @Override
    public void updateProduct(String name, double price) {
        LOG.info("update product "+name);
        if(productRepository.findByName(name).size() < 1){
            return;
        };
        for(Product product : productRepository.findByName(name)){
            LOG.info(product.toString());
            product.setPrice(price);
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(String name) {
        for(Product product : productRepository.findByName(name)){
            productRepository.delete(product);
        }
    }
}
