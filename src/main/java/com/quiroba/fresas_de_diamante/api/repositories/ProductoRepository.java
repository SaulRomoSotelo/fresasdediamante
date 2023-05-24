package com.quiroba.fresas_de_diamante.api.repositories;

import com.quiroba.fresas_de_diamante.api.models.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByModelo(String modelo);
}
