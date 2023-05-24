package com.quiroba.fresas_de_diamante.api.controllers;

import com.quiroba.fresas_de_diamante.api.models.dtos.PedidoRegisterDto;
import com.quiroba.fresas_de_diamante.api.models.entities.Pedido;
import com.quiroba.fresas_de_diamante.api.services.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<?> getAllPedidos() {
        return ResponseEntity.ok(pedidoService.getAll());
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> getByIdCliente(@PathVariable Integer idCliente) {
        return ResponseEntity.ok(pedidoService.getByIdCliente(idCliente));
    }

    @PostMapping
    public ResponseEntity<?> addPedido(@RequestBody PedidoRegisterDto pedido) {
        PedidoRegisterDto add = pedidoService.add(pedido);
        return ResponseEntity.ok(add);
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<?> deletePedido(@PathVariable Integer idPedido) {
        pedidoService.deleteById(idPedido);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pedido eliminado exitosamente");
    }
}
