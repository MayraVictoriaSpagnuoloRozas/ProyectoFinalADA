package Servicio;

import Entidades.Autor;

import java.util.List;

public interface AutorServicio {
    public List<Autor> listarTodosLosAutores();

    public Autor guardarAutor(Autor autor);

    public Autor obtenerAutorPorId(Integer id);

    public Autor actualizarAutor(Autor autor);

    public void eliminarContacto(Integer id);
}
