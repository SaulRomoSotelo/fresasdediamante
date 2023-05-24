package com.quiroba.fresas_de_diamante.api.models.dtos;

import com.quiroba.fresas_de_diamante.api.models.entities.DetallePedido;
import com.quiroba.fresas_de_diamante.api.models.entities.Pedido;
import com.quiroba.fresas_de_diamante.api.models.entities.Producto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PedidoRegisterDto {

    private Integer pedidoId;
    private Integer clienteId;
    private LocalDate fechaCreacion;
    private LocalDate fechaEntrega;
    private String estado;
    private List<DetallePedidoDto> detalles;


    public List<DetallePedido> mapToDetallePedido() {
        return  detalles.stream()
                .map(d->DetallePedido.builder()
                        .cantidad(d.getCantidad())
                        .producto(Producto.builder().id(d.getProductoID()).build())
                        .build()
                )
                .collect(Collectors.toList());
    }


}
