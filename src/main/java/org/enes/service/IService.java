package org.enes.service;

import org.enes.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IService<T,ID> {

    T save(T entity);
    T update(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    void delete(T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}
