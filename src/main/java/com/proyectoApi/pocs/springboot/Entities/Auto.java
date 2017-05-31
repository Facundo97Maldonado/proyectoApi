package com.proyectoApi.pocs.springboot.Entities;

import java.util.Date;

/**
 * Created by Facundo on 30/05/2017.
 */
public class Auto {
    private int id;
    private Marca marca;
    private String modelo;
    private int kilometros;
    private String patente;
    private Date anio;

    public Auto(){
        this.marca = new Marca();
        this.modelo = "";
        this.kilometros = 0;
        this.patente = "";
        this.anio = new Date();
    }

    public Auto(Marca marca, String modelo, int kilometros, String patente, Date anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.kilometros = kilometros;
        this.patente = patente;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }
}
