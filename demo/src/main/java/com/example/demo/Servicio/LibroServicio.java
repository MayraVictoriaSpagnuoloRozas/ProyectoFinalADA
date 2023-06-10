package com.example.demo.Servicio;

import com.example.demo.Entidades.Libro;

import java.util.List;

public interface LibroServicio {
    public List<Libro> listarTodosLosLibros();

    public Libro guardarLibro(Libro libro);

    public Libro obtenerLibroPorIsbn(Long isbn);

    public Libro actualizarLibro(Libro libro);

    public void eliminarLibro(Long isbn);
}
