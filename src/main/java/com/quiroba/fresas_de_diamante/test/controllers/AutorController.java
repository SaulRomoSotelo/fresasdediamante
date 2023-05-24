package com.quiroba.fresas_de_diamante.test.controllers;

import com.quiroba.fresas_de_diamante.test.models.entities.Autor;
import com.quiroba.fresas_de_diamante.test.services.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping("/")
    public ResponseEntity<?> obtenerTodos() {
        List<Autor> all = autorService.getAll();
        /*all.stream().forEach(a->a.setBooks(null));*/
        return ResponseEntity.ok(all);
    }

    @PostMapping("/")
    public ResponseEntity<?> registrar(@RequestBody Autor autor) {
        Autor autorDb = autorService.add(autor);

        return ResponseEntity.ok(autorDb);
    }
}
