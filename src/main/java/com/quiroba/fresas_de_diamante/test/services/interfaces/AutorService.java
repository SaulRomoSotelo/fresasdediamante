package com.quiroba.fresas_de_diamante.test.services.interfaces;


import com.quiroba.fresas_de_diamante.test.models.entities.Autor;

import java.util.List;

public interface AutorService {
    List<Autor> getAll();
    Autor add(Autor autor);

}
