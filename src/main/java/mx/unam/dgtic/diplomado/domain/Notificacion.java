/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgtic.diplomado.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n")
    , @NamedQuery(name = "Notificacion.findByIdentificadorMensaje", query = "SELECT n FROM Notificacion n WHERE n.identificadorMensaje = :identificadorMensaje")
    , @NamedQuery(name = "Notificacion.findByTipoEnvio", query = "SELECT n FROM Notificacion n WHERE n.tipoEnvio = :tipoEnvio")
    , @NamedQuery(name = "Notificacion.findByRfcRemitente", query = "SELECT n FROM Notificacion n WHERE n.rfcRemitente = :rfcRemitente")
    , @NamedQuery(name = "Notificacion.findByRfcDestinatario", query = "SELECT n FROM Notificacion n WHERE n.rfcDestinatario = :rfcDestinatario")
    , @NamedQuery(name = "Notificacion.findByMensaje", query = "SELECT n FROM Notificacion n WHERE n.mensaje = :mensaje")})
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer identificadorMensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    private String tipoEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String rfcRemitente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String rfcDestinatario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    private String mensaje;

    public Notificacion() {
    }

    public Notificacion(Integer identificadorMensaje) {
        this.identificadorMensaje = identificadorMensaje;
    }

    public Notificacion(Integer identificadorMensaje, String tipoEnvio, String rfcRemitente, String rfcDestinatario, String mensaje) {
        this.identificadorMensaje = identificadorMensaje;
        this.tipoEnvio = tipoEnvio;
        this.rfcRemitente = rfcRemitente;
        this.rfcDestinatario = rfcDestinatario;
        this.mensaje = mensaje;
    }

    public Integer getIdentificadorMensaje() {
        return identificadorMensaje;
    }

    public void setIdentificadorMensaje(Integer identificadorMensaje) {
        this.identificadorMensaje = identificadorMensaje;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getRfcRemitente() {
        return rfcRemitente;
    }

    public void setRfcRemitente(String rfcRemitente) {
        this.rfcRemitente = rfcRemitente;
    }

    public String getRfcDestinatario() {
        return rfcDestinatario;
    }

    public void setRfcDestinatario(String rfcDestinatario) {
        this.rfcDestinatario = rfcDestinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificadorMensaje != null ? identificadorMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.identificadorMensaje == null && other.identificadorMensaje != null) || (this.identificadorMensaje != null && !this.identificadorMensaje.equals(other.identificadorMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgtic.diplomado.domain.Notificacion[ identificadorMensaje=" + identificadorMensaje + " ]";
    }
    
}
