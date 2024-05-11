package com.theseus.control_cultivos.dao;


import com.theseus.control_cultivos.entities.Cultivos;
import com.theseus.control_cultivos.entities.Plantaciones;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPlantacionesDao extends JpaRepository<Plantaciones, String> {
    @Query("select c from Plantaciones c where c.periodo like ?1")
    public List<Plantaciones> findByPeriodo(String periodo);

    @Query("select c from Plantaciones c where c.periodo = ?1")
    public List<Plantaciones> getAllPeriodo(String periodo);

    @Query("select c from Plantaciones c where c.fecha between ?1 and ?2 order by c.fecha")
    public List<Plantaciones> getAllFecha(LocalDate dFecha, LocalDate hFecha);

    @Query("select c from Plantaciones c where c.periodo = ?1 and c.cultivo = ?2")
    public List<Plantaciones> getPeriodoCultivo(String periodo, Cultivos cultivo);

}

    //Todas las Plantaciones para un determinado Periodo – Cultivo.