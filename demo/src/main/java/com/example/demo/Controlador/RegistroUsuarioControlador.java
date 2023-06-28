package com.example.demo.Controlador;
import com.example.demo.Dto.UsuarioDto;
import com.example.demo.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioDto retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioDto();
    }

    @GetMapping
    public String MostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioDto usuarioDto){
        usuarioServicio.guardar(usuarioDto);
        return "redirect:/registro?exito";
    }




}
