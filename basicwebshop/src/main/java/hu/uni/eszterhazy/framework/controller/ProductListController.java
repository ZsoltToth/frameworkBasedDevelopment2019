package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.api.Product;
import hu.uni.eszterhazy.framework.api.ProductQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

import static org.springframework.http.HttpMethod.POST;

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

    @RequestMapping(value = "/price/gt")
    public Collection<Product> listProductByPriceMoreThan(
            @RequestParam(value = "price") double price
    ){
        return productQueryService.queryProductsMoreExpensiveThan(price);
    }


    @RequestMapping(value = "/record")
    public void recordProduct(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "price", required = true) double price){
        productQueryService.addProduct(new Product(name,price));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateProduct(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "price", required = true) double price){
        productQueryService.updateProduct(name,price);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void updateProduct(
            @RequestParam(name = "name", required = true) String name){
        productQueryService.deleteProduct(name);
    }

}
