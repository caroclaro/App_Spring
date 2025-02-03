package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories.ProductsRepository;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.repositories.ValorationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValorationServiceImpl implements ValorationService {

    private final ValorationRepository valorationRepository;
    private final ProductsRepository productsRepository;

    public ValorationServiceImpl(ValorationRepository valorationRepository, ProductsRepository productsRepository) {
        this.valorationRepository = valorationRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public Valoration save(Valoration valoration) {
        return valorationRepository.save(valoration);
    }

    @Override
    public Valoration findById(Long id) {
        return valorationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Valoration no encontrada para el ID: " + id));
    }

    @Override
    public List<Valoration> getValorationsByProductId(Long productId) {
        return valorationRepository.findByProductId(productId);
    }


}
