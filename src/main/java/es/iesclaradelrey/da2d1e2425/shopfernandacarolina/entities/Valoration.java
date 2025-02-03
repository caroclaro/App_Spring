package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.swing.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Valoration")

public class Valoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private Double valor;

    public void setValor(Double valor) {
        if ((valor != 0) && (valor != 0.5) && (valor != 1) && (valor != 1.5) && (valor != 2) && (valor != 2.5) && (valor != 3) && (valor != 3.5) && (valor != 4) && (valor != 4.5) && (valor != 5)) {
            System.out.println("Valor invalido");
            valor = (double) Math.round(valor);
            this.valor = valor;
        } else {
            this.valor = valor;
        }
    }

    @Column(nullable = false)
    private String nombrePersona;

    @Column(nullable = false, length = 1000)
    private String comentario;

    public void setComentario(String comentario) {
        if (comentario.length() > 1000) {
            System.out.println("Comentario invalido");
            comentario = comentario.substring(0, 1000);
            this.comentario = comentario;


        } else {
            this.comentario = comentario;
        }
    }

    @Column(nullable = false)
    private LocalDateTime fecha;

    public Valoration(Double valor, String nombrePersona, String comentario, LocalDateTime fecha, Product product) {
        setValor(valor);
        this.nombrePersona = nombrePersona;
        setComentario(comentario);
        this.fecha = fecha;
        this.product = product;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
