package com.proyectoApi.pocs.springboot.Persistence;

import java.util.List;

/**
 * Created by Facundo on 30/05/2017.
 */
public abstract class AbstractDao<K> {
    public AbstractDao() {

    }

    abstract List<K> getAll();
    abstract K getById(int id);
    abstract void save(K value);
}
