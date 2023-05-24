package com.quiroba.fresas_de_diamante.test.repositories;

import com.quiroba.fresas_de_diamante.test.models.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
