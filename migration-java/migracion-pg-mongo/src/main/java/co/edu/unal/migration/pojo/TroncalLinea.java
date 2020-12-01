/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "troncal_linea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TroncalLinea.findAll", query = "SELECT t FROM TroncalLinea t")
    , @NamedQuery(name = "TroncalLinea.findByIdlinea", query = "SELECT t FROM TroncalLinea t WHERE t.idlinea = :idlinea")
    , @NamedQuery(name = "TroncalLinea.findByNumero", query = "SELECT t FROM TroncalLinea t WHERE t.numero = :numero")})
public class TroncalLinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlinea")
    private Integer idlinea;
    @Basic(optional = false)
    @Column(name = "numero")
    private long numero;
    @JoinColumn(name = "idextension", referencedColumnName = "idextension")
    @ManyToOne(optional = false)
    private Extension idextension;
    @JoinColumn(name = "idtroncal", referencedColumnName = "idtroncal")
    @ManyToOne(optional = false)
    private Troncal idtroncal;

    public TroncalLinea() {
    }

    public TroncalLinea(Integer idlinea) {
        this.idlinea = idlinea;
    }

    public TroncalLinea(Integer idlinea, long numero) {
        this.idlinea = idlinea;
        this.numero = numero;
    }

    public Integer getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(Integer idlinea) {
        this.idlinea = idlinea;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Extension getIdextension() {
        return idextension;
    }

    public void setIdextension(Extension idextension) {
        this.idextension = idextension;
    }

    public Troncal getIdtroncal() {
        return idtroncal;
    }

    public void setIdtroncal(Troncal idtroncal) {
        this.idtroncal = idtroncal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlinea != null ? idlinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TroncalLinea)) {
            return false;
        }
        TroncalLinea other = (TroncalLinea) object;
        if ((this.idlinea == null && other.idlinea != null) || (this.idlinea != null && !this.idlinea.equals(other.idlinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.TroncalLinea[ idlinea=" + idlinea + " ]";
    }
    
}
