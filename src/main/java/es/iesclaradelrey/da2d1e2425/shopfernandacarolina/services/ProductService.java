package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product save(Product product);

    List<Product> findByCategoryId(Long id);

    Product findById(Long id);
}
