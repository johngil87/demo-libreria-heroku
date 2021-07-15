package com.example.demolibreriaheroku.repository;

import com.example.demolibreriaheroku.collections.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findBookByCategoria(String categoria);
}
