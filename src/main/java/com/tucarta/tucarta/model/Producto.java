package com.tucarta.tucarta.model;

public class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String imagenUr;
    private Atributos atributos;

    public Producto() {
    }

    public Producto(String id, String nombre, String descripcion, Double precio, String imagenUr, Atributos atributos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenUr = imagenUr;
        this.atributos = atributos;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagenUr() {
        return imagenUr;
    }

    public void setImagenUr(String imagenUr) {
        this.imagenUr = imagenUr;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }
}
