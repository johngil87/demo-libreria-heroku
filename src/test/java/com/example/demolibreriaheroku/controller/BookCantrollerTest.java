package com.example.demolibreriaheroku.controller;

import com.example.demolibreriaheroku.DTO.BookDTO;
import com.example.demolibreriaheroku.collections.Book;
import com.example.demolibreriaheroku.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class BookCantrollerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("crear libro")
    public void crearLibroTest() throws Exception {

        var bookDTO = new BookDTO("10", "cien años de soledad", "realismos magico", "gabo");

        doReturn(bookDTO).when(bookService).saveBook(any());

        mockMvc.perform(post("/book/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(bookDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre", is("cien años de soledad")));

    }

    @Test
    @DisplayName("obtener libros")
    public void  obtenerLibrosTest() throws Exception{

        var bookDTO = new BookDTO("10", "cien años de soledad", "realismos magico", "gabo");
        var bookDTO1 = new BookDTO("10", "cien años de soledad", "realismos magico", "gabo");
        var list = new ArrayList<BookDTO>();
        list.add(bookDTO);
        list.add(bookDTO);
        doReturn(list).when(bookService).listBook();

        mockMvc.perform(get("/book/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].autor", is("gabo")));
    }



    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
