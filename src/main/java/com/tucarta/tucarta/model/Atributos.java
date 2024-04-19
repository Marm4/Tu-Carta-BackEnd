package com.tucarta.tucarta.model;

public class Atributos {
    private boolean vegano;
    private boolean vegetariano;
    private boolean taccFree;
    private boolean carne;
    private boolean pescado;
    private boolean pastas;

    public Atributos() {
    }

    public Atributos(boolean vegano, boolean vegetariano, boolean taccFree, boolean carne, boolean pescado, boolean pastas) {
        this.vegano = vegano;
        this.vegetariano = vegetariano;
        this.taccFree = taccFree;
        this.carne = carne;
        this.pescado = pescado;
        this.pastas = pastas;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    public boolean isTaccFree() {
        return taccFree;
    }

    public void setTaccFree(boolean taccFree) {
        this.taccFree = taccFree;
    }

    public boolean isCarne() {
        return carne;
    }

    public void setCarne(boolean carne) {
        this.carne = carne;
    }

    public boolean isPescado() {
        return pescado;
    }

    public void setPescado(boolean pescado) {
        this.pescado = pescado;
    }

    public boolean isPastas() {
        return pastas;
    }

    public void setPastas(boolean pastas) {
        this.pastas = pastas;
    }
}
