package org.enes.repository;

import org.enes.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByProductName(String productName);
    Optional<Product> findByProductNameIgnoreCase(String productName);
    List<Product> findByProductNameContainingIgnoreCase(String productName);
    List<Product> findByProductPriceBetween(Double price, Double price1);

    List<Product> findByProductPriceGreaterThan(Double price);

    List<Product> findByProductUnitInStockGreaterThan(Integer stock);

    List<Product> findByProductPriceGreaterThanEqual(Double price);

    Integer countByProductCategory(String category);

    Integer countByProductName(String productName);

    boolean existsByProductCategory(String category);

    List<Product> findByProductCategoryIsNull();

    List<Product> findByProductCategoryStartingWith(String categoryPrefix);




}
