package com.example.demo.Servicio;

import com.example.demo.Entidades.Autor;
import com.example.demo.Servicio.AutorServicio;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AutorServicio {
    public List<Autor> listarTodosLosAutores();

    public Autor guardarAutor(Autor autor);

    public Autor obtenerAutorPorId(Long id);

    public Autor actualizarAutor(Autor autor);

    public void eliminarautor(Autor autor);
}
