package com.tucarta.tucarta.model;

import java.util.List;

public class Comercio {
    private String id;
    private String nombre;
    private String indentificador;
    private String ubicacion;
    private String telefono;
    private String bannerUrl;
    private String logoUrl;
    private String conocenos;
    private List<Producto> productos;

    private Caracteristicas caracteristicas;


    public Comercio() {
    }

    public Comercio(String id, String nombre, String indentificador, String ubicacion, String telefono, String bannerUrl, String logoUrl, String conocenos, List<Producto> productos, Caracteristicas caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.indentificador = indentificador;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.bannerUrl = bannerUrl;
        this.logoUrl = logoUrl;
        this.conocenos = conocenos;
        this.productos = productos;
        this.caracteristicas = caracteristicas;
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

    public String getIndentificador() {
        return indentificador;
    }

    public void setIndentificador(String indentificador) {
        this.indentificador = indentificador;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getConocenos() {
        return conocenos;
    }

    public void setConocenos(String conocenos) {
        this.conocenos = conocenos;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
