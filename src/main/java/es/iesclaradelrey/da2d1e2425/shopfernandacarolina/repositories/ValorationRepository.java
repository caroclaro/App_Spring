package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValorationRepository extends JpaRepository<Valoration, Long> {
    List<Valoration> findByProductId(Long id);
}
