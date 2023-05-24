package com.quiroba.fresas_de_diamante.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDto {

    private Integer detalleID;
    private Integer productoID;
    private Float cantidad;
}
