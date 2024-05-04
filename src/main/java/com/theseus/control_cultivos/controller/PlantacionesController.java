package com.theseus.control_cultivos.controller;

import com.theseus.control_cultivos.entities.Plantaciones;
import com.theseus.control_cultivos.services.IPlantacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlantacionesController {
    @Autowired
    IPlantacionesService entityService;

    @GetMapping(path = "/plantaciones")
    public List<Plantaciones> getAll() {return entityService.getAll();}

    @GetMapping(path = "/plantaciones/{id}")
    public Plantaciones get(@PathVariable String id) {return entityService.get(id);}

    @GetMapping(path = "/plantaciones/search/{expresion}")
    public List<Plantaciones> getListPlantaciones(@PathVariable String expresion) {return entityService.findByPeriodo(expresion);}

    @PostMapping(value = "/plantaciones", consumes = "application/json", produces = "application/json")
    public Plantaciones save(@RequestBody Plantaciones entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/plantaciones/delete/{id}")
    public String delete(@PathVariable String id) {
        Plantaciones entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}