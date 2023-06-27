package com.example.demo.Controlador;
import com.example.demo.Entidades.Autor;
import com.example.demo.Entidades.Libro;
import com.example.demo.Servicio.AutorServicio;
import com.example.demo.Servicio.LibroServicio;
import com.example.demo.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
@Controller
public class Librocontrolador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;


    @Autowired
    private UsuarioServicio usuarioServicio;


    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(){
        return "index";
    }

    @GetMapping("/home")
    public String paginaPrincipal(){
        return "home";
    }

    @GetMapping("/libros")
    public String listarLibros(Model modelo) {
        modelo.addAttribute("libros", libroServicio.listarTodosLosLibros());
        return "libros";
    }

    @GetMapping("/libro/nuevo")
    public String crearLibroFormulario(Model modelo) {
        Libro libro = new Libro();
        List<Autor> listaAutores = autorServicio.listarTodosLosAutores();

        modelo.addAttribute("libro", libro);
        modelo.addAttribute("autor", listaAutores);

        return "crear_libro";
    }

    @PostMapping("/libro")
    public String guardarLibro(@ModelAttribute("libro") Libro libro, RedirectAttributes redirect) {
        libroServicio.guardarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha" +
                " sido agregado con exito");

        return "redirect:/libros";
    }

    @GetMapping("/libro/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("libro", libroServicio.obtenerLibroPorId(id));
        return "editar_libro";
    }

    @PostMapping("/libro/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro, Model modelo) {
        Libro libroExistente = libroServicio.obtenerLibroPorId(id);

        libroExistente.setIsbn(libro.getIsbn());
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAñoDeEdicion(libro.getAñoDeEdicion());
        libroExistente.setCantidadDeEjemplares(libro.getCantidadDeEjemplares());
        libroExistente.setCondicionDelEjemplar(libro.getCondicionDelEjemplar());

        libroServicio.actualizarLibro(libroExistente);
        return "redirect:/libros";
    }


    @PostMapping("/eliminar/libro/{id}")
    public String eliminarLibro(@PathVariable Long id, RedirectAttributes redirect) {
        Libro libro = libroServicio.obtenerLibroPorId(id);

        libroServicio.eliminarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha " +
                "sido eliminado correctamente");

        return "redirect:/libros";

    }

}
