package com.theseus.control_cultivos.services;



import com.theseus.control_cultivos.entities.Compradores;
import com.theseus.control_cultivos.entities.Ventas;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IVentasService {
    List<Ventas> getAll();
    List<Ventas> findByFecha(Date fecha);
    List<Ventas> getAllCompradorFecha(LocalDate dFecha, LocalDate hFecha, Compradores comprador);
    double getTotalVentas(LocalDate dFecha, LocalDate hFecha, Compradores comprador);
    Ventas get(String id);
    void save(Ventas entity);
    String delete(Ventas entity);
}