package com.example.demo.Entidades;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Long Id;

    @Column(name = "autor_nombre", length = 100, nullable = false)
    private String autorNombre;

    @Column(name = "autor_apellido", length = 100, nullable = false)
    private String autorApellido;

    @Column(name = "fecha_nacimiento_autor", length = 100, nullable = false)
    private Integer fechaDeNacimiento;

    @Column(name = "lugar_nacimiento_autor", length = 100, nullable = false)
    private String lugarDeNacimiento;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor(){

    }

    public Autor(Long id, String autorNombre, String autorApellido, Integer fechaDeNacimiento,
                 String lugarDeNacimiento, List<Libro> libros) {
        Id = id;
        this.autorNombre = autorNombre;
        this.autorApellido = autorApellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.lugarDeNacimiento = lugarDeNacimiento;
        this.libros = libros;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getAutorApellido() {
        return autorApellido;
    }

    public void setAutorApellido(String autorApellido) {
        this.autorApellido = autorApellido;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
