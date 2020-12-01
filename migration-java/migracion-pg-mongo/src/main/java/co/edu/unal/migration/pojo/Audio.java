/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "audio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audio.findAll", query = "SELECT a FROM Audio a")
    , @NamedQuery(name = "Audio.findByIdaudio", query = "SELECT a FROM Audio a WHERE a.idaudio = :idaudio")
    , @NamedQuery(name = "Audio.findByNombre", query = "SELECT a FROM Audio a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Audio.findByGuion", query = "SELECT a FROM Audio a WHERE a.guion = :guion")
    , @NamedQuery(name = "Audio.findByPathGrabacion", query = "SELECT a FROM Audio a WHERE a.pathGrabacion = :pathGrabacion")
    , @NamedQuery(name = "Audio.findByUpdatedAt", query = "SELECT a FROM Audio a WHERE a.updatedAt = :updatedAt")})
public class Audio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaudio")
    private Integer idaudio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "guion")
    private String guion;
    @Column(name = "path_grabacion")
    private String pathGrabacion;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "timeoutAbsolutoIdaudio")
    private Collection<Cola> colaCollection;
    @OneToMany(mappedBy = "timeoutIdaudio")
    private Collection<Cola> colaCollection1;
    @JoinColumn(name = "idivr", referencedColumnName = "idivr")
    @ManyToOne
    private Ivr idivr;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(mappedBy = "idaudio")
    private Collection<Ivr> ivrCollection;
    @OneToMany(mappedBy = "idaudioHorarioFuera")
    private Collection<Ivr> ivrCollection1;
    @OneToMany(mappedBy = "idaudioSuspendido")
    private Collection<Ivr> ivrCollection2;
    @OneToMany(mappedBy = "idaudioHorarioFuera")
    private Collection<Campana> campanaCollection;
    @OneToMany(mappedBy = "marcadorAccIdaudio")
    private Collection<Campana> campanaCollection1;

    public Audio() {
    }

    public Audio(Integer idaudio) {
        this.idaudio = idaudio;
    }

    public Audio(Integer idaudio, String nombre, String guion, Date updatedAt) {
        this.idaudio = idaudio;
        this.nombre = nombre;
        this.guion = guion;
        this.updatedAt = updatedAt;
    }

    public Integer getIdaudio() {
        return idaudio;
    }

    public void setIdaudio(Integer idaudio) {
        this.idaudio = idaudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGuion() {
        return guion;
    }

    public void setGuion(String guion) {
        this.guion = guion;
    }

    public String getPathGrabacion() {
        return pathGrabacion;
    }

    public void setPathGrabacion(String pathGrabacion) {
        this.pathGrabacion = pathGrabacion;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Collection<Cola> getColaCollection() {
        return colaCollection;
    }

    public void setColaCollection(Collection<Cola> colaCollection) {
        this.colaCollection = colaCollection;
    }

    @XmlTransient
    public Collection<Cola> getColaCollection1() {
        return colaCollection1;
    }

    public void setColaCollection1(Collection<Cola> colaCollection1) {
        this.colaCollection1 = colaCollection1;
    }

    public Ivr getIdivr() {
        return idivr;
    }

    public void setIdivr(Ivr idivr) {
        this.idivr = idivr;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<Ivr> getIvrCollection() {
        return ivrCollection;
    }

    public void setIvrCollection(Collection<Ivr> ivrCollection) {
        this.ivrCollection = ivrCollection;
    }

    @XmlTransient
    public Collection<Ivr> getIvrCollection1() {
        return ivrCollection1;
    }

    public void setIvrCollection1(Collection<Ivr> ivrCollection1) {
        this.ivrCollection1 = ivrCollection1;
    }

    @XmlTransient
    public Collection<Ivr> getIvrCollection2() {
        return ivrCollection2;
    }

    public void setIvrCollection2(Collection<Ivr> ivrCollection2) {
        this.ivrCollection2 = ivrCollection2;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection() {
        return campanaCollection;
    }

    public void setCampanaCollection(Collection<Campana> campanaCollection) {
        this.campanaCollection = campanaCollection;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection1() {
        return campanaCollection1;
    }

    public void setCampanaCollection1(Collection<Campana> campanaCollection1) {
        this.campanaCollection1 = campanaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaudio != null ? idaudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audio)) {
            return false;
        }
        Audio other = (Audio) object;
        if ((this.idaudio == null && other.idaudio != null) || (this.idaudio != null && !this.idaudio.equals(other.idaudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Audio[ idaudio=" + idaudio + " ]";
    }
    
}
