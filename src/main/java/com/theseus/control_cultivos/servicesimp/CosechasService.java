package com.theseus.control_cultivos.servicesimp;


import com.theseus.control_cultivos.dao.ICosechasDao;
import com.theseus.control_cultivos.entities.Cosechas;
import com.theseus.control_cultivos.services.ICosechasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CosechasService implements ICosechasService {
    @Autowired
    public ICosechasDao entityDao;

    public List<Cosechas> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "fecha"));
    }

    public List<Cosechas> findByFecha(Date fecha) {return entityDao.findByFecha(fecha);
    }

    public Cosechas get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Cosechas entity) {
        entityDao.save(entity);

    }

    @Transactional
    public String delete(Cosechas entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
