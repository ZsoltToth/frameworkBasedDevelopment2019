package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.api.Product;
import hu.uni.eszterhazy.framework.api.ProductQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping(value = "/products")
public class ProductListController {

    Logger logger = LoggerFactory.getLogger(ProductListController.class);

    @Autowired
    private ProductQueryService productQueryService;

    @RequestMapping(value = {"/", "", "/{productName}"})
    public Collection<Product> listAllProducts(
            @PathVariable(name = "productName", required = false)String name
    ){
        logger.info(name);
        if("".equals(name) || name == null){
            logger.info("List All Products");
            return productQueryService.allProducts();

        }
        return productQueryService.queryProductsByName(name);
    }

    @RequestMapping(value = "/price/lt")
    public Collection<Product> listProductByPriceLessThan(
            @RequestParam(value = "price") double price
    ){
      return productQueryService.queryProductsCheaperThan(price);
    }


    @RequestMapping(value = "/record")
    public void recordProduct(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "price", required = true) double price){
        productQueryService.addProduct(new Product(name,price));
    }
}
