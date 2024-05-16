package com.theseus.control_cultivos.controller;


import com.theseus.control_cultivos.entities.Cosechas;
import com.theseus.control_cultivos.services.ICosechasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api")
public class CosechasController {
    @Autowired
    ICosechasService entityService;

    @GetMapping(path = "/cosechas")
    public List<Cosechas> getAll() {return entityService.getAll();}

    @GetMapping(path = "/cosechas/{id}")
    public Cosechas get(@PathVariable String id) {return entityService.get(id);}

    @GetMapping(path = "/cosechas/search/{expresion}")
    public List<Cosechas> getListCosechas(@PathVariable Date expresion) {return entityService.findByFecha(expresion);}

    @PostMapping(value = "/cosechas", consumes = "application/json", produces = "application/json")
    public Cosechas save(@RequestBody Cosechas entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/cosechas/delete/{id}")
    public String delete(@PathVariable String id) {
        Cosechas entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
