package com.example.demolibreriaheroku.service;

import com.example.demolibreriaheroku.collections.Book;
import com.example.demolibreriaheroku.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

@SpringBootTest
public class BookServiceTest {

    @MockBean
    private BookRepository bookRepo;

    @Autowired
    private BookService bookService;


    @Test
    @DisplayName("test obtener todos")
    public void obtenerLibrosTest(){
        var book = new Book("12","el extranjero", "universal","camus");
        var book1 = new Book("10","crimen y castigo", "universal","dostoievky");
        var list = new ArrayList<Book>();
        list.add(book);
        list.add(book1);

        Mockito.when(bookRepo.findAll()).thenReturn(list);

        var result = bookService.listBook();
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(book.getAutor(),result.get(0).getAutor());
        Assertions.assertEquals(book1.getCategoria(),result.get(1).getCategoria());

    }

    @Test
    @DisplayName("obtener por categoria")
    public void obtenerPorCategoriaTest(){
        var book = new Book("12","el extranjero", "universal","camus");
        var book1 = new Book("10","cien años de soledad", "realismos magico","gabo");
        var book2 = new Book("11","el horror de dunwich", "terror","lovecraf");
        var list = new ArrayList<Book>();
        list.add(book);
        Mockito.when(bookRepo.findBookByCategoria("universal")).thenReturn(list);
        var resul = bookService.listBookCategory("universal");

        Assertions.assertEquals(book.getNombre(), resul.get(0).getNombre());
    }
}
