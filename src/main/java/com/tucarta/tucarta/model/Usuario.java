package com.tucarta.tucarta.model;

import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String email;

   private List<Comercio> comercios;

    public Usuario() {
    }



    public Usuario(String id, String nombre, List<Comercio> comercios, String email) {
        this.id = id;
        this.nombre = nombre;
        this.comercios = comercios;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Comercio> getComercios() {
        return comercios;
    }

    public void setComercios(List<Comercio> comercios) {
        this.comercios = comercios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
