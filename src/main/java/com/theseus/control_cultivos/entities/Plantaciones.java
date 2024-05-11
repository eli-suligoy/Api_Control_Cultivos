package com.theseus.control_cultivos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="plantaciones")
public class Plantaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String periodo;
    private LocalDate fecha;
    private double porcentajelote;
    private LocalDate fechacierre;

    @JoinColumn(name = "fk_cultivo", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Cultivos cultivo;

    @JoinColumn(name = "fk_lote", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Lotes lote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPorcentajelote() {
        return porcentajelote;
    }

    public void setPorcentajelote(double porcentajelote) {
        this.porcentajelote = porcentajelote;
    }

    public LocalDate getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(LocalDate fechacierre) {
        this.fechacierre = fechacierre;
    }

    public Cultivos getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivos cultivo) {
        this.cultivo = cultivo;
    }

    public Lotes getLote() {
        return lote;
    }

    public void setLote(Lotes lote) {
        this.lote = lote;
    }
}
