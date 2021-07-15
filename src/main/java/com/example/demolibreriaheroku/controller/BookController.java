package com.example.demolibreriaheroku.controller;


import com.example.demolibreriaheroku.DTO.BookDTO;
import com.example.demolibreriaheroku.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public List<BookDTO> listBook(){
        return bookService.listBook();
    }

    @GetMapping("/listcategory/{id}")
    public List<BookDTO> listByCategory(@PathVariable("id") String id){
        return bookService.listBookCategory(id);
    }
}
