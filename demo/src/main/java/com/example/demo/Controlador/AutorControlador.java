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



    @GetMapping("/autor")
    public String verPaginaDeInicio(Model modelo) {//ModelMap pasa variables del controlador al html
        modelo.addAttribute("autor", autorServicio.listarTodosLosAutores());//addAtribute manda 2 argumentos, el identificador
        //que coincide con el Thymeleaf y el objeto que mando por html
        return "autor";// aca paso algo???
    }


    @GetMapping("/nuevoAutor")
    public String crearAutor (Model modelo){
        Autor autor = new Autor();
        modelo.addAttribute("autor", autor);
        return "nuevoAutor";
    }


    @PostMapping("/autor")
    public String guardarAutor(@Validated Autor autor, BindingResult bindingResult,
                                  RedirectAttributes redirect, Model modelo) {

        if(bindingResult.hasErrors()) {
            modelo.addAttribute("autor", autor);
            return "nuevoAutor";
        }

        autorServicio.guardarAutor(autor);
        redirect.addFlashAttribute("msgExito", "El autor ha" +
                " sido agregado con exito");

        return "redirect:/autor";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarAutor(@PathVariable Long id, Model modelo) {
        Autor autor = autorServicio.obtenerAutorPorId(id);
        modelo.addAttribute("autor", autor);
        return "nuevoAutor";
    }

    @PostMapping("/editar/{id}")
    public String actualizarAutor(@PathVariable Long id,@Validated Autor autor,
                                     BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {

        Autor autorDB = autorServicio.obtenerAutorPorId(id);
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("autor", autor);
            return "nuevoAutor";
        }

        autorDB.setAutorNombre(autor.getAutorNombre());
        autorDB.setAutorApellido(autor.getAutorApellido());


        autorServicio.guardarAutor(autorDB);
        redirect.addFlashAttribute("msgExito", "El autor " +
                "ha sido actualizado correctamente");

        return "redirect:/autor";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Long Id, RedirectAttributes redirect) {
        Autor autor = autorServicio.obtenerAutorPorId(Id);

        autorServicio.eliminarautor(autor);

        redirect.addFlashAttribute("msgExito", "El autor ha " +
                "sido eliminado correctamente");

        return "redirect:/autor";
    }

}



