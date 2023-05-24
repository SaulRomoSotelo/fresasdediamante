package com.quiroba.fresas_de_diamante.api.services;

import com.quiroba.fresas_de_diamante.api.models.entities.Producto;
import com.quiroba.fresas_de_diamante.api.repositories.ProductoRepository;
import com.quiroba.fresas_de_diamante.api.services.interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> getByModel(String model) {
        return productoRepository.findByModelo(model);
    }

    @Override
    public Producto add(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto, Integer id) { return productoRepository.save(producto);}
}
