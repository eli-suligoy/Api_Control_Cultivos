package com.theseus.control_cultivos.dao;


import com.theseus.control_cultivos.entities.Compradores;
import com.theseus.control_cultivos.entities.Plantaciones;
import com.theseus.control_cultivos.entities.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface IVentasDao extends JpaRepository <Ventas, String> {
    @Query("select c from Ventas c where c.fecha = ?1")
    public List<Ventas> findByFecha(Date fecha);


    @Query("select c from Ventas c where c.fecha between ?1 and ?2 and c.comprador = ?3 order by c.fecha")
    public List<Ventas> getAllCompradorFecha(LocalDate dFecha, LocalDate hFecha, Compradores comprador);
}

//Todas las Ventas Realizadas por un Determinado Comprador entre dos
//Fechas.