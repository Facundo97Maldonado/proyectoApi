package com.proyectoApi.pocs.springboot.Service;

import com.proyectoApi.pocs.springboot.Entities.Auto;
import com.proyectoApi.pocs.springboot.Entities.Marca;
import com.proyectoApi.pocs.springboot.Persistence.AutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Facundo on 31/05/2017.
 */

@Service
public class AutoService {
    AutoDao autoDao;

    @Autowired
    public AutoService(AutoDao autoDao){
        this.autoDao = autoDao;
    }

    public List<Auto> getAll(){
        return this.autoDao.getAll();
    }

    public Auto getAutoById(int id){
        return this.autoDao.getById(id);
    }

    //Crea nuevo auto y lo guarda(agrega a la lista)

    public void agregarAuto(Marca marca, String modelo, int kilometros, String patente, Date anio)  throws ParseException {
        Auto auto = new Auto();
        auto.setMarca(marca);
        auto.setModelo(modelo);
        auto.setKilometros(kilometros);
        auto.setPatente(patente);
        auto.setAnio(anio);
        this.autoDao.save(auto);
    }

    public List<Auto> getAutoByMarca(String marca){
        return this.autoDao.getByMarca(marca);
    }
}
