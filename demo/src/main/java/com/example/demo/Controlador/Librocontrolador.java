package com.example.demo.Controlador;
import com.example.demo.Entidades.Libro;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicio.LibroServicio;
import com.example.demo.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class Librocontrolador {

    @Autowired
    private LibroServicio libroServicio;


    @Autowired
    private UsuarioServicio Uservicio;

    @GetMapping("/home")
    public String home(){

        return "home";
    }
    @GetMapping("/login")
    public String iniciarSesion(){

        return "login";
    }

    @GetMapping("usuario")
    public String verPaginaDeUsuario(Model modelo){//no se que onda aca
        List<Usuario> usuario = Uservicio.listarUsuarios();
        modelo.addAttribute("usuario", usuario);
        return "registro";
    }

    @GetMapping("/listar")
    public String verPaginaDeInicioC(Model modelo) {//ModelMap pasa variables del controlador a nuestro html
        List<Libro> libro = libroServicio.listarTodosLosLibros();

        modelo.addAttribute("libro", libro);//addAtribute manda 2 argumentos, el identificador
        //que coincide con el Thymeleaf y el objeto que queremos mandar por html
        return "lista";
    }


    @GetMapping("/new")
    public String crearLibro (Model modelo){

        modelo.addAttribute("libro", new Libro());
        return "crear_libro";
    }


    @PostMapping("/save")
    public String guardarLibro(@Validated Libro libro, BindingResult bindingResult,
                               RedirectAttributes redirect, Model modelo) {

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("libro", libro);
            return "crear_autor";
        }

        libroServicio.guardarLibro(libro);
        redirect.addFlashAttribute("msgExito", "El libro ha" +
                " sido agregado con exito");

        return "redirect:/listar";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarLibro(@PathVariable Long id, Model modelo) {
        Libro libro = libroServicio.obtenerLibroPorId(id);
        modelo.addAttribute("libro", libro);
        return "editar_libro";
    }

    @PostMapping("/editar/{id}")
    public String actualizarLibro(@PathVariable Long id,@Validated Libro libro,
                                  BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {

        Libro libroDB = libroServicio.obtenerLibroPorId(id);
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("libro", libro);
            return "editar_libro";
        }

        libroDB.setIsbn(libro.getIsbn());
        libroDB.setTitulo(libro.getTitulo());


        libroServicio.guardarLibro(libroDB);
        redirect.addFlashAttribute("msgExito", "El autor " +
                "ha sido actualizado correctamente");

        return "redirect:/listar";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long Id,RedirectAttributes redirect) {
        Libro libro = libroServicio.obtenerLibroPorId(Id);

        libroServicio.eliminarLibro((Long) libro.getId());

        redirect.addFlashAttribute("msgExito", "El autor ha " +
                "sido eliminado correctamente");

        return "redirect:/listar";
    }

}
