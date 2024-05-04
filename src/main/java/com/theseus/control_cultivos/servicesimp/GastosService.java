package com.theseus.control_cultivos.servicesimp;


import com.theseus.control_cultivos.dao.IGastosDao;
import com.theseus.control_cultivos.entities.Gastos;
import com.theseus.control_cultivos.services.IGastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GastosService implements IGastosService {
    @Autowired
    private IGastosDao entityDao;

    public List<Gastos> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"fecha"));
    }

    public List<Gastos> findByFecha(Date fecha) {
        return entityDao.findByFecha(fecha);
    }

    public Gastos get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Gastos entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Gastos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
