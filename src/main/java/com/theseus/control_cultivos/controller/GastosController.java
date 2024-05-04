package com.theseus.control_cultivos.controller;


import com.theseus.control_cultivos.entities.Gastos;
import com.theseus.control_cultivos.services.IGastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GastosController {
    @Autowired
    IGastosService entityService;

    @GetMapping(path = "/gastos")
    public List<Gastos> getAll() {return entityService.getAll();}

    @GetMapping(path = "/gastos/{id}")
    public Gastos get(@PathVariable String id) {return entityService.get(id);}

    @GetMapping(path = "/gastos/search/{expresion}")
    public List<Gastos> getListGastos(@PathVariable Date expresion) {return entityService.findByFecha(expresion);}

    @PostMapping(value = "/gastos", consumes = "application/json", produces = "application/json")
    public Gastos save(@RequestBody Gastos entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/gastos/delete/{id}")
    public String delete(@PathVariable String id) {
        Gastos entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}