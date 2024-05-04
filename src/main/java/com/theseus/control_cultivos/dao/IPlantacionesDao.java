package com.theseus.control_cultivos.dao;


import com.theseus.control_cultivos.entities.Plantaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlantacionesDao extends JpaRepository<Plantaciones, String> {
    @Query("select c from Plantaciones c where c.periodo like ?1")
    public List<Plantaciones> findByPeriodo(String periodo);
}
