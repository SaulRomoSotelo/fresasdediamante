package com.quiroba.fresas_de_diamante.api.repositories;

import com.quiroba.fresas_de_diamante.api.models.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
}
