package com.example.demo.Servicio;

import com.example.demo.Dto.UsuarioDto;
import com.example.demo.Entidades.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardar(UsuarioDto usuarioDto);


}


