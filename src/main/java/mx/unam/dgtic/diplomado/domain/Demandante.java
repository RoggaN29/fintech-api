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
    @NamedQuery(name = "Demandante.findAll", query = "SELECT d FROM Demandante d")
    , @NamedQuery(name = "Demandante.findByRfcRepresentante", query = "SELECT d FROM Demandante d WHERE d.rfcRepresentante = :rfcRepresentante")
    , @NamedQuery(name = "Demandante.findByRazonSocial", query = "SELECT d FROM Demandante d WHERE d.razonSocial = :razonSocial")
    , @NamedQuery(name = "Demandante.findByDireccionFiscal", query = "SELECT d FROM Demandante d WHERE d.direccionFiscal = :direccionFiscal")
    , @NamedQuery(name = "Demandante.findByClabe", query = "SELECT d FROM Demandante d WHERE d.clabe = :clabe")
    , @NamedQuery(name = "Demandante.findByPaginaWeb", query = "SELECT d FROM Demandante d WHERE d.paginaWeb = :paginaWeb")
    , @NamedQuery(name = "Demandante.findByCategoria", query = "SELECT d FROM Demandante d WHERE d.categoria = :categoria")
    , @NamedQuery(name = "Demandante.findByBalance", query = "SELECT d FROM Demandante d WHERE d.balance = :balance")})
public class Demandante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    private String rfcRepresentante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    private String direccionFiscal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    private String clabe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String paginaWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    private String categoria;
    @Basic(optional = false)
    @NotNull
    private double balance;

    public Demandante() {
    }

    public Demandante(String rfcRepresentante) {
        this.rfcRepresentante = rfcRepresentante;
    }

    public Demandante(String rfcRepresentante, String razonSocial, String direccionFiscal, String clabe, String paginaWeb, String categoria, double balance) {
        this.rfcRepresentante = rfcRepresentante;
        this.razonSocial = razonSocial;
        this.direccionFiscal = direccionFiscal;
        this.clabe = clabe;
        this.paginaWeb = paginaWeb;
        this.categoria = categoria;
        this.balance = balance;
    }

    public String getRfcRepresentante() {
        return rfcRepresentante;
    }

    public void setRfcRepresentante(String rfcRepresentante) {
        this.rfcRepresentante = rfcRepresentante;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfcRepresentante != null ? rfcRepresentante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demandante)) {
            return false;
        }
        Demandante other = (Demandante) object;
        if ((this.rfcRepresentante == null && other.rfcRepresentante != null) || (this.rfcRepresentante != null && !this.rfcRepresentante.equals(other.rfcRepresentante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgtic.diplomado.domain.Demandante[ rfcRepresentante=" + rfcRepresentante + " ]";
    }
    
}
