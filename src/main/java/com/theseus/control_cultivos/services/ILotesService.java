package com.theseus.control_cultivos.services;


import com.theseus.control_cultivos.entities.Lotes;

import java.util.List;

public interface ILotesService {
    List<Lotes> getAll();
    List<Lotes> findByDescrip(String name);
    Lotes get(Integer id);
    void save(Lotes entity);
    String delete(Lotes entity);
}
