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
@Table(name = "llamadaprogramada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamadaprogramada.findAll", query = "SELECT l FROM Llamadaprogramada l")
    , @NamedQuery(name = "Llamadaprogramada.findByIdprogramada", query = "SELECT l FROM Llamadaprogramada l WHERE l.idprogramada = :idprogramada")
    , @NamedQuery(name = "Llamadaprogramada.findByObservaciones", query = "SELECT l FROM Llamadaprogramada l WHERE l.observaciones = :observaciones")
    , @NamedQuery(name = "Llamadaprogramada.findByFechaProgramacion", query = "SELECT l FROM Llamadaprogramada l WHERE l.fechaProgramacion = :fechaProgramacion")
    , @NamedQuery(name = "Llamadaprogramada.findByCreatedAt", query = "SELECT l FROM Llamadaprogramada l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "Llamadaprogramada.findByIsRealizada", query = "SELECT l FROM Llamadaprogramada l WHERE l.isRealizada = :isRealizada")})
public class Llamadaprogramada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprogramada")
    private Integer idprogramada;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "fecha_programacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProgramacion;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "is_realizada")
    private boolean isRealizada;
    @JoinColumn(name = "idagente_programacion", referencedColumnName = "idagente")
    @ManyToOne(optional = false)
    private Agente idagenteProgramacion;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersona;
    @JoinColumn(name = "idtelefono", referencedColumnName = "idtelefono")
    @ManyToOne(optional = false)
    private Telefono idtelefono;

    public Llamadaprogramada() {
    }

    public Llamadaprogramada(Integer idprogramada) {
        this.idprogramada = idprogramada;
    }

    public Llamadaprogramada(Integer idprogramada, Date fechaProgramacion, Date createdAt, boolean isRealizada) {
        this.idprogramada = idprogramada;
        this.fechaProgramacion = fechaProgramacion;
        this.createdAt = createdAt;
        this.isRealizada = isRealizada;
    }

    public Integer getIdprogramada() {
        return idprogramada;
    }

    public void setIdprogramada(Integer idprogramada) {
        this.idprogramada = idprogramada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaProgramacion() {
        return fechaProgramacion;
    }

    public void setFechaProgramacion(Date fechaProgramacion) {
        this.fechaProgramacion = fechaProgramacion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getIsRealizada() {
        return isRealizada;
    }

    public void setIsRealizada(boolean isRealizada) {
        this.isRealizada = isRealizada;
    }

    public Agente getIdagenteProgramacion() {
        return idagenteProgramacion;
    }

    public void setIdagenteProgramacion(Agente idagenteProgramacion) {
        this.idagenteProgramacion = idagenteProgramacion;
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
        hash += (idprogramada != null ? idprogramada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamadaprogramada)) {
            return false;
        }
        Llamadaprogramada other = (Llamadaprogramada) object;
        if ((this.idprogramada == null && other.idprogramada != null) || (this.idprogramada != null && !this.idprogramada.equals(other.idprogramada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Llamadaprogramada[ idprogramada=" + idprogramada + " ]";
    }
    
}
