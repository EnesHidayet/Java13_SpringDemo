package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Product;
import org.enes.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/save")
    public Product save(Product product) {
       return productService.save(product);
    }

    @GetMapping("/find-all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/find-by-id")
    public Optional<Product> findById(Long id) {
        return productService.findById(id);
    }

    @GetMapping("/update") //PutMapping ile yaparsak 405 hatası alırız.
    public Product update(Product product) {
        return productService.update(product);
    }

    @GetMapping("/find-by-product-name")
    public Optional<Product> findByProductName(String productName) {
        return productService.findByProductName(productName);
    }

    @GetMapping("/find-by-product-name-ignore-case")
    public Optional<Product> findByProductNameIgnoreCase(String productName) {
        return productService.findByProductNameIgnoreCase(productName);
    }

    @GetMapping("/find-by-product-name-containing-ignore-case")
    public List<Product> findByProductNameContainingIgnoreCase(String productName) {
        return productService.findByProductNameContainingIgnoreCase(productName);
    }

    @GetMapping("/find-by-product-price-between")
    public List<Product> findByProductPriceBetween(Double productPrice, Double productPrice1) {
        return productService.findByProductPriceBetween(productPrice, productPrice1);
    }

    @GetMapping("/find-by-product-price-greater-than")
    List<Product> findByProductPriceGreaterThan(Double price){
        return productService.findByProductPriceGreaterThan(price);
    }

    @GetMapping("/find-by-product-unit-in-stock-greater-than")
    List<Product> findByProductUnitInStockGreaterThan(Integer stock){

        return productService.findByProductUnitInStockGreaterThan(stock);
    }

    @GetMapping("/find-by-product-price-greater-than-equal")
    List<Product> findByProductPriceGreaterThanEqual(Double price){

        return productService.findByProductPriceGreaterThanEqual(price);
    }

    @GetMapping("/count-by-product-category")
    Integer countByProductCategory(String category){

        return productService.countByProductCategory(category);
    }

    @GetMapping("/count-by-product-name")
    Integer countByProductName(String productName){

        return productService.countByProductName(productName);
    }

    @GetMapping("/exists-by-product-category")
    boolean existsByProductCategory(String category){

        return productService.existsByProductCategory(category);
    }

    @GetMapping("/find-by-product-category-is-null")
    List<Product> findByProductCategoryIsNull(){

        return productService.findByProductCategoryIsNull();
    }

    @GetMapping("/find-by-product-category-starting-with")
    List<Product> findByProductCategoryStartingWith(String categoryPrefix){

        return productService.findByProductCategoryStartingWith(categoryPrefix);
    }

}
