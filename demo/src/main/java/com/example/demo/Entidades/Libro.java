package com.example.demo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="libro_id")
    private Long id;

    @Column (name= "isbn", length = 100, nullable = false)
    private Long isbn;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "añoEdicion", length = 100, nullable = false)
    private Integer añoDeEdicion;

    @Column(name = "cantidadEjemplares", length = 100, nullable = false)
    private Integer cantidadDeEjemplares;

    @Column(name = "condicionEjemplar", length = 100, nullable = false)
    private Integer condicionDelEjemplar;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;


    public Libro(){

    }

    public Libro(Long id, Long isbn, String titulo, Integer añoDeEdicion, Integer cantidadDeEjemplares, Integer condicionDelEjemplar, Autor autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.añoDeEdicion = añoDeEdicion;
        this.cantidadDeEjemplares = cantidadDeEjemplares;
        this.condicionDelEjemplar = condicionDelEjemplar;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAñoDeEdicion() {
        return añoDeEdicion;
    }

    public void setAñoDeEdicion(Integer añoDeEdicion) {
        this.añoDeEdicion = añoDeEdicion;
    }

    public Integer getCantidadDeEjemplares() {
        return cantidadDeEjemplares;
    }

    public void setCantidadDeEjemplares(Integer cantidadDeEjemplares) {
        this.cantidadDeEjemplares = cantidadDeEjemplares;
    }

    public Integer getCondicionDelEjemplar() {
        return condicionDelEjemplar;
    }

    public void setCondicionDelEjemplar(Integer condicionDelEjemplar) {
        this.condicionDelEjemplar = condicionDelEjemplar;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}

