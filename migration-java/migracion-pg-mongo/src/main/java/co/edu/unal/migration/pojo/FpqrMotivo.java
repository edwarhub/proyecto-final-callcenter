/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "fpqr_motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpqrMotivo.findAll", query = "SELECT f FROM FpqrMotivo f")
    , @NamedQuery(name = "FpqrMotivo.findByIdmotivo", query = "SELECT f FROM FpqrMotivo f WHERE f.idmotivo = :idmotivo")
    , @NamedQuery(name = "FpqrMotivo.findByMotivo", query = "SELECT f FROM FpqrMotivo f WHERE f.motivo = :motivo")})
public class FpqrMotivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivo")
    private Integer idmotivo;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmotivo")
    private Collection<Fpqr> fpqrCollection;

    public FpqrMotivo() {
    }

    public FpqrMotivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public FpqrMotivo(Integer idmotivo, String motivo) {
        this.idmotivo = idmotivo;
        this.motivo = motivo;
    }

    public Integer getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @XmlTransient
    public Collection<Fpqr> getFpqrCollection() {
        return fpqrCollection;
    }

    public void setFpqrCollection(Collection<Fpqr> fpqrCollection) {
        this.fpqrCollection = fpqrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotivo != null ? idmotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpqrMotivo)) {
            return false;
        }
        FpqrMotivo other = (FpqrMotivo) object;
        if ((this.idmotivo == null && other.idmotivo != null) || (this.idmotivo != null && !this.idmotivo.equals(other.idmotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.FpqrMotivo[ idmotivo=" + idmotivo + " ]";
    }
    
}
