package com.quiroba.fresas_de_diamante.api.services.interfaces;

import com.quiroba.fresas_de_diamante.api.models.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> getAll();
    List<Producto> getByModel(String model);
    Producto add(Producto producto);
    Producto update(Producto producto, Integer id);

}
