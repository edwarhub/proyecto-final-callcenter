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
@Table(name = "fpqr_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpqrTipo.findAll", query = "SELECT f FROM FpqrTipo f")
    , @NamedQuery(name = "FpqrTipo.findByIdtipo", query = "SELECT f FROM FpqrTipo f WHERE f.idtipo = :idtipo")
    , @NamedQuery(name = "FpqrTipo.findByNombre", query = "SELECT f FROM FpqrTipo f WHERE f.nombre = :nombre")})
public class FpqrTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo")
    private Integer idtipo;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipo")
    private Collection<Fpqr> fpqrCollection;

    public FpqrTipo() {
    }

    public FpqrTipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpqrTipo)) {
            return false;
        }
        FpqrTipo other = (FpqrTipo) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.FpqrTipo[ idtipo=" + idtipo + " ]";
    }
    
}
