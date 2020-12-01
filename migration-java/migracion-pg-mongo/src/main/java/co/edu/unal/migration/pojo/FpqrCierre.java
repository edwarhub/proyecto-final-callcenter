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
@Table(name = "fpqr_cierre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpqrCierre.findAll", query = "SELECT f FROM FpqrCierre f")
    , @NamedQuery(name = "FpqrCierre.findByIdcierrefpqr", query = "SELECT f FROM FpqrCierre f WHERE f.idcierrefpqr = :idcierrefpqr")
    , @NamedQuery(name = "FpqrCierre.findByRespuestaInterna", query = "SELECT f FROM FpqrCierre f WHERE f.respuestaInterna = :respuestaInterna")
    , @NamedQuery(name = "FpqrCierre.findByRespuestaExterna", query = "SELECT f FROM FpqrCierre f WHERE f.respuestaExterna = :respuestaExterna")
    , @NamedQuery(name = "FpqrCierre.findByCreatedAt", query = "SELECT f FROM FpqrCierre f WHERE f.createdAt = :createdAt")})
public class FpqrCierre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcierrefpqr")
    private Long idcierrefpqr;
    @Basic(optional = false)
    @Column(name = "respuesta_interna")
    private String respuestaInterna;
    @Basic(optional = false)
    @Column(name = "respuesta_externa")
    private String respuestaExterna;
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

    public FpqrCierre() {
    }

    public FpqrCierre(Long idcierrefpqr) {
        this.idcierrefpqr = idcierrefpqr;
    }

    public FpqrCierre(Long idcierrefpqr, String respuestaInterna, String respuestaExterna, Date createdAt) {
        this.idcierrefpqr = idcierrefpqr;
        this.respuestaInterna = respuestaInterna;
        this.respuestaExterna = respuestaExterna;
        this.createdAt = createdAt;
    }

    public Long getIdcierrefpqr() {
        return idcierrefpqr;
    }

    public void setIdcierrefpqr(Long idcierrefpqr) {
        this.idcierrefpqr = idcierrefpqr;
    }

    public String getRespuestaInterna() {
        return respuestaInterna;
    }

    public void setRespuestaInterna(String respuestaInterna) {
        this.respuestaInterna = respuestaInterna;
    }

    public String getRespuestaExterna() {
        return respuestaExterna;
    }

    public void setRespuestaExterna(String respuestaExterna) {
        this.respuestaExterna = respuestaExterna;
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
        hash += (idcierrefpqr != null ? idcierrefpqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpqrCierre)) {
            return false;
        }
        FpqrCierre other = (FpqrCierre) object;
        if ((this.idcierrefpqr == null && other.idcierrefpqr != null) || (this.idcierrefpqr != null && !this.idcierrefpqr.equals(other.idcierrefpqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.FpqrCierre[ idcierrefpqr=" + idcierrefpqr + " ]";
    }
    
}
