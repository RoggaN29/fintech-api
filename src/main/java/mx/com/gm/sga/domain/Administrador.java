/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

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
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByRfcAdministrador", query = "SELECT a FROM Administrador a WHERE a.rfcAdministrador = :rfcAdministrador")
    , @NamedQuery(name = "Administrador.findByPaginaWeb", query = "SELECT a FROM Administrador a WHERE a.paginaWeb = :paginaWeb")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    private String rfcAdministrador;
    @Size(max = 100)
    private String paginaWeb;

    public Administrador() {
    }

    public Administrador(String rfcAdministrador) {
        this.rfcAdministrador = rfcAdministrador;
    }

    public String getRfcAdministrador() {
        return rfcAdministrador;
    }

    public void setRfcAdministrador(String rfcAdministrador) {
        this.rfcAdministrador = rfcAdministrador;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfcAdministrador != null ? rfcAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.rfcAdministrador == null && other.rfcAdministrador != null) || (this.rfcAdministrador != null && !this.rfcAdministrador.equals(other.rfcAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Administrador[ rfcAdministrador=" + rfcAdministrador + " ]";
    }
    
}
