package com.tucarta.tucarta.model;

public class Caracteristicas {
    private boolean vegano;
    private boolean petFriendly;
    private boolean glutenFree;
    private boolean wifi;

    public Caracteristicas() {
    }

    public Caracteristicas(boolean vegano, boolean petFriendly, boolean glutenFree, boolean wifi) {
        this.vegano = vegano;
        this.petFriendly = petFriendly;
        this.glutenFree = glutenFree;
        this.wifi = wifi;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
