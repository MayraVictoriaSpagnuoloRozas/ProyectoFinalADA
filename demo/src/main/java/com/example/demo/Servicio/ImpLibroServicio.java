package com.example.demo.Servicio;

import com.example.demo.Entidades.Libro;
import com.example.demo.Repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImpLibroServicio implements LibroServicio {
    @Autowired
    private LibroRepositorio repositorio;
    @Override
    public List<Libro> listarTodosLosLibros() {
        return repositorio.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {

        return repositorio.save(libro);
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {

        return repositorio.getById(id);
    }

    @Override
    public Libro actualizarLibro(Libro libro) {

        return repositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        repositorio.delete(libro);

    }

}
