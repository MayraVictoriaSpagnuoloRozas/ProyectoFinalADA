package com.example.demo.Repositorio;

import com.example.demo.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    @Override
    Usuario getById(Long id);
    List<Usuario> findAll();
    public Usuario findByEmail(String email);
}
