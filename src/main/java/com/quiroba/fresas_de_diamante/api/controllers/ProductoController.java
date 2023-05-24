package com.quiroba.fresas_de_diamante.api.controllers;

import com.quiroba.fresas_de_diamante.api.models.entities.Producto;
import com.quiroba.fresas_de_diamante.api.services.interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> allProductos() {
        return  ResponseEntity.ok().body(productoService.getAll());
    }
    @GetMapping("/model/{modelo}")
    public ResponseEntity<?> getByModelo(@PathVariable String modelo) { return ResponseEntity.ok(productoService.getByModel(modelo)); }

    @PostMapping
    public ResponseEntity<?> addProducto(@RequestBody Producto producto) { return ResponseEntity.ok(productoService.add(producto)); }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        producto.setId(id);
        return ResponseEntity.ok(productoService.update(producto, id));
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

}
