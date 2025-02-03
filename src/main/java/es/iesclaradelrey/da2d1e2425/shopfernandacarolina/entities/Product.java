package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private double price;


    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(String name, String description, String image, double price, Category category) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category = category;
    }

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Valoration> valorations;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductInCart> ListProductInCart;

}
