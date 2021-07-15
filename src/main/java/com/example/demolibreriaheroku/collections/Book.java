package com.example.demolibreriaheroku.collections;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    @Id
    private String id;
    @NonNull
    private String nombre;
    @NonNull
    private String categoria;
    @NonNull
    private String autor;

    public Book() {
    }

    public Book(@NonNull String nombre, @NonNull String categoria, @NonNull String autor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Book(String id, @NonNull String nombre, @NonNull String categoria, @NonNull String autor) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
