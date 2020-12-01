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
@Table(name = "llamada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamada.findAll", query = "SELECT l FROM Llamada l")
    , @NamedQuery(name = "Llamada.findByIdllamada", query = "SELECT l FROM Llamada l WHERE l.idllamada = :idllamada")
    , @NamedQuery(name = "Llamada.findByIdllamadaPbx", query = "SELECT l FROM Llamada l WHERE l.idllamadaPbx = :idllamadaPbx")
    , @NamedQuery(name = "Llamada.findByFechaIni", query = "SELECT l FROM Llamada l WHERE l.fechaIni = :fechaIni")
    , @NamedQuery(name = "Llamada.findByFechaFin", query = "SELECT l FROM Llamada l WHERE l.fechaFin = :fechaFin")
    , @NamedQuery(name = "Llamada.findByObservaciones", query = "SELECT l FROM Llamada l WHERE l.observaciones = :observaciones")
    , @NamedQuery(name = "Llamada.findByDisposicion", query = "SELECT l FROM Llamada l WHERE l.disposicion = :disposicion")
    , @NamedQuery(name = "Llamada.findByTiempoCola", query = "SELECT l FROM Llamada l WHERE l.tiempoCola = :tiempoCola")
    , @NamedQuery(name = "Llamada.findByTiempoHold", query = "SELECT l FROM Llamada l WHERE l.tiempoHold = :tiempoHold")
    , @NamedQuery(name = "Llamada.findByTiempoTimbrado", query = "SELECT l FROM Llamada l WHERE l.tiempoTimbrado = :tiempoTimbrado")
    , @NamedQuery(name = "Llamada.findByTipo", query = "SELECT l FROM Llamada l WHERE l.tipo = :tipo")
    , @NamedQuery(name = "Llamada.findByTiempoIvr", query = "SELECT l FROM Llamada l WHERE l.tiempoIvr = :tiempoIvr")
    , @NamedQuery(name = "Llamada.findByTiempoConversacion", query = "SELECT l FROM Llamada l WHERE l.tiempoConversacion = :tiempoConversacion")})
