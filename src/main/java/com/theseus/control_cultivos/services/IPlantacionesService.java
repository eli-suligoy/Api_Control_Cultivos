package com.theseus.control_cultivos.services;

import com.theseus.control_cultivos.entities.Cultivos;
import com.theseus.control_cultivos.entities.Plantaciones;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IPlantacionesService {
    List<Plantaciones> getAll();
    List<Plantaciones> findByPeriodo(String periodo);
    List<Plantaciones> getAllPeriodo(String periodo);
    List<Plantaciones> getAllFecha(LocalDate dFecha, LocalDate hFecha);
    List<Plantaciones> getPeriodoCultivo(String periodo, Cultivos cultivo);
    Plantaciones get(String id);
    void save(Plantaciones entity);
    String delete(Plantaciones entity);
}
