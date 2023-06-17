package com.example.demo.Controlador;
import com.example.demo.Entidades.Autor;
import com.example.demo.Servicio.AutorServicio;
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
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;


    @Autowired
    private AutorServicio Aservicio;


    @GetMapping("/login")
    public String iniciarSesion(){

        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo){
        modelo.addAttribute("autor", Aservicio.listarTodosLosAutores());
        return "index";
    }

    @GetMapping("/home")
    public String home(){

        return "home";
    }


    @GetMapping("/listar")
    public String verPaginaDeInicioC(Model modelo) {//ModelMap pasa variables del controlador a nuestro html
        List<Autor> autor = autorServicio.listarTodosLosAutores();

        modelo.addAttribute("autor", autor);//addAtribute manda 2 argumentos, el identificador
        //que coincide con el Thymeleaf y el objeto que queremos mandar por html
        return "lista";
    }


    @GetMapping("/new")
    public String crearAutor (Model modelo){

        modelo.addAttribute("autor", new Autor());
        return "crear_autor";
    }


    @PostMapping("/save")
    public String guardarAutor(@Validated Autor autor, BindingResult bindingResult,
                                  RedirectAttributes redirect, Model modelo) {

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("autor", autor);
            return "crear_autor";
        }

        autorServicio.guardarAutor(autor);
        redirect.addFlashAttribute("msgExito", "El autor ha" +
                " sido agregado con exito");

        return "redirect:/listar";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarAutor(@PathVariable Long id, Model modelo) {
        Autor autor = autorServicio.obtenerAutorPorId(id);
        modelo.addAttribute("autor", autor);
        return "editar_autor";
    }

    @PostMapping("/editar/{id}")
    public String actualizarAutor(@PathVariable Long id,@Validated Autor autor,
                                     BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {

        Autor autorDB = autorServicio.obtenerAutorPorId(id);
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("autor", autor);
            return "editar_autor";
        }

        autorDB.setAutorNombre(autor.getAutorNombre());
        autorDB.setAutorApellido(autor.getAutorApellido());


        autorServicio.guardarAutor(autorDB);
        redirect.addFlashAttribute("msgExito", "El autor " +
                "ha sido actualizado correctamente");

        return "redirect:/listar";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Long Id,RedirectAttributes redirect) {
        Autor autor = autorServicio.obtenerAutorPorId(Id);

        autorServicio.eliminarautor((Long) autor.getId());

        redirect.addFlashAttribute("msgExito", "El autor ha " +
                "sido eliminado correctamente");

        return "redirect:/listar";
    }

}