public class Llamada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idllamada")
    private Long idllamada;
    @Basic(optional = false)
    @Column(name = "idllamada_pbx")
    private String idllamadaPbx;
    @Basic(optional = false)
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "disposicion")
    private String disposicion;
    @Basic(optional = false)
    @Column(name = "tiempo_cola")
    private long tiempoCola;
    @Basic(optional = false)
    @Column(name = "tiempo_hold")
    private long tiempoHold;
    @Basic(optional = false)
    @Column(name = "tiempo_timbrado")
    private long tiempoTimbrado;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "tiempo_ivr")
    private long tiempoIvr;
    @Basic(optional = false)
    @Column(name = "tiempo_conversacion")
    private long tiempoConversacion;
    @JoinColumn(name = "idagente", referencedColumnName = "idagente")
    @ManyToOne(optional = false)
    private Agente idagente;
    @JoinColumn(name = "idcampana", referencedColumnName = "idcampana")
    @ManyToOne
    private Campana idcampana;
    @JoinColumn(name = "idpersona_origen", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersonaOrigen;
    @JoinColumn(name = "idtelefono_des", referencedColumnName = "idtelefono")
    @ManyToOne(optional = false)
    private Telefono idtelefonoDes;
    @JoinColumn(name = "idtelefono_ori", referencedColumnName = "idtelefono")
    @ManyToOne(optional = false)
    private Telefono idtelefonoOri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idllamada")
    private Collection<Transferencia> transferenciaCollection;
    @OneToMany(mappedBy = "idllamadaUltima")
    private Collection<Agenteestadocambio> agenteestadocambioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idllamada")
    private Collection<Llamadagestion> llamadagestionCollection;
    @OneToMany(mappedBy = "idllamada")
    private Collection<Fpqr> fpqrCollection;

    public Llamada() {
    }

    public Llamada(Long idllamada) {
        this.idllamada = idllamada;
    }

    public Llamada(Long idllamada, String idllamadaPbx, Date fechaIni, String disposicion, long tiempoCola, long tiempoHold, long tiempoTimbrado, String tipo, long tiempoIvr, long tiempoConversacion) {
        this.idllamada = idllamada;
        this.idllamadaPbx = idllamadaPbx;
        this.fechaIni = fechaIni;
        this.disposicion = disposicion;
        this.tiempoCola = tiempoCola;
        this.tiempoHold = tiempoHold;
        this.tiempoTimbrado = tiempoTimbrado;
        this.tipo = tipo;
        this.tiempoIvr = tiempoIvr;
        this.tiempoConversacion = tiempoConversacion;
    }

    public Long getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(Long idllamada) {
        this.idllamada = idllamada;
    }

    public String getIdllamadaPbx() {
        return idllamadaPbx;
    }

    public void setIdllamadaPbx(String idllamadaPbx) {
        this.idllamadaPbx = idllamadaPbx;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(String disposicion) {
        this.disposicion = disposicion;
    }

    public long getTiempoCola() {
        return tiempoCola;
    }

    public void setTiempoCola(long tiempoCola) {
        this.tiempoCola = tiempoCola;
    }

    public long getTiempoHold() {
        return tiempoHold;
    }

    public void setTiempoHold(long tiempoHold) {
        this.tiempoHold = tiempoHold;
    }

    public long getTiempoTimbrado() {
        return tiempoTimbrado;
    }

    public void setTiempoTimbrado(long tiempoTimbrado) {
        this.tiempoTimbrado = tiempoTimbrado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getTiempoIvr() {
        return tiempoIvr;
    }

    public void setTiempoIvr(long tiempoIvr) {
        this.tiempoIvr = tiempoIvr;
    }

    public long getTiempoConversacion() {
        return tiempoConversacion;
    }

    public void setTiempoConversacion(long tiempoConversacion) {
        this.tiempoConversacion = tiempoConversacion;
    }

    public Agente getIdagente() {
        return idagente;
    }

    public void setIdagente(Agente idagente) {
        this.idagente = idagente;
    }

    public Campana getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(Campana idcampana) {
        this.idcampana = idcampana;
    }

    public Persona getIdpersonaOrigen() {
        return idpersonaOrigen;
    }

    public void setIdpersonaOrigen(Persona idpersonaOrigen) {
        this.idpersonaOrigen = idpersonaOrigen;
    }

    public Telefono getIdtelefonoDes() {
        return idtelefonoDes;
    }

    public void setIdtelefonoDes(Telefono idtelefonoDes) {
        this.idtelefonoDes = idtelefonoDes;
    }

    public Telefono getIdtelefonoOri() {
        return idtelefonoOri;
    }

    public void setIdtelefonoOri(Telefono idtelefonoOri) {
        this.idtelefonoOri = idtelefonoOri;
    }

    @XmlTransient
    public Collection<Transferencia> getTransferenciaCollection() {
        return transferenciaCollection;
    }

    public void setTransferenciaCollection(Collection<Transferencia> transferenciaCollection) {
        this.transferenciaCollection = transferenciaCollection;
    }

    @XmlTransient
    public Collection<Agenteestadocambio> getAgenteestadocambioCollection() {
        return agenteestadocambioCollection;
    }

    public void setAgenteestadocambioCollection(Collection<Agenteestadocambio> agenteestadocambioCollection) {
        this.agenteestadocambioCollection = agenteestadocambioCollection;
    }

    @XmlTransient
    public Collection<Llamadagestion> getLlamadagestionCollection() {
        return llamadagestionCollection;
    }

    public void setLlamadagestionCollection(Collection<Llamadagestion> llamadagestionCollection) {
        this.llamadagestionCollection = llamadagestionCollection;
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
        hash += (idllamada != null ? idllamada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamada)) {
            return false;
        }
        Llamada other = (Llamada) object;
        if ((this.idllamada == null && other.idllamada != null) || (this.idllamada != null && !this.idllamada.equals(other.idllamada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Llamada[ idllamada=" + idllamada + " ]";
    }
    
}
