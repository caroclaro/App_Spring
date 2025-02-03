package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services;


import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.ProductInCart;

import java.util.List;

public interface ProductInCartService {
    ProductInCart save(ProductInCart productInCart);

    ProductInCart delete(ProductInCart productInCart);

    ProductInCart deleteAllProductInCart();

    ProductInCart findById(Long id);

    List<ProductInCart> findAll();
}
