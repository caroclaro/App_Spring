package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories.CategoryRepository;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductsRepository productsRepository, CategoryRepository categoryRepository) {
        this.productsRepository = productsRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productsRepository.save(product);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        Category category = categoryRepository.findById(id).get();
        return productsRepository.findProductByCategory(category);
    }

    @Override
    public Product findById(Long id) {
        return productsRepository.findById(id).get();
    }



}
