package com.example.demo.Servicio;

import com.example.demo.Entidades.Libro;
import com.example.demo.Repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ImpLibroServicio implements LibroServicio, UserDetailsService {
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
    public void eliminarLibro(Long id) {
        repositorio.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
