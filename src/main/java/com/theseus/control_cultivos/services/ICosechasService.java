package com.theseus.control_cultivos.services;



import com.theseus.control_cultivos.entities.Cosechas;

import java.util.Date;
import java.util.List;

public interface ICosechasService {

    List<Cosechas> getAll();

    List<Cosechas> findByFecha(Date fecha);

    Cosechas get(String id);

    void save(Cosechas entity);

    String delete(Cosechas entity);
}
