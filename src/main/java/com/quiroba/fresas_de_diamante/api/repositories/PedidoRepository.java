package com.quiroba.fresas_de_diamante.api.repositories;

import com.quiroba.fresas_de_diamante.api.models.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByClienteId(Integer id);
}
