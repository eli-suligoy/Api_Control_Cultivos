package com.theseus.control_cultivos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate fecha;
    private double cantvendida;
    private double precio;

    @JoinColumn(name = "fk_plantaciones", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Plantaciones plantacion;

    @JoinColumn(name = "fk_compradores", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Compradores comprador;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCantvendida() {
        return cantvendida;
    }

    public void setCantvendida(double cantvendida) {
        this.cantvendida = cantvendida;
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

    public Compradores getComprador() {
        return comprador;
    }

    public void setComprador(Compradores comprador) {
        this.comprador = comprador;
    }
}