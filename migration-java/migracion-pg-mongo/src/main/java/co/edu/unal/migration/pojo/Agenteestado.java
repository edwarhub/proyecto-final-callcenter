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
@Table(name = "agenteestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenteestado.findAll", query = "SELECT a FROM Agenteestado a")
    , @NamedQuery(name = "Agenteestado.findByIdestado", query = "SELECT a FROM Agenteestado a WHERE a.idestado = :idestado")
    , @NamedQuery(name = "Agenteestado.findByNombre", query = "SELECT a FROM Agenteestado a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Agenteestado.findByUpdatedAt", query = "SELECT a FROM Agenteestado a WHERE a.updatedAt = :updatedAt")
    , @NamedQuery(name = "Agenteestado.findByObservaciones", query = "SELECT a FROM Agenteestado a WHERE a.observaciones = :observaciones")
    , @NamedQuery(name = "Agenteestado.findByPathIcono", query = "SELECT a FROM Agenteestado a WHERE a.pathIcono = :pathIcono")})
public class Agenteestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado")
    private Integer idestado;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "path_icono")
    private String pathIcono;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoActual")
    private Collection<Agenteestadocambio> agenteestadocambioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoAnterior")
    private Collection<Agenteestadocambio> agenteestadocambioCollection1;

    public Agenteestado() {
    }

    public Agenteestado(Integer idestado) {
        this.idestado = idestado;
    }

    public Agenteestado(Integer idestado, String nombre, Date updatedAt) {
        this.idestado = idestado;
        this.nombre = nombre;
        this.updatedAt = updatedAt;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPathIcono() {
        return pathIcono;
    }

    public void setPathIcono(String pathIcono) {
        this.pathIcono = pathIcono;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<Agenteestadocambio> getAgenteestadocambioCollection() {
        return agenteestadocambioCollection;
    }

    public void setAgenteestadocambioCollection(Collection<Agenteestadocambio> agenteestadocambioCollection) {
        this.agenteestadocambioCollection = agenteestadocambioCollection;
    }

    @XmlTransient
    public Collection<Agenteestadocambio> getAgenteestadocambioCollection1() {
        return agenteestadocambioCollection1;
    }

    public void setAgenteestadocambioCollection1(Collection<Agenteestadocambio> agenteestadocambioCollection1) {
        this.agenteestadocambioCollection1 = agenteestadocambioCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenteestado)) {
            return false;
        }
        Agenteestado other = (Agenteestado) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Agenteestado[ idestado=" + idestado + " ]";
    }
    
}
