/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgtic.diplomado.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mario
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findByFolioPrestamo", query = "SELECT p FROM Prestamo p WHERE p.folioPrestamo = :folioPrestamo")
    , @NamedQuery(name = "Prestamo.findByRfcDemandante", query = "SELECT p FROM Prestamo p WHERE p.rfcDemandante = :rfcDemandante")
    , @NamedQuery(name = "Prestamo.findByMontoSolicitadoDemandante", query = "SELECT p FROM Prestamo p WHERE p.montoSolicitadoDemandante = :montoSolicitadoDemandante")
    , @NamedQuery(name = "Prestamo.findByFechaInicio", query = "SELECT p FROM Prestamo p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Prestamo.findByFechaFin", query = "SELECT p FROM Prestamo p WHERE p.fechaFin = :fechaFin")
    , @NamedQuery(name = "Prestamo.findByPlazo", query = "SELECT p FROM Prestamo p WHERE p.plazo = :plazo")
    , @NamedQuery(name = "Prestamo.findByBolsaAcumulada", query = "SELECT p FROM Prestamo p WHERE p.bolsaAcumulada = :bolsaAcumulada")
    , @NamedQuery(name = "Prestamo.findByPorcentajeLlenadoBolsa", query = "SELECT p FROM Prestamo p WHERE p.porcentajeLlenadoBolsa = :porcentajeLlenadoBolsa")
    , @NamedQuery(name = "Prestamo.findByTasaPonderadaTotalDemandante", query = "SELECT p FROM Prestamo p WHERE p.tasaPonderadaTotalDemandante = :tasaPonderadaTotalDemandante")
    , @NamedQuery(name = "Prestamo.findByEstadoPrestamo", query = "SELECT p FROM Prestamo p WHERE p.estadoPrestamo = :estadoPrestamo")
    , @NamedQuery(name = "Prestamo.findByTiempoEsperaDemandante", query = "SELECT p FROM Prestamo p WHERE p.tiempoEsperaDemandante = :tiempoEsperaDemandante")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer folioPrestamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    private String rfcDemandante;
    @Basic(optional = false)
    @NotNull
    private double montoSolicitadoDemandante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String fechaFin;
    @Basic(optional = false)
    @NotNull
    private int plazo;
    @Basic(optional = false)
    @NotNull
    private double bolsaAcumulada;
    @Basic(optional = false)
    @NotNull
    private double porcentajeLlenadoBolsa;
    @Basic(optional = false)
    @NotNull
    private double tasaPonderadaTotalDemandante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String estadoPrestamo;
    @Basic(optional = false)
    @NotNull
    private int tiempoEsperaDemandante;

    public Prestamo() {
    }

    public Prestamo(Integer folioPrestamo) {
        this.folioPrestamo = folioPrestamo;
    }

    public Prestamo(Integer folioPrestamo, String rfcDemandante, double montoSolicitadoDemandante, String fechaInicio, String fechaFin, int plazo, double bolsaAcumulada, double porcentajeLlenadoBolsa, double tasaPonderadaTotalDemandante, String estadoPrestamo, int tiempoEsperaDemandante) {
        this.folioPrestamo = folioPrestamo;
        this.rfcDemandante = rfcDemandante;
        this.montoSolicitadoDemandante = montoSolicitadoDemandante;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.plazo = plazo;
        this.bolsaAcumulada = bolsaAcumulada;
        this.porcentajeLlenadoBolsa = porcentajeLlenadoBolsa;
        this.tasaPonderadaTotalDemandante = tasaPonderadaTotalDemandante;
        this.estadoPrestamo = estadoPrestamo;
        this.tiempoEsperaDemandante = tiempoEsperaDemandante;
    }

    public Integer getFolioPrestamo() {
        return folioPrestamo;
    }

    public void setFolioPrestamo(Integer folioPrestamo) {
        this.folioPrestamo = folioPrestamo;
    }

    public String getRfcDemandante() {
        return rfcDemandante;
    }

    public void setRfcDemandante(String rfcDemandante) {
        this.rfcDemandante = rfcDemandante;
    }

    public double getMontoSolicitadoDemandante() {
        return montoSolicitadoDemandante;
    }

    public void setMontoSolicitadoDemandante(double montoSolicitadoDemandante) {
        this.montoSolicitadoDemandante = montoSolicitadoDemandante;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getBolsaAcumulada() {
        return bolsaAcumulada;
    }

    public void setBolsaAcumulada(double bolsaAcumulada) {
        this.bolsaAcumulada = bolsaAcumulada;
    }

    public double getPorcentajeLlenadoBolsa() {
        return porcentajeLlenadoBolsa;
    }

    public void setPorcentajeLlenadoBolsa(double porcentajeLlenadoBolsa) {
        this.porcentajeLlenadoBolsa = porcentajeLlenadoBolsa;
    }

    public double getTasaPonderadaTotalDemandante() {
        return tasaPonderadaTotalDemandante;
    }

    public void setTasaPonderadaTotalDemandante(double tasaPonderadaTotalDemandante) {
        this.tasaPonderadaTotalDemandante = tasaPonderadaTotalDemandante;
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public int getTiempoEsperaDemandante() {
        return tiempoEsperaDemandante;
    }

    public void setTiempoEsperaDemandante(int tiempoEsperaDemandante) {
        this.tiempoEsperaDemandante = tiempoEsperaDemandante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folioPrestamo != null ? folioPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.folioPrestamo == null && other.folioPrestamo != null) || (this.folioPrestamo != null && !this.folioPrestamo.equals(other.folioPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgtic.diplomado.domain.Prestamo[ folioPrestamo=" + folioPrestamo + " ]";
    }
    
}
