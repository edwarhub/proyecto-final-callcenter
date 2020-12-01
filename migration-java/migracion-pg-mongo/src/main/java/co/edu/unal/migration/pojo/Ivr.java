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
import javax.persistence.CascadeType;
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
@Table(name = "ivr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ivr.findAll", query = "SELECT i FROM Ivr i")
    , @NamedQuery(name = "Ivr.findByIdivr", query = "SELECT i FROM Ivr i WHERE i.idivr = :idivr")
    , @NamedQuery(name = "Ivr.findByNombre", query = "SELECT i FROM Ivr i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Ivr.findByObservaciones", query = "SELECT i FROM Ivr i WHERE i.observaciones = :observaciones")
    , @NamedQuery(name = "Ivr.findByUpdatedAt", query = "SELECT i FROM Ivr i WHERE i.updatedAt = :updatedAt")
    , @NamedQuery(name = "Ivr.findByFuncionaFestivos", query = "SELECT i FROM Ivr i WHERE i.funcionaFestivos = :funcionaFestivos")
    , @NamedQuery(name = "Ivr.findByIsHorarioOk", query = "SELECT i FROM Ivr i WHERE i.isHorarioOk = :isHorarioOk")
    , @NamedQuery(name = "Ivr.findByHorarioOkUltimaSync", query = "SELECT i FROM Ivr i WHERE i.horarioOkUltimaSync = :horarioOkUltimaSync")
    , @NamedQuery(name = "Ivr.findByIsSuspendido", query = "SELECT i FROM Ivr i WHERE i.isSuspendido = :isSuspendido")})
public class Ivr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idivr")
    private Integer idivr;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "funciona_festivos")
    private boolean funcionaFestivos;
    @Basic(optional = false)
    @Column(name = "is_horario_ok")
    private boolean isHorarioOk;
    @Basic(optional = false)
    @Column(name = "horario_ok_ultima_sync")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioOkUltimaSync;
    @Basic(optional = false)
    @Column(name = "is_suspendido")
    private boolean isSuspendido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idivr")
    private Collection<Ivrhorario> ivrhorarioCollection;
    @OneToMany(mappedBy = "idivr")
    private Collection<Audio> audioCollection;
    @OneToMany(mappedBy = "accIdivr")
    private Collection<IvrOpcion> ivrOpcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idivr")
    private Collection<IvrOpcion> ivrOpcionCollection1;
    @JoinColumn(name = "idaudio", referencedColumnName = "idaudio")
    @ManyToOne
    private Audio idaudio;
    @JoinColumn(name = "idaudio_horario_fuera", referencedColumnName = "idaudio")
    @ManyToOne
    private Audio idaudioHorarioFuera;
    @JoinColumn(name = "idaudio_suspendido", referencedColumnName = "idaudio")
    @ManyToOne
    private Audio idaudioSuspendido;
    @JoinColumn(name = "idextension", referencedColumnName = "idextension")
    @ManyToOne(optional = false)
    private Extension idextension;
    @JoinColumn(name = "idextension_timeout", referencedColumnName = "idextension")
    @ManyToOne
    private Extension idextensionTimeout;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(mappedBy = "marcadorAccIdivr")
    private Collection<Campana> campanaCollection;

    public Ivr() {
    }

    public Ivr(Integer idivr) {
        this.idivr = idivr;
    }

    public Ivr(Integer idivr, String nombre, Date updatedAt, boolean funcionaFestivos, boolean isHorarioOk, Date horarioOkUltimaSync, boolean isSuspendido) {
        this.idivr = idivr;
        this.nombre = nombre;
        this.updatedAt = updatedAt;
        this.funcionaFestivos = funcionaFestivos;
        this.isHorarioOk = isHorarioOk;
        this.horarioOkUltimaSync = horarioOkUltimaSync;
        this.isSuspendido = isSuspendido;
    }

    public Integer getIdivr() {
        return idivr;
    }

    public void setIdivr(Integer idivr) {
        this.idivr = idivr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public boolean getFuncionaFestivos() {
        return funcionaFestivos;
    }

    public void setFuncionaFestivos(boolean funcionaFestivos) {
        this.funcionaFestivos = funcionaFestivos;
    }

    public boolean getIsHorarioOk() {
        return isHorarioOk;
    }

    public void setIsHorarioOk(boolean isHorarioOk) {
        this.isHorarioOk = isHorarioOk;
    }

    public Date getHorarioOkUltimaSync() {
        return horarioOkUltimaSync;
    }

    public void setHorarioOkUltimaSync(Date horarioOkUltimaSync) {
        this.horarioOkUltimaSync = horarioOkUltimaSync;
    }

    public boolean getIsSuspendido() {
        return isSuspendido;
    }

    public void setIsSuspendido(boolean isSuspendido) {
        this.isSuspendido = isSuspendido;
    }

    @XmlTransient
    public Collection<Ivrhorario> getIvrhorarioCollection() {
        return ivrhorarioCollection;
    }

    public void setIvrhorarioCollection(Collection<Ivrhorario> ivrhorarioCollection) {
        this.ivrhorarioCollection = ivrhorarioCollection;
    }

    @XmlTransient
    public Collection<Audio> getAudioCollection() {
        return audioCollection;
    }

    public void setAudioCollection(Collection<Audio> audioCollection) {
        this.audioCollection = audioCollection;
    }

    @XmlTransient
    public Collection<IvrOpcion> getIvrOpcionCollection() {
        return ivrOpcionCollection;
    }

    public void setIvrOpcionCollection(Collection<IvrOpcion> ivrOpcionCollection) {
        this.ivrOpcionCollection = ivrOpcionCollection;
    }

    @XmlTransient
    public Collection<IvrOpcion> getIvrOpcionCollection1() {
        return ivrOpcionCollection1;
    }

    public void setIvrOpcionCollection1(Collection<IvrOpcion> ivrOpcionCollection1) {
        this.ivrOpcionCollection1 = ivrOpcionCollection1;
    }

    public Audio getIdaudio() {
        return idaudio;
    }

    public void setIdaudio(Audio idaudio) {
        this.idaudio = idaudio;
    }

    public Audio getIdaudioHorarioFuera() {
        return idaudioHorarioFuera;
    }

    public void setIdaudioHorarioFuera(Audio idaudioHorarioFuera) {
        this.idaudioHorarioFuera = idaudioHorarioFuera;
    }

    public Audio getIdaudioSuspendido() {
        return idaudioSuspendido;
    }

    public void setIdaudioSuspendido(Audio idaudioSuspendido) {
        this.idaudioSuspendido = idaudioSuspendido;
    }

    public Extension getIdextension() {
        return idextension;
    }

    public void setIdextension(Extension idextension) {
        this.idextension = idextension;
    }

    public Extension getIdextensionTimeout() {
        return idextensionTimeout;
    }

    public void setIdextensionTimeout(Extension idextensionTimeout) {
        this.idextensionTimeout = idextensionTimeout;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection() {
        return campanaCollection;
    }

    public void setCampanaCollection(Collection<Campana> campanaCollection) {
        this.campanaCollection = campanaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idivr != null ? idivr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ivr)) {
            return false;
        }
        Ivr other = (Ivr) object;
        if ((this.idivr == null && other.idivr != null) || (this.idivr != null && !this.idivr.equals(other.idivr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Ivr[ idivr=" + idivr + " ]";
    }
    
}
