package com.proyectoApi.pocs.springboot.Persistence;

import com.proyectoApi.pocs.springboot.Entities.Marca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Facundo on 30/05/2017.
 */
public class MarcaDao extends AbstractDao<Marca> {

    private static List<Marca> listMarcas;
    private static int LAST_ID = 0;

    public MarcaDao(){
        super();
        this.listMarcas = new ArrayList<Marca>();
    }

    public List<Marca> getAll() {
        return listMarcas;
    }

    public Marca getById(int id) {
        for(Marca m : listMarcas){
            if (id == m.getId()){
                return m;
            }
        }
        return null;
    }

    public List<Marca> getByDescripcion(String descripcion) {
        List<Marca> result = new ArrayList<Marca>();
        for (Marca m : listMarcas) {
            if (descripcion.equals(m.getDescripcion()))
                result.add(m);
        }
        return result;
    }

    public void save(Marca marca) {
        marca.setId(++LAST_ID);
        listMarcas.add(marca);
    }
}
