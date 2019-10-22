package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.api.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findByName(String name);

    List<Product> findByNameIsLike(String name);

    List<Product> findByNameStartingWith(String name);

    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceGreaterThan(double price);
}
