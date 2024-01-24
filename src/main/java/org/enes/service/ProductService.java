package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Product;
import org.enes.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IService<Product,Long> {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product update(Product entity) {
        Optional<Product> product = productRepository.findById(entity.getId());
        if (product.isPresent()) {
            return productRepository.saveAndFlush(entity);
        }else {
            return null;
        }
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> entities) {
        return productRepository.saveAll(entities);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    public Optional<Product> findByProductNameIgnoreCase(String productName) {
        return productRepository.findByProductNameIgnoreCase(productName);
    }

    public List<Product> findByProductNameContainingIgnoreCase(String productName) {
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }


    public List<Product> findByProductPriceBetween(Double productPrice, Double productPrice1) {
        return productRepository.findByProductPriceBetween(productPrice, productPrice1);
    }

    public List<Product> findByProductPriceGreaterThan(Double price){

        return productRepository.findByProductPriceGreaterThan(price);
    }

    public List<Product> findByProductUnitInStockGreaterThan(Integer stock){

        return productRepository.findByProductUnitInStockGreaterThan(stock);
    }

    public List<Product> findByProductPriceGreaterThanEqual(Double price){

        return productRepository.findByProductPriceGreaterThanEqual(price);
    }

    public Integer countByProductCategory(String category){

        return productRepository.countByProductCategory(category);
    }

    public Integer countByProductName(String productName){

        return productRepository.countByProductName(productName);
    }

    public boolean existsByProductCategory(String category){

        return productRepository.existsByProductCategory(category);
    }

    public List<Product> findByProductCategoryIsNull(){

        return productRepository.findByProductCategoryIsNull();
    }

    public List<Product> findByProductCategoryStartingWith(String categoryPrefix){

        return productRepository.findByProductCategoryStartingWith(categoryPrefix);
    }
}
