package com.theseus.control_cultivos.services;



import com.theseus.control_cultivos.entities.Gastos;

import java.util.Date;
import java.util.List;

public interface IGastosService {
    List<Gastos> getAll();
    List<Gastos> findByFecha(Date fecha);
    Gastos get(String id);
    void save(Gastos entity);
    String delete(Gastos entity);
}
