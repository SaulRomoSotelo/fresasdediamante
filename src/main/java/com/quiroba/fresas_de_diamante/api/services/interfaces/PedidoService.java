package com.quiroba.fresas_de_diamante.api.services.interfaces;

import com.quiroba.fresas_de_diamante.api.models.dtos.PedidoRegisterDto;
import com.quiroba.fresas_de_diamante.api.models.dtos.PedidoResponseDto;
import com.quiroba.fresas_de_diamante.api.models.entities.Pedido;

import java.util.List;

public interface PedidoService {

    List<PedidoResponseDto> getAll();
    List<PedidoResponseDto> getByIdCliente(Integer clienteID);
    PedidoRegisterDto add(PedidoRegisterDto pedido);
    void deleteById(Integer pedidoID);
}
