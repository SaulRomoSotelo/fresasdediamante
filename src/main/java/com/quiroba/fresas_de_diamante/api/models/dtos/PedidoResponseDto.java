package com.quiroba.fresas_de_diamante.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoResponseDto {

    private Integer pedidoID;
    private String  estado;
    private LocalDate fechaCreacion;
    private LocalDate fechaEntrega;
    private ClienteResponseDto clienteResponseDto;

    private List<DetallePedidoDto> detalles;

}
