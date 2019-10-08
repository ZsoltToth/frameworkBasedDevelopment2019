package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.api.Product;
import hu.uni.eszterhazy.framework.api.ProductQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping(value = "/products")
public class ProductListController {

    Logger logger = LoggerFactory.getLogger(ProductListController.class);

    @Autowired
    private ProductQueryService productQueryService;

    @RequestMapping(value = {"/", ""})
    public Collection<Product> listAllProducts(){
        logger.info("List All Products");
        return productQueryService.allProducts();
    }
}
