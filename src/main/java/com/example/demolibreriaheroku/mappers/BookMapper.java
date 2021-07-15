package com.example.demolibreriaheroku.mappers;

import com.example.demolibreriaheroku.DTO.BookDTO;
import com.example.demolibreriaheroku.collections.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public Book DTOtoBook(BookDTO bookDTO){
        return new Book(bookDTO.getId(), bookDTO.getNombre(), bookDTO.getCategoria(), bookDTO.getAutor());
    }

    public BookDTO bookToDTO(Book book){
        return new BookDTO(book.getId(), book.getNombre(), book.getCategoria(), book.getAutor());
    }

    public List<BookDTO> bookToListDTO(List<Book> book){
        return book.stream().map(this::bookToDTO).collect(Collectors.toUnmodifiableList());
    }
}

