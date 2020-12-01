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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "agente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agente.findAll", query = "SELECT a FROM Agente a")
    , @NamedQuery(name = "Agente.findByIdagente", query = "SELECT a FROM Agente a WHERE a.idagente = :idagente")
    , @NamedQuery(name = "Agente.findByHostActual", query = "SELECT a FROM Agente a WHERE a.hostActual = :hostActual")
    , @NamedQuery(name = "Agente.findByVncClientPort", query = "SELECT a FROM Agente a WHERE a.vncClientPort = :vncClientPort")})
public class Agente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagente")
    private Integer idagente;
    @Column(name = "host_actual")
    private String hostActual;
    @Column(name = "vnc_client_port")
    private Integer vncClientPort;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagente")
    private Collection<Llamada> llamadaCollection;
    @OneToMany(mappedBy = "idagente")
    private Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagente")
    private Collection<Agenteestadocambio> agenteestadocambioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagente")
    private Collection<ColaHasAgente> colaHasAgenteCollection;
    @JoinColumn(name = "idcambio_ultimo", referencedColumnName = "idcambio")
    @ManyToOne
    private Agenteestadocambio idcambioUltimo;
    @JoinColumn(name = "idcampana_prox_llamada", referencedColumnName = "idcampana")
    @ManyToOne
    private Campana idcampanaProxLlamada;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idpersona_prox_llamada", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersonaProxLlamada;
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false)
    private Sucursal idsucursal;
    @JoinColumn(name = "idtelefono_prox_llamada", referencedColumnName = "idtelefono")
    @ManyToOne
    private Telefono idtelefonoProxLlamada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagenteProgramacion")
    private Collection<Llamadaprogramada> llamadaprogramadaCollection;

    public Agente() {
    }

    public Agente(Integer idagente) {
        this.idagente = idagente;
    }

    public Integer getIdagente() {
        return idagente;
    }

    public void setIdagente(Integer idagente) {
        this.idagente = idagente;
    }

    public String getHostActual() {
        return hostActual;
    }

    public void setHostActual(String hostActual) {
        this.hostActual = hostActual;
    }

    public Integer getVncClientPort() {
        return vncClientPort;
    }

    public void setVncClientPort(Integer vncClientPort) {
        this.vncClientPort = vncClientPort;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
    }

    @XmlTransient
    public Collection<CampanabasedatosHasPersona> getCampanabasedatosHasPersonaCollection() {
        return campanabasedatosHasPersonaCollection;
    }

    public void setCampanabasedatosHasPersonaCollection(Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection) {
        this.campanabasedatosHasPersonaCollection = campanabasedatosHasPersonaCollection;
    }

    @XmlTransient
    public Collection<Agenteestadocambio> getAgenteestadocambioCollection() {
        return agenteestadocambioCollection;
    }

    public void setAgenteestadocambioCollection(Collection<Agenteestadocambio> agenteestadocambioCollection) {
        this.agenteestadocambioCollection = agenteestadocambioCollection;
    }

    @XmlTransient
    public Collection<ColaHasAgente> getColaHasAgenteCollection() {
        return colaHasAgenteCollection;
    }

    public void setColaHasAgenteCollection(Collection<ColaHasAgente> colaHasAgenteCollection) {
        this.colaHasAgenteCollection = colaHasAgenteCollection;
    }

    public Agenteestadocambio getIdcambioUltimo() {
        return idcambioUltimo;
    }

    public void setIdcambioUltimo(Agenteestadocambio idcambioUltimo) {
        this.idcambioUltimo = idcambioUltimo;
    }

    public Campana getIdcampanaProxLlamada() {
        return idcampanaProxLlamada;
    }

    public void setIdcampanaProxLlamada(Campana idcampanaProxLlamada) {
        this.idcampanaProxLlamada = idcampanaProxLlamada;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Persona getIdpersonaProxLlamada() {
        return idpersonaProxLlamada;
    }

    public void setIdpersonaProxLlamada(Persona idpersonaProxLlamada) {
        this.idpersonaProxLlamada = idpersonaProxLlamada;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    public Telefono getIdtelefonoProxLlamada() {
        return idtelefonoProxLlamada;
    }

    public void setIdtelefonoProxLlamada(Telefono idtelefonoProxLlamada) {
        this.idtelefonoProxLlamada = idtelefonoProxLlamada;
    }

    @XmlTransient
    public Collection<Llamadaprogramada> getLlamadaprogramadaCollection() {
        return llamadaprogramadaCollection;
    }

    public void setLlamadaprogramadaCollection(Collection<Llamadaprogramada> llamadaprogramadaCollection) {
        this.llamadaprogramadaCollection = llamadaprogramadaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idagente != null ? idagente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agente)) {
            return false;
        }
        Agente other = (Agente) object;
        if ((this.idagente == null && other.idagente != null) || (this.idagente != null && !this.idagente.equals(other.idagente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Agente[ idagente=" + idagente + " ]";
    }
    
}
