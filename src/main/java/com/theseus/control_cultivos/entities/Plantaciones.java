package com.theseus.control_cultivos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="plantaciones")
public class Plantaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String periodo;
    private Date fecha;
    private double porcentajelote;
    private Date fechacierre;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPorcentajelote() {
        return porcentajelote;
    }

    public void setPorcentajelote(double porcentajelote) {
        this.porcentajelote = porcentajelote;
    }

    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
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
