package com.theseus.control_cultivos.services;

import com.theseus.control_cultivos.entities.Compradores;

import java.util.List;

public interface ICompradoresService {
    List<Compradores> getAll();
    List<Compradores> findByNombre(String nombre);
    Compradores get(Integer id);
    void save(Compradores entity);
    String delete(Compradores entity);
}
