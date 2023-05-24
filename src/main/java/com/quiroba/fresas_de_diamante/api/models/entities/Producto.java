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
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;
    private String cod_proveedor;
    private String consecutivo_jic;
    private String descripcion;
    private Integer numero_pizas;
    private String marca;
    private String tipo_fresa;
    private String medida_cabeza_long_punta;
    private String medida_total;
    private Float precio;
    private Float descuento;
    private String imagen;

}
