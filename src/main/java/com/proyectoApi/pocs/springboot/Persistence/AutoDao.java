package com.proyectoApi.pocs.springboot.Persistence;

import com.proyectoApi.pocs.springboot.Entities.Auto;
import com.proyectoApi.pocs.springboot.Entities.Marca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Facundo on 30/05/2017.
 */
public class AutoDao extends AbstractDao<Auto> {

    private List<Auto> listAutos;
    private static int LAST_ID = 0;

    public AutoDao(){
        super();
        this.listAutos = new ArrayList<Auto>();
    }

    //Traer todos

    public List<Auto> getAll() {
        return listAutos;
    }

    //Traer mediante id

    public Auto getById(int id) {
        for(Auto a : listAutos){
            if (id == a.getId()){
                return a;
            }
        }
        return null;
    }

    //Traer por patente

    public List<Auto> getByPatente(String patente) {
        List<Auto> result = new ArrayList<Auto>();
        for (Auto a : listAutos) {
            if (patente.equals(a.getPatente()))
                result.add(a);
        }
        return result;
    }

    //Traer por modelo

    public List<Auto> getByModelo(String modelo) {
        List<Auto> result = new ArrayList<Auto>();
        for (Auto a : listAutos) {
            if (modelo.equals(a.getModelo()))
                result.add(a);
        }
        return result;
    }

    //Traer por marca

    public List<Auto> getByMarca(String descripcionMarca) {
        List<Auto> result = new ArrayList<Auto>();
        for (Auto a : listAutos) {
            if (descripcionMarca.equals(a.getMarca().getDescripcion()))
                result.add(a);
        }
        return result;
    }

    //Agrega a la lista de autos

    public void save(Auto auto) {
        auto.setId(++LAST_ID);
        listAutos.add(auto);
    }

    //Agregar autos al construir en controller

    public void addCars(){
        Date fecha = new Date();
        Marca marcaUno = new Marca("Ford");
        Auto uno = new Auto(marcaUno, "Modelo uno", 20000, "abc 123", fecha);

        this.save(uno);
    }
}

