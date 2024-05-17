package com.theseus.control_cultivos.controller;


import com.theseus.control_cultivos.entities.Compradores;
import com.theseus.control_cultivos.entities.Cultivos;
import com.theseus.control_cultivos.entities.Plantaciones;
import com.theseus.control_cultivos.entities.Ventas;
import com.theseus.control_cultivos.services.ICompradoresService;
import com.theseus.control_cultivos.services.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api")
public class VentasController {
    @Autowired
    IVentasService entityService;

    @Autowired
    ICompradoresService compradoresService;

    @GetMapping(path = "/ventas")
    public List<Ventas> getAll() {return entityService.getAll();}

    @GetMapping(path = "/ventas/{id}")
    public Ventas get(@PathVariable String id) {return entityService.get(id);}

    @GetMapping(path = "/ventas/search/{expresion}")
    public List<Ventas> getListGastos(@PathVariable Date expresion) {return entityService.findByFecha(expresion);}

    @PostMapping(value = "/ventas", consumes = "application/json", produces = "application/json")
    public Ventas save(@RequestBody Ventas entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping (path = "/ventas/delete/{id}")
    public String delete(@PathVariable String id) {
        Ventas entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }


    //=========================Consultas===============================

    @GetMapping(path = "/ventas/getcompradorfecha/{dfecha}/{hfecha}/{comprador}")
    public List<Ventas> getListCompradorFecha(@PathVariable String dfecha, @PathVariable String hfecha, @PathVariable Integer comprador) {
        LocalDate desde = LocalDate.parse(dfecha);
        LocalDate hasta = LocalDate.parse(hfecha);
        Compradores c = compradoresService.get(comprador);
        return entityService.getAllCompradorFecha(desde,hasta,c);
    }

    //El Total de Ventas Realizado por un Comprador entre dos Fechas.


}