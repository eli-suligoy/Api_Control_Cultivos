package com.theseus.control_cultivos.dao;


import com.theseus.control_cultivos.entities.Cosechas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ICosechasDao extends JpaRepository <Cosechas, String> {
    @Query ("select c from Cosechas c where c.fecha = ?1")
    public List<Cosechas> findByFecha(Date fecha);
}