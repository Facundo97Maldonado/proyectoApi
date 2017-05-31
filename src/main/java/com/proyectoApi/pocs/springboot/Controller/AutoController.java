package com.proyectoApi.pocs.springboot.Controller;

import com.proyectoApi.pocs.springboot.Entities.Auto;
import com.proyectoApi.pocs.springboot.Persistence.AutoDao;
import com.proyectoApi.pocs.springboot.Service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Facundo on 30/05/2017.
 */
@RestController
public class AutoController {

    @Autowired
    AutoService autoService;


    //Traer todos los autos

    @RequestMapping(value = "/autos/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Auto>> getAll(){

        //this.autoDao.addCars();

        if(this.autoService.getAll().size() > 0){
            return new ResponseEntity<List<Auto>>(this.autoService.getAll(), HttpStatus.OK);
        }else{
            return new ResponseEntity<List<Auto>>(HttpStatus.NO_CONTENT);
        }
    }

    //Traer auto mediante id

    @RequestMapping(value = "/autos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Auto> getById(@PathVariable("id") int id){
        if ( autoService.getAutoById(id) != null) {
            return  new ResponseEntity<Auto>( autoService.getAutoById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //Traer auto mediante marca

    @RequestMapping(value = "/autos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Auto>> getByMarca(@RequestParam("marca") String marca){
        if(autoService.getAutoByMarca(marca) != null){
            return new ResponseEntity<List<Auto>>(autoService.getAutoByMarca(marca), HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //Agregar un auto

    @RequestMapping(value = "/autos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity agregarAuto(@RequestBody Auto auto) {
        try {
            autoService.agregarAuto(auto.getMarca(), auto.getModelo(), auto.getKilometros(), auto.getPatente(), auto.getAnio());
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
