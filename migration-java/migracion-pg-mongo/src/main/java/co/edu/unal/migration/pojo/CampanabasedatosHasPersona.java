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
@Table(name = "campanabasedatos_has_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CampanabasedatosHasPersona.findAll", query = "SELECT c FROM CampanabasedatosHasPersona c")
    , @NamedQuery(name = "CampanabasedatosHasPersona.findByIdbdp", query = "SELECT c FROM CampanabasedatosHasPersona c WHERE c.idbdp = :idbdp")
    , @NamedQuery(name = "CampanabasedatosHasPersona.findByCreatedAt", query = "SELECT c FROM CampanabasedatosHasPersona c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "CampanabasedatosHasPersona.findByPrametrosXml", query = "SELECT c FROM CampanabasedatosHasPersona c WHERE c.prametrosXml = :prametrosXml")
    , @NamedQuery(name = "CampanabasedatosHasPersona.findByEstado", query = "SELECT c FROM CampanabasedatosHasPersona c WHERE c.estado = :estado")
    , @NamedQuery(name = "CampanabasedatosHasPersona.findByEstadoObservaciones", query = "SELECT c FROM CampanabasedatosHasPersona c WHERE c.estadoObservaciones = :estadoObservaciones")})
public class CampanabasedatosHasPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbdp")
    private Long idbdp;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "prametros_xml")
    private String prametrosXml;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Column(name = "estado_observaciones")
    private String estadoObservaciones;
    @JoinColumn(name = "idagente", referencedColumnName = "idagente")
    @ManyToOne
    private Agente idagente;
    @JoinColumn(name = "idbd", referencedColumnName = "idbd")
    @ManyToOne(optional = false)
    private Campanabasedatos idbd;
    @JoinColumn(name = "idgestion_ultima", referencedColumnName = "idgestion")
    @ManyToOne
    private Llamadagestion idgestionUltima;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersona;
    @JoinColumn(name = "idtelefono", referencedColumnName = "idtelefono")
    @ManyToOne(optional = false)
    private Telefono idtelefono;

    public CampanabasedatosHasPersona() {
    }

    public CampanabasedatosHasPersona(Long idbdp) {
        this.idbdp = idbdp;
    }

    public CampanabasedatosHasPersona(Long idbdp, Date createdAt, String estado) {
        this.idbdp = idbdp;
        this.createdAt = createdAt;
        this.estado = estado;
    }

    public Long getIdbdp() {
        return idbdp;
    }

    public void setIdbdp(Long idbdp) {
        this.idbdp = idbdp;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrametrosXml() {
        return prametrosXml;
    }

    public void setPrametrosXml(String prametrosXml) {
        this.prametrosXml = prametrosXml;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoObservaciones() {
        return estadoObservaciones;
    }

    public void setEstadoObservaciones(String estadoObservaciones) {
        this.estadoObservaciones = estadoObservaciones;
    }

    public Agente getIdagente() {
        return idagente;
    }

    public void setIdagente(Agente idagente) {
        this.idagente = idagente;
    }

    public Campanabasedatos getIdbd() {
        return idbd;
    }

    public void setIdbd(Campanabasedatos idbd) {
        this.idbd = idbd;
    }

    public Llamadagestion getIdgestionUltima() {
        return idgestionUltima;
    }

    public void setIdgestionUltima(Llamadagestion idgestionUltima) {
        this.idgestionUltima = idgestionUltima;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Telefono getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Telefono idtelefono) {
        this.idtelefono = idtelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbdp != null ? idbdp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampanabasedatosHasPersona)) {
            return false;
        }
        CampanabasedatosHasPersona other = (CampanabasedatosHasPersona) object;
        if ((this.idbdp == null && other.idbdp != null) || (this.idbdp != null && !this.idbdp.equals(other.idbdp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.CampanabasedatosHasPersona[ idbdp=" + idbdp + " ]";
    }
    
}
