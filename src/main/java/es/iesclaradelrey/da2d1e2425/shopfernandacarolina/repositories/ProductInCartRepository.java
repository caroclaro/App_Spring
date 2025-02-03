package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
    @Query(value = "select count(1) from product_in_cart pc where pc.product_id = :id", nativeQuery = true)
    Long countProductInCart(@Param("id") Long id);

    Optional<ProductInCart> findByProductId(Long id);
}
