package Entidades;

import javax.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @JoinColumn(name = "autor_libro",
            //joincolumns=@JoinColumn(name = "libro_id", referencedColumnName = "id"),
            //inversejoincolumns=@JoinColumn(name = "autor_id", referencedColumnName = "id"))
    //private Autor autor; NO IRIA ASI PARA HACER EL JOIN ENTRE AUTOR Y LIBRO???

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "Año de edicion", length = 100, nullable = false)
    private int añoDeEdicion;

    @Column(name = "Cantidad de ejemplares", length = 100, nullable = false)
    private int cantidadDeEjemplares;

    @Column(name = "Condicion del ejemplar", length = 100, nullable = false)
    private int condicionDelEjemplar;

    public Libro(){

    }

    public Libro(long isbn, Autor autor, String titulo, int añoDeEdicion, int cantidadDeEjemplares,
                 int condicionDelEjemplar) {
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.añoDeEdicion = añoDeEdicion;
        this.cantidadDeEjemplares = cantidadDeEjemplares;
        this.condicionDelEjemplar = condicionDelEjemplar;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoDeEdicion() {
        return añoDeEdicion;
    }

    public void setAñoDeEdicion(int añoDeEdicion) {
        this.añoDeEdicion = añoDeEdicion;
    }

    public int getCantidadDeEjemplares() {
        return cantidadDeEjemplares;
    }

    public void setCantidadDeEjemplares(int cantidadDeEjemplares) {
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }

    public int getCondicionDelEjemplar() {
        return condicionDelEjemplar;
    }

    public void setCondicionDelEjemplar(int condicionDelEjemplar) {
        this.condicionDelEjemplar = condicionDelEjemplar;
    }
}
