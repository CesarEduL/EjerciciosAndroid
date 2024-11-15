package com.utp.ejercicios.GridViewParameters;

public class Negocio {
    private String nombre;
    private int imagenCarrito;
    private int imagenCoche;

    public Negocio(String nombre, int imagenCarrito, int imagenCoche) {
        this.nombre = nombre;
        this.imagenCarrito = imagenCarrito;
        this.imagenCoche = imagenCoche;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenCarrito() {
        return imagenCarrito;
    }

    public int getImagenCoche() {
        return imagenCoche;
    }
}

