package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories.ProductInCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInCartServiceImpl implements ProductInCartService {
    @Override
    public List<ProductInCart> findAll() {
        return productInCartRepository.findAll();
    }

    private final ProductInCartRepository productInCartRepository;

    public ProductInCartServiceImpl(ProductInCartRepository productInCartRepository) {
        this.productInCartRepository = productInCartRepository;
    }


    @Override
    public ProductInCart save(ProductInCart productInCart) {
        Optional<ProductInCart> exist = productInCartRepository.findByProductId(productInCart.getProduct().getId());
        if (exist.isPresent()) {
            ProductInCart product = exist.get();
            product.setCantidad(productInCart.getCantidad() + product.getCantidad());
            return productInCartRepository.save(product);
        } else {
            productInCart = productInCartRepository.save(productInCart);
        }
        return productInCart;
    }

    @Override
    public ProductInCart delete(ProductInCart productInCart) {
        Optional<ProductInCart> exist = productInCartRepository.findByProductId(productInCart.getProduct().getId());
        if (exist.isPresent()) {
            productInCartRepository.delete(productInCart);
            return null;
        } else {
            System.out.println("Mentira no existe ese producto");
        }
        return null;
    }

    @Override
    public ProductInCart deleteAllProductInCart() {
        productInCartRepository.deleteAll();
        return null;
    }


    @Override
    public ProductInCart findById(Long id) {
        return productInCartRepository.findById(id).get();
    }


}
