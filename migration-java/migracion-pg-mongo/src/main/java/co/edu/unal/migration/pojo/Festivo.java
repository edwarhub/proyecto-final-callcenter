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
@Table(name = "festivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Festivo.findAll", query = "SELECT f FROM Festivo f")
    , @NamedQuery(name = "Festivo.findByIdfestivo", query = "SELECT f FROM Festivo f WHERE f.idfestivo = :idfestivo")
    , @NamedQuery(name = "Festivo.findByFecha", query = "SELECT f FROM Festivo f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Festivo.findByObservaciones", query = "SELECT f FROM Festivo f WHERE f.observaciones = :observaciones")
    , @NamedQuery(name = "Festivo.findByUpdatedAt", query = "SELECT f FROM Festivo f WHERE f.updatedAt = :updatedAt")})
public class Festivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfestivo")
    private Integer idfestivo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;

    public Festivo() {
    }

    public Festivo(Integer idfestivo) {
        this.idfestivo = idfestivo;
    }

    public Festivo(Integer idfestivo, Date fecha, Date updatedAt) {
        this.idfestivo = idfestivo;
        this.fecha = fecha;
        this.updatedAt = updatedAt;
    }

    public Integer getIdfestivo() {
        return idfestivo;
    }

    public void setIdfestivo(Integer idfestivo) {
        this.idfestivo = idfestivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfestivo != null ? idfestivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Festivo)) {
            return false;
        }
        Festivo other = (Festivo) object;
        if ((this.idfestivo == null && other.idfestivo != null) || (this.idfestivo != null && !this.idfestivo.equals(other.idfestivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Festivo[ idfestivo=" + idfestivo + " ]";
    }
    
}
