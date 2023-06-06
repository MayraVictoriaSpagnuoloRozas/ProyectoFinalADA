package Servicio;

import Entidades.Autor;
import Entidades.Libro;

import java.util.List;

public interface LibroServicio {
    public List<Libro> listarTodosLosLibros();

    public Libro guardarLibro(Libro libro);

    public Libro obtenerLibroPorIsbn(Long isbn);

    public Libro actualizarLibro(Libro libro);

    public void eliminarLibro(Long isbn);
}
