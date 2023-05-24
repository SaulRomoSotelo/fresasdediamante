package com.quiroba.fresas_de_diamante.api.services;

import com.quiroba.fresas_de_diamante.api.models.dtos.ClienteResponseDto;
import com.quiroba.fresas_de_diamante.api.models.dtos.DetallePedidoDto;
import com.quiroba.fresas_de_diamante.api.models.dtos.PedidoRegisterDto;
import com.quiroba.fresas_de_diamante.api.models.dtos.PedidoResponseDto;
import com.quiroba.fresas_de_diamante.api.models.entities.Cliente;
import com.quiroba.fresas_de_diamante.api.models.entities.DetallePedido;
import com.quiroba.fresas_de_diamante.api.models.entities.Pedido;
import com.quiroba.fresas_de_diamante.api.models.entities.Producto;
import com.quiroba.fresas_de_diamante.api.repositories.ClienteRepository;
import com.quiroba.fresas_de_diamante.api.repositories.DetallePedidoRepository;
import com.quiroba.fresas_de_diamante.api.repositories.PedidoRepository;
import com.quiroba.fresas_de_diamante.api.services.interfaces.PedidoService;
import com.quiroba.fresas_de_diamante.login.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<PedidoResponseDto> getAll() {
        List<Pedido> all = pedidoRepository.findAll();
        return all.stream()
                .map(pedido -> mapPedidoToDto(pedido))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDto> getByIdCliente(Integer clienteID) {
        List<Pedido> byClienteId = pedidoRepository.findByClienteId(clienteID);
        return byClienteId.stream().map(pedido -> mapPedidoToDto(pedido))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PedidoRegisterDto add(PedidoRegisterDto pedidoDto) {
        List<DetallePedido> detalles = pedidoDto.mapToDetallePedido();
        Pedido pedidoDb = Pedido.builder()
                .cliente(Cliente.builder().id(pedidoDto.getClienteId()).build())
                .fecha_creacion(pedidoDto.getFechaCreacion())
                .fecha_entrega(pedidoDto.getFechaEntrega())
                .estado(pedidoDto.getEstado())
                .build();

        pedidoDb = pedidoRepository.save(pedidoDb);
        Pedido finalPedidoDb = pedidoDb;
        detalles.forEach(d->d.setPedido(finalPedidoDb));
        detalles = detallePedidoRepository.saveAll(detalles);
        pedidoDto.setPedidoId(pedidoDb.getId());
        pedidoDto.setDetalles(mapDetallePedidoToDto(detalles));
        return pedidoDto;
    }

    @Override
    public void deleteById(Integer pedidoID) {
        pedidoRepository.deleteById(pedidoID);
    }

    private  PedidoResponseDto mapPedidoToDto(Pedido pedido) {
        User userCliente = pedido.getCliente().getUser();
        ClienteResponseDto clienteDto = ClienteResponseDto.builder()
                .name(userCliente.getUsername())
                .email(userCliente.getEmail())
                .build();
        return PedidoResponseDto.builder()
                .pedidoID(pedido.getId())
                .fechaCreacion(pedido.getFecha_creacion())
                .fechaEntrega(pedido.getFecha_entrega())
                .estado(pedido.getEstado())
                .clienteResponseDto(clienteDto)
                .detalles(mapDetallePedidoToDto(pedido.getDetalles()))
                .build();
    }

    private List<DetallePedidoDto> mapDetallePedidoToDto(List<DetallePedido> detalles) {
        return detalles.stream().map(detalle->DetallePedidoDto.builder()
                .detalleID(detalle.getId())
                .productoID(detalle.getProducto().getId())
                .cantidad(detalle.getCantidad())
                .build())
                .collect(Collectors.toList());
    }

}
