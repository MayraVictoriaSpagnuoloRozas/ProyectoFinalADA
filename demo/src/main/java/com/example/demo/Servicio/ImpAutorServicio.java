package com.example.demo.Servicio;

import com.example.demo.Entidades.Autor;
import com.example.demo.Repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ImpAutorServicio implements AutorServicio, UserDetailsService {
    @Autowired
    private AutorRepositorio repositorio;
    @Override
    public List<Autor> listarTodosLosAutores() {

        return repositorio.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {

        return repositorio.save(autor);
    }

    @Override
    public Autor obtenerAutorPorId(Integer Id) {

        return repositorio.findById(Id).get();
    }

    @Override
    public Autor actualizarAutor(Autor autor) {

        return repositorio.save(autor);
    }

    @Override
    public void eliminarContacto(Integer Id) {
        return repositorio.deleteById(Id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
