package com.proyectoApi.pocs.springboot.Entities;

/**
 * Created by Facundo on 30/05/2017.
 */
public class Marca {
    private int id;
    private String descripcion;

    public Marca(){
        this.descripcion = "";
    }

    public Marca(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
