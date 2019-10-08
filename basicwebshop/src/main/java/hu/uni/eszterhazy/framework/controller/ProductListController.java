package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.api.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping(value = "/products")
public class ProductListController {

    Logger logger = LoggerFactory.getLogger(ProductListController.class);

    @RequestMapping(value = {"/", ""})
    public Collection<Product> listAllProducts(){
        logger.info("List All Products");
        return Arrays.asList(
                new Product(1,"apple", 1.0),
                new Product(2, "banana", 20),
                new Product(3, "cherry", 2.5)
        );
    }
}
