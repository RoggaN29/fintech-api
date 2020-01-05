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
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
    , @NamedQuery(name = "Oferta.findByFolioOferta", query = "SELECT o FROM Oferta o WHERE o.folioOferta = :folioOferta")
    , @NamedQuery(name = "Oferta.findByFolioPrestamo", query = "SELECT o FROM Oferta o WHERE o.folioPrestamo = :folioPrestamo")
    , @NamedQuery(name = "Oferta.findByRfcOferente", query = "SELECT o FROM Oferta o WHERE o.rfcOferente = :rfcOferente")
    , @NamedQuery(name = "Oferta.findByMontoOferta", query = "SELECT o FROM Oferta o WHERE o.montoOferta = :montoOferta")
    , @NamedQuery(name = "Oferta.findByMontoFinalOferente", query = "SELECT o FROM Oferta o WHERE o.montoFinalOferente = :montoFinalOferente")
    , @NamedQuery(name = "Oferta.findByPorcentajeParticipacionOferente", query = "SELECT o FROM Oferta o WHERE o.porcentajeParticipacionOferente = :porcentajeParticipacionOferente")
    , @NamedQuery(name = "Oferta.findByEstadoOferta", query = "SELECT o FROM Oferta o WHERE o.estadoOferta = :estadoOferta")
    , @NamedQuery(name = "Oferta.findByIndiceOferta", query = "SELECT o FROM Oferta o WHERE o.indiceOferta = :indiceOferta")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer folioOferta;
    @Basic(optional = false)
    @NotNull
    private int folioPrestamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    private String rfcOferente;
    @Basic(optional = false)
    @NotNull
    private double montoOferta;
    @Basic(optional = false)
    @NotNull
    private double montoFinalOferente;
    @Basic(optional = false)
    @NotNull
    private double porcentajeParticipacionOferente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String estadoOferta;
    private Integer indiceOferta;

    public Oferta() {
    }

    public Oferta(Integer folioOferta) {
        this.folioOferta = folioOferta;
    }

    public Oferta(Integer folioOferta, int folioPrestamo, String rfcOferente, double montoOferta, double montoFinalOferente, double porcentajeParticipacionOferente, String estadoOferta) {
        this.folioOferta = folioOferta;
        this.folioPrestamo = folioPrestamo;
        this.rfcOferente = rfcOferente;
        this.montoOferta = montoOferta;
        this.montoFinalOferente = montoFinalOferente;
        this.porcentajeParticipacionOferente = porcentajeParticipacionOferente;
        this.estadoOferta = estadoOferta;
    }

    public Integer getFolioOferta() {
        return folioOferta;
    }

    public void setFolioOferta(Integer folioOferta) {
        this.folioOferta = folioOferta;
    }

    public int getFolioPrestamo() {
        return folioPrestamo;
    }

    public void setFolioPrestamo(int folioPrestamo) {
        this.folioPrestamo = folioPrestamo;
    }

    public String getRfcOferente() {
        return rfcOferente;
    }

    public void setRfcOferente(String rfcOferente) {
        this.rfcOferente = rfcOferente;
    }

    public double getMontoOferta() {
        return montoOferta;
    }

    public void setMontoOferta(double montoOferta) {
        this.montoOferta = montoOferta;
    }

    public double getMontoFinalOferente() {
        return montoFinalOferente;
    }

    public void setMontoFinalOferente(double montoFinalOferente) {
        this.montoFinalOferente = montoFinalOferente;
    }

    public double getPorcentajeParticipacionOferente() {
        return porcentajeParticipacionOferente;
    }

    public void setPorcentajeParticipacionOferente(double porcentajeParticipacionOferente) {
        this.porcentajeParticipacionOferente = porcentajeParticipacionOferente;
    }

    public String getEstadoOferta() {
        return estadoOferta;
    }

    public void setEstadoOferta(String estadoOferta) {
        this.estadoOferta = estadoOferta;
    }

    public Integer getIndiceOferta() {
        return indiceOferta;
    }

    public void setIndiceOferta(Integer indiceOferta) {
        this.indiceOferta = indiceOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folioOferta != null ? folioOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.folioOferta == null && other.folioOferta != null) || (this.folioOferta != null && !this.folioOferta.equals(other.folioOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgtic.diplomado.domain.Oferta[ folioOferta=" + folioOferta + " ]";
    }
    
}
