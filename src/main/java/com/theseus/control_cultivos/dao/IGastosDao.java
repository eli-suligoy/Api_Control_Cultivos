package com.theseus.control_cultivos.dao;


import com.theseus.control_cultivos.entities.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface IGastosDao extends JpaRepository<Gastos, String> {
    @Query("select c from Gastos c where c.fecha = ?1")
    public List<Gastos> findByFecha(Date fecha);
}
