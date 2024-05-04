package com.theseus.control_cultivos.services;

import com.theseus.control_cultivos.entities.Plantaciones;

import java.util.List;

public interface IPlantacionesService {
    List<Plantaciones> getAll();
    List<Plantaciones> findByPeriodo(String periodo);
    Plantaciones get(String id);
    void save(Plantaciones entity);
    String delete(Plantaciones entity);
}
