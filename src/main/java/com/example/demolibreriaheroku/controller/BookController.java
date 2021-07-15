package com.example.demolibreriaheroku.controller;


import com.example.demolibreriaheroku.DTO.BookDTO;
import com.example.demolibreriaheroku.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public ResponseEntity<List<BookDTO>> listBook(){
        return new ResponseEntity<>(bookService.listBook(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/listcategory/{id}")
    public ResponseEntity<List<BookDTO>> listByCategory(@PathVariable("id") String id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(bookService.listBookCategory(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook (@RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(bookService.saveBook(bookDTO), HttpStatus.ACCEPTED);
    }
}
