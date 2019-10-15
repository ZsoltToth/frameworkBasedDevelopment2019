package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.api.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
