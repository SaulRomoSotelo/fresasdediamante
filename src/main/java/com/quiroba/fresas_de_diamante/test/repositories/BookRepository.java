package com.quiroba.fresas_de_diamante.test.repositories;

import com.quiroba.fresas_de_diamante.test.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
