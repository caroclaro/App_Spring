package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
