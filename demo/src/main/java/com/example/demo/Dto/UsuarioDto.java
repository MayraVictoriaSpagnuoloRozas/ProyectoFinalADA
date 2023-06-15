package com.example.demo.Dto;

public class UsuarioDto {
    private long id;
    private String rol;
    private String password;

    public UsuarioDto(long id, String rol, String password) {
        this.id = id;
        this.rol = rol;
        this.password = password;
    }

    public UsuarioDto(String rol, String password) {
        this.rol = rol;
        this.password = password;
    }

    public UsuarioDto() {

    }

    public long getId() {
        return id;
    }


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


