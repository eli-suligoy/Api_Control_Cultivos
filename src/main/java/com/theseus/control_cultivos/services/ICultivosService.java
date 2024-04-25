package com.theseus.control_cultivos.services;


import com.theseus.control_cultivos.entities.Cultivos;

import java.util.List;

public interface ICultivosService {
    List<Cultivos> getAll();
    List<Cultivos> findByDescrip(String descrip);
    Cultivos get(Integer id);
    void save(Cultivos entity);
    String delete(Cultivos entity);
}
