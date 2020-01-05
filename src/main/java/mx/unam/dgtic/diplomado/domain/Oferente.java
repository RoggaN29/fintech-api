
package mx.unam.dgtic.diplomado.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = "Oferente.findAll", query = "SELECT o FROM Oferente o")
    , @NamedQuery(name = "Oferente.findByRfcOferente", query = "SELECT o FROM Oferente o WHERE o.rfcOferente = :rfcOferente")
    , @NamedQuery(name = "Oferente.findByEdadOferente", query = "SELECT o FROM Oferente o WHERE o.edadOferente = :edadOferente")
    , @NamedQuery(name = "Oferente.findBySexoOferente", query = "SELECT o FROM Oferente o WHERE o.sexoOferente = :sexoOferente")
    , @NamedQuery(name = "Oferente.findByClabeOferente", query = "SELECT o FROM Oferente o WHERE o.clabeOferente = :clabeOferente")
    , @NamedQuery(name = "Oferente.findByBalanceOferente", query = "SELECT o FROM Oferente o WHERE o.balanceOferente = :balanceOferente")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Oferente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    private String rfcOferente;
    @Basic(optional = false)
    @NotNull
    private int edadOferente;
    @Basic(optional = false)
    @NotNull
    private Character sexoOferente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    private String clabeOferente;
    @Basic(optional = false)
    @NotNull
    private double balanceOferente;

    public Oferente() {
    }

    public Oferente(String rfcOferente) {
        this.rfcOferente = rfcOferente;
    }

    public Oferente(String rfcOferente, int edadOferente, Character sexoOferente, String clabeOferente, double balanceOferente) {
        this.rfcOferente = rfcOferente;
        this.edadOferente = edadOferente;
        this.sexoOferente = sexoOferente;
        this.clabeOferente = clabeOferente;
        this.balanceOferente = balanceOferente;
    }

    public String getRfcOferente() {
        return rfcOferente;
    }

    public void setRfcOferente(String rfcOferente) {
        this.rfcOferente = rfcOferente;
    }

    public int getEdadOferente() {
        return edadOferente;
    }

    public void setEdadOferente(int edadOferente) {
        this.edadOferente = edadOferente;
    }

    public Character getSexoOferente() {
        return sexoOferente;
    }

    public void setSexoOferente(Character sexoOferente) {
        this.sexoOferente = sexoOferente;
    }

    public String getClabeOferente() {
        return clabeOferente;
    }

    public void setClabeOferente(String clabeOferente) {
        this.clabeOferente = clabeOferente;
    }

    public double getBalanceOferente() {
        return balanceOferente;
    }

    public void setBalanceOferente(double balanceOferente) {
        this.balanceOferente = balanceOferente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfcOferente != null ? rfcOferente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferente)) {
            return false;
        }
        Oferente other = (Oferente) object;
        if ((this.rfcOferente == null && other.rfcOferente != null) || (this.rfcOferente != null && !this.rfcOferente.equals(other.rfcOferente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgtic.diplomado.domain.Oferente[ rfcOferente=" + rfcOferente + " ]";
    }
    
}
