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
@Table(name = "agenteestadocambio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenteestadocambio.findAll", query = "SELECT a FROM Agenteestadocambio a")
    , @NamedQuery(name = "Agenteestadocambio.findByIdcambio", query = "SELECT a FROM Agenteestadocambio a WHERE a.idcambio = :idcambio")
    , @NamedQuery(name = "Agenteestadocambio.findByObservaciones", query = "SELECT a FROM Agenteestadocambio a WHERE a.observaciones = :observaciones")
    , @NamedQuery(name = "Agenteestadocambio.findByFecha", query = "SELECT a FROM Agenteestadocambio a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Agenteestadocambio.findByFechaFin", query = "SELECT a FROM Agenteestadocambio a WHERE a.fechaFin = :fechaFin")})
public class Agenteestadocambio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcambio")
    private Long idcambio;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @JoinColumn(name = "idagente", referencedColumnName = "idagente")
    @ManyToOne(optional = false)
    private Agente idagente;
    @JoinColumn(name = "idestado_actual", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Agenteestado idestadoActual;
    @JoinColumn(name = "idestado_anterior", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Agenteestado idestadoAnterior;
    @JoinColumn(name = "idllamada_ultima", referencedColumnName = "idllamada")
    @ManyToOne
    private Llamada idllamadaUltima;
    @OneToMany(mappedBy = "idcambioUltimo")
    private Collection<Agente> agenteCollection;

    public Agenteestadocambio() {
    }

    public Agenteestadocambio(Long idcambio) {
        this.idcambio = idcambio;
    }

    public Agenteestadocambio(Long idcambio, Date fecha) {
        this.idcambio = idcambio;
        this.fecha = fecha;
    }

    public Long getIdcambio() {
        return idcambio;
    }

    public void setIdcambio(Long idcambio) {
        this.idcambio = idcambio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Agente getIdagente() {
        return idagente;
    }

    public void setIdagente(Agente idagente) {
        this.idagente = idagente;
    }

    public Agenteestado getIdestadoActual() {
        return idestadoActual;
    }

    public void setIdestadoActual(Agenteestado idestadoActual) {
        this.idestadoActual = idestadoActual;
    }

    public Agenteestado getIdestadoAnterior() {
        return idestadoAnterior;
    }

    public void setIdestadoAnterior(Agenteestado idestadoAnterior) {
        this.idestadoAnterior = idestadoAnterior;
    }

    public Llamada getIdllamadaUltima() {
        return idllamadaUltima;
    }

    public void setIdllamadaUltima(Llamada idllamadaUltima) {
        this.idllamadaUltima = idllamadaUltima;
    }

    @XmlTransient
    public Collection<Agente> getAgenteCollection() {
        return agenteCollection;
    }

    public void setAgenteCollection(Collection<Agente> agenteCollection) {
        this.agenteCollection = agenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcambio != null ? idcambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenteestadocambio)) {
            return false;
        }
        Agenteestadocambio other = (Agenteestadocambio) object;
        if ((this.idcambio == null && other.idcambio != null) || (this.idcambio != null && !this.idcambio.equals(other.idcambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Agenteestadocambio[ idcambio=" + idcambio + " ]";
    }
    
}
