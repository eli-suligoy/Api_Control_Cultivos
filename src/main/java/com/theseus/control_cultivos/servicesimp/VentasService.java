package com.theseus.control_cultivos.servicesimp;


import com.theseus.control_cultivos.dao.IVentasDao;
import com.theseus.control_cultivos.entities.Compradores;
import com.theseus.control_cultivos.entities.Ventas;
import com.theseus.control_cultivos.services.IVentasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
public class VentasService implements IVentasService {
    @Autowired
    private IVentasDao entityDao;

    public List<Ventas> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"fecha"));
    }

    public List<Ventas> findByFecha(Date fecha) {
        return entityDao.findByFecha(fecha);
    }

    public List<Ventas> getAllCompradorFecha(LocalDate dFecha, LocalDate hFecha, Compradores comprador) {
        return entityDao.getAllCompradorFecha(dFecha, hFecha, comprador);
    }

    public double getTotalVentas(LocalDate dFecha, LocalDate hFecha, Compradores comprador) {
        return entityDao.getTotalVentas(dFecha, hFecha, comprador);
    }

    public Ventas get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Ventas entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Ventas entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
