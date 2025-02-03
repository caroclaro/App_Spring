package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories;


import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.util.Streamable;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCategory(Category category);

}
