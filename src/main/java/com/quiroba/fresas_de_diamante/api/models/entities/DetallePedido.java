package com.quiroba.fresas_de_diamante.api.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación muchos a uno con Pedido
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    // Relación muchos a uno con Producto
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Float cantidad;

    @Override
    public String toString() {
        return "DetallePedido";
    }
}
