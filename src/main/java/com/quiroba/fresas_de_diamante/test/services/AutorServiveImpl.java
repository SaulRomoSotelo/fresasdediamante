package com.quiroba.fresas_de_diamante.test.services;

import com.quiroba.fresas_de_diamante.test.models.entities.Autor;
import com.quiroba.fresas_de_diamante.test.models.entities.Book;
import com.quiroba.fresas_de_diamante.test.repositories.AutorRepository;
import com.quiroba.fresas_de_diamante.test.repositories.BookRepository;
import com.quiroba.fresas_de_diamante.test.services.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AutorServiveImpl implements AutorService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }


    @Override
    public Autor add(Autor autor) {
        List<Book> books = autor.getBooks();
        autor = autorRepository.save(autor);
        Autor a = Autor.builder().id(autor.getId()).build();
        books.stream().forEach(b->b.setAutor(a));
        books = bookRepository.saveAll(books);
        autor.setBooks(books);
        return autor;
    }
}
