package com.example.demolibreriaheroku.service;

import com.example.demolibreriaheroku.DTO.BookDTO;
import com.example.demolibreriaheroku.mappers.BookMapper;
import com.example.demolibreriaheroku.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private BookMapper bookMapper;

    public List<BookDTO> listBook(){
        return bookMapper.bookToListDTO(bookRepository.findAll());
    }

    public List<BookDTO> listBookCategory(String categoria){
        return bookMapper.bookToListDTO(bookRepository.findBookByCategoria(categoria));
    }
}
