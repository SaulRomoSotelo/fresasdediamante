package com.quiroba.fresas_de_diamante.api.repositories;

import com.quiroba.fresas_de_diamante.api.models.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
