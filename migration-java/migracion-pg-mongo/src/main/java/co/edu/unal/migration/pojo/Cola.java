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
@Table(name = "cola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cola.findAll", query = "SELECT c FROM Cola c")
    , @NamedQuery(name = "Cola.findByIdcola", query = "SELECT c FROM Cola c WHERE c.idcola = :idcola")
    , @NamedQuery(name = "Cola.findByNombre", query = "SELECT c FROM Cola c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cola.findByProperties", query = "SELECT c FROM Cola c WHERE c.properties = :properties")
    , @NamedQuery(name = "Cola.findByUpdatedAt", query = "SELECT c FROM Cola c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Cola.findByAllAgentes", query = "SELECT c FROM Cola c WHERE c.allAgentes = :allAgentes")
    , @NamedQuery(name = "Cola.findByAgenteAddDel", query = "SELECT c FROM Cola c WHERE c.agenteAddDel = :agenteAddDel")
    , @NamedQuery(name = "Cola.findByTimeoutSeg", query = "SELECT c FROM Cola c WHERE c.timeoutSeg = :timeoutSeg")
    , @NamedQuery(name = "Cola.findByTimeoutDigitoVoicemail", query = "SELECT c FROM Cola c WHERE c.timeoutDigitoVoicemail = :timeoutDigitoVoicemail")
    , @NamedQuery(name = "Cola.findByIsTimeoutAbsoluto", query = "SELECT c FROM Cola c WHERE c.isTimeoutAbsoluto = :isTimeoutAbsoluto")
    , @NamedQuery(name = "Cola.findByTimeoutAbsoluto", query = "SELECT c FROM Cola c WHERE c.timeoutAbsoluto = :timeoutAbsoluto")})
public class Cola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcola")
    private Integer idcola;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "properties")
    private String properties;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "all_agentes")
    private boolean allAgentes;
    @Basic(optional = false)
    @Column(name = "agente_add_del")
    private boolean agenteAddDel;
    @Basic(optional = false)
    @Column(name = "timeout_seg")
    private int timeoutSeg;
    @Column(name = "timeout_digito_voicemail")
    private String timeoutDigitoVoicemail;
    @Basic(optional = false)
    @Column(name = "is_timeout_absoluto")
    private boolean isTimeoutAbsoluto;
    @Basic(optional = false)
    @Column(name = "timeout_absoluto")
    private int timeoutAbsoluto;
    @JoinColumn(name = "timeout_absoluto_idaudio", referencedColumnName = "idaudio")
    @ManyToOne
    private Audio timeoutAbsolutoIdaudio;
    @JoinColumn(name = "timeout_idaudio", referencedColumnName = "idaudio")
    @ManyToOne
    private Audio timeoutIdaudio;
    @JoinColumn(name = "idextension", referencedColumnName = "idextension")
    @ManyToOne(optional = false)
    private Extension idextension;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcola")
    private Collection<ColaHasAgente> colaHasAgenteCollection;
    @OneToMany(mappedBy = "accIdcola")
    private Collection<IvrOpcion> ivrOpcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcola")
    private Collection<Campana> campanaCollection;
    @OneToMany(mappedBy = "marcadorAccIdcola")
    private Collection<Campana> campanaCollection1;

    public Cola() {
    }

    public Cola(Integer idcola) {
        this.idcola = idcola;
    }

    public Cola(Integer idcola, String nombre, Date updatedAt, boolean allAgentes, boolean agenteAddDel, int timeoutSeg, boolean isTimeoutAbsoluto, int timeoutAbsoluto) {
        this.idcola = idcola;
        this.nombre = nombre;
        this.updatedAt = updatedAt;
        this.allAgentes = allAgentes;
        this.agenteAddDel = agenteAddDel;
        this.timeoutSeg = timeoutSeg;
        this.isTimeoutAbsoluto = isTimeoutAbsoluto;
        this.timeoutAbsoluto = timeoutAbsoluto;
    }

    public Integer getIdcola() {
        return idcola;
    }

    public void setIdcola(Integer idcola) {
        this.idcola = idcola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getAllAgentes() {
        return allAgentes;
    }

    public void setAllAgentes(boolean allAgentes) {
        this.allAgentes = allAgentes;
    }

    public boolean getAgenteAddDel() {
        return agenteAddDel;
    }

    public void setAgenteAddDel(boolean agenteAddDel) {
        this.agenteAddDel = agenteAddDel;
    }

    public int getTimeoutSeg() {
        return timeoutSeg;
    }

    public void setTimeoutSeg(int timeoutSeg) {
        this.timeoutSeg = timeoutSeg;
    }

    public String getTimeoutDigitoVoicemail() {
        return timeoutDigitoVoicemail;
    }

    public void setTimeoutDigitoVoicemail(String timeoutDigitoVoicemail) {
        this.timeoutDigitoVoicemail = timeoutDigitoVoicemail;
    }

    public boolean getIsTimeoutAbsoluto() {
        return isTimeoutAbsoluto;
    }

    public void setIsTimeoutAbsoluto(boolean isTimeoutAbsoluto) {
        this.isTimeoutAbsoluto = isTimeoutAbsoluto;
    }

    public int getTimeoutAbsoluto() {
        return timeoutAbsoluto;
    }

    public void setTimeoutAbsoluto(int timeoutAbsoluto) {
        this.timeoutAbsoluto = timeoutAbsoluto;
    }

    public Audio getTimeoutAbsolutoIdaudio() {
        return timeoutAbsolutoIdaudio;
    }

    public void setTimeoutAbsolutoIdaudio(Audio timeoutAbsolutoIdaudio) {
        this.timeoutAbsolutoIdaudio = timeoutAbsolutoIdaudio;
    }

    public Audio getTimeoutIdaudio() {
        return timeoutIdaudio;
    }

    public void setTimeoutIdaudio(Audio timeoutIdaudio) {
        this.timeoutIdaudio = timeoutIdaudio;
    }

    public Extension getIdextension() {
        return idextension;
    }

    public void setIdextension(Extension idextension) {
        this.idextension = idextension;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<ColaHasAgente> getColaHasAgenteCollection() {
        return colaHasAgenteCollection;
    }

    public void setColaHasAgenteCollection(Collection<ColaHasAgente> colaHasAgenteCollection) {
        this.colaHasAgenteCollection = colaHasAgenteCollection;
    }

    @XmlTransient
    public Collection<IvrOpcion> getIvrOpcionCollection() {
        return ivrOpcionCollection;
    }

    public void setIvrOpcionCollection(Collection<IvrOpcion> ivrOpcionCollection) {
        this.ivrOpcionCollection = ivrOpcionCollection;
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
        hash += (idcola != null ? idcola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cola)) {
            return false;
        }
        Cola other = (Cola) object;
        if ((this.idcola == null && other.idcola != null) || (this.idcola != null && !this.idcola.equals(other.idcola))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Cola[ idcola=" + idcola + " ]";
    }
    
}
