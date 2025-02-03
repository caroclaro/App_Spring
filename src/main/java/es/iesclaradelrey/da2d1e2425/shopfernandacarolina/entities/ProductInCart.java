package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_in_cart")
public class ProductInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long productInCartId;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @Column(nullable = true)
    private LocalDateTime fechaModificacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public ProductInCart(int cantidad, LocalDateTime fecha, LocalDateTime fechaModificacion, Product product) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.fechaModificacion = fechaModificacion;
        this.product = product;
    }
}
