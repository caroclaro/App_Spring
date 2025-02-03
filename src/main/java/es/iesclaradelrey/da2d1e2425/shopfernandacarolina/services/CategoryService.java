package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category category);

    Optional<Category> findById(Long id);


}
