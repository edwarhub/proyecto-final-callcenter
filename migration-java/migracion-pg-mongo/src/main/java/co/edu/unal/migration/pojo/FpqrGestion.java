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
@Table(name = "fpqr_gestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpqrGestion.findAll", query = "SELECT f FROM FpqrGestion f")
    , @NamedQuery(name = "FpqrGestion.findByIdgestionfpqr", query = "SELECT f FROM FpqrGestion f WHERE f.idgestionfpqr = :idgestionfpqr")
    , @NamedQuery(name = "FpqrGestion.findByGestion", query = "SELECT f FROM FpqrGestion f WHERE f.gestion = :gestion")
    , @NamedQuery(name = "FpqrGestion.findByCreatedAt", query = "SELECT f FROM FpqrGestion f WHERE f.createdAt = :createdAt")})
public class FpqrGestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgestionfpqr")
    private Long idgestionfpqr;
    @Basic(optional = false)
    @Column(name = "gestion")
    private String gestion;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "idfpqr", referencedColumnName = "idfpqr")
    @ManyToOne(optional = false)
    private Fpqr idfpqr;
    @JoinColumn(name = "idpersona_created", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaCreated;

    public FpqrGestion() {
    }

    public FpqrGestion(Long idgestionfpqr) {
        this.idgestionfpqr = idgestionfpqr;
    }

    public FpqrGestion(Long idgestionfpqr, String gestion, Date createdAt) {
        this.idgestionfpqr = idgestionfpqr;
        this.gestion = gestion;
        this.createdAt = createdAt;
    }

    public Long getIdgestionfpqr() {
        return idgestionfpqr;
    }

    public void setIdgestionfpqr(Long idgestionfpqr) {
        this.idgestionfpqr = idgestionfpqr;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgestionfpqr != null ? idgestionfpqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpqrGestion)) {
            return false;
        }
        FpqrGestion other = (FpqrGestion) object;
        if ((this.idgestionfpqr == null && other.idgestionfpqr != null) || (this.idgestionfpqr != null && !this.idgestionfpqr.equals(other.idgestionfpqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.FpqrGestion[ idgestionfpqr=" + idgestionfpqr + " ]";
    }
    
}
