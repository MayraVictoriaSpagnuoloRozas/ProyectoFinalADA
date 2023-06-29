package com.example.demo.Dto;

public class UsuarioDto {
    private long id;
    private String password;
    private String nombre;
    private String apellido;
    private String email;

    public UsuarioDto() {

    }

    public UsuarioDto(long id, String password, String nombre, String apellido, String email) {
        this.id = id;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    public UsuarioDto(String password, String nombre, String apellido, String email) {
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UsuarioDto(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


