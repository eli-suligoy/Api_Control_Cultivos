package com.theseus.control_cultivos.servicesimp;

import com.theseus.control_cultivos.dao.ICompradoresDao;
import com.theseus.control_cultivos.entities.Compradores;
import com.theseus.control_cultivos.services.ICompradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompradoresService implements ICompradoresService {
    @Autowired
    private ICompradoresDao entityDao;

    public List<Compradores> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"nombre"));
    }

    public List<Compradores> findByNombre(String nombre) {
        return entityDao.findByNombre("%" + nombre + "%");
    }

    public Compradores get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Compradores entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Compradores entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
