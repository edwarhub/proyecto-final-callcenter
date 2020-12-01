/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "fpqr_direccionamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpqrDireccionamiento.findAll", query = "SELECT f FROM FpqrDireccionamiento f")
    , @NamedQuery(name = "FpqrDireccionamiento.findByIddireccionamiento", query = "SELECT f FROM FpqrDireccionamiento f WHERE f.iddireccionamiento = :iddireccionamiento")
    , @NamedQuery(name = "FpqrDireccionamiento.findByCreatedAt", query = "SELECT f FROM FpqrDireccionamiento f WHERE f.createdAt = :createdAt")
    , @NamedQuery(name = "FpqrDireccionamiento.findByObservaciones", query = "SELECT f FROM FpqrDireccionamiento f WHERE f.observaciones = :observaciones")})
public class FpqrDireccionamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddireccionamiento")
    private Long iddireccionamiento;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idfpqr", referencedColumnName = "idfpqr")
    @ManyToOne(optional = false)
    private Fpqr idfpqr;
    @JoinColumn(name = "idpersona_created", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaCreated;
    @JoinColumn(name = "idpersona_direccionada", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaDireccionada;

    public FpqrDireccionamiento() {
    }

    public FpqrDireccionamiento(Long iddireccionamiento) {
        this.iddireccionamiento = iddireccionamiento;
    }

    public FpqrDireccionamiento(Long iddireccionamiento, Date createdAt) {
        this.iddireccionamiento = iddireccionamiento;
        this.createdAt = createdAt;
    }

    public Long getIddireccionamiento() {
        return iddireccionamiento;
    }

    public void setIddireccionamiento(Long iddireccionamiento) {
        this.iddireccionamiento = iddireccionamiento;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Fpqr getIdfpqr() {
        return idfpqr;
    }

    public void setIdfpqr(Fpqr idfpqr) {
        this.idfpqr = idfpqr;
    }

    public Persona getIdpersonaCreated() {
        return idpersonaCreated;
    }

    public void setIdpersonaCreated(Persona idpersonaCreated) {
        this.idpersonaCreated = idpersonaCreated;
    }

    public Persona getIdpersonaDireccionada() {
        return idpersonaDireccionada;
    }

    public void setIdpersonaDireccionada(Persona idpersonaDireccionada) {
        this.idpersonaDireccionada = idpersonaDireccionada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddireccionamiento != null ? iddireccionamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpqrDireccionamiento)) {
            return false;
        }
        FpqrDireccionamiento other = (FpqrDireccionamiento) object;
        if ((this.iddireccionamiento == null && other.iddireccionamiento != null) || (this.iddireccionamiento != null && !this.iddireccionamiento.equals(other.iddireccionamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.FpqrDireccionamiento[ iddireccionamiento=" + iddireccionamiento + " ]";
    }
    
}
