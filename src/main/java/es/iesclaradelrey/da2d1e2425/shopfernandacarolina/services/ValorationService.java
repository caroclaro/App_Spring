package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;

import java.util.List;

public interface ValorationService {
    Valoration save(Valoration valoration);

    Valoration findById(Long id);

    List<Valoration> getValorationsByProductId(Long productId);
}
