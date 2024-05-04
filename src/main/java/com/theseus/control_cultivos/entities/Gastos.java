package com.theseus.control_cultivos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="gastos")
public class Gastos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date fecha;
    private String concepto;
    private double unidades;
    private double precio;

    @JoinColumn(name = "fk_plant", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Plantaciones plantacion;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getUnidades() {
        return unidades;
    }

    public void setUnidades(double unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Plantaciones getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantaciones plantacion) {
        this.plantacion = plantacion;
    }
}
