package com.theseus.control_cultivos.servicesimp;

import com.theseus.control_cultivos.dao.IPlantacionesDao;
import com.theseus.control_cultivos.entities.Plantaciones;
import com.theseus.control_cultivos.services.IPlantacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlantacionesService implements IPlantacionesService {
    @Autowired
    private IPlantacionesDao entityDao;

    public List<Plantaciones> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"periodo"));
    }


    public List<Plantaciones> findByPeriodo(String periodo) {
        return entityDao.findByPeriodo("%" + periodo + "%");
    }


    public Plantaciones get(String id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Plantaciones entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Plantaciones entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
