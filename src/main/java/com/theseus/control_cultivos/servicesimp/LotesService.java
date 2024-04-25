package com.theseus.control_cultivos.servicesimp;


import com.theseus.control_cultivos.dao.ILotesDao;
import com.theseus.control_cultivos.entities.Lotes;
import com.theseus.control_cultivos.services.ILotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LotesService implements ILotesService {
    @Autowired
    private ILotesDao entityDao;


    public List<Lotes> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC,"descrip"));
    }

    public List<Lotes> findByDescrip(String name) {
        return entityDao.findByDescrip("%" + name + "%");
    }

    public Lotes get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Lotes entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Lotes entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
