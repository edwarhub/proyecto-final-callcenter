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
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByIdsucursal", query = "SELECT s FROM Sucursal s WHERE s.idsucursal = :idsucursal")
    , @NamedQuery(name = "Sucursal.findByNombre", query = "SELECT s FROM Sucursal s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Sucursal.findByUpdatedAt", query = "SELECT s FROM Sucursal s WHERE s.updatedAt = :updatedAt")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsucursal")
    private Integer idsucursal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsucursal")
    private Collection<Agente> agenteCollection;
    @JoinColumn(name = "iddireccion", referencedColumnName = "iddireccion")
    @ManyToOne
    private Direccion iddireccion;
    @JoinColumn(name = "idtelefono1", referencedColumnName = "idtelefono")
    @ManyToOne(optional = false)
    private Telefono idtelefono1;
    @JoinColumn(name = "idtelefono2", referencedColumnName = "idtelefono")
    @ManyToOne
    private Telefono idtelefono2;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;

    public Sucursal() {
    }

    public Sucursal(Integer idsucursal) {
        this.idsucursal = idsucursal;
    }

    public Sucursal(Integer idsucursal, String nombre, Date updatedAt) {
        this.idsucursal = idsucursal;
        this.nombre = nombre;
        this.updatedAt = updatedAt;
    }

    public Integer getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Integer idsucursal) {
        this.idsucursal = idsucursal;
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

    @XmlTransient
    public Collection<Agente> getAgenteCollection() {
        return agenteCollection;
    }

    public void setAgenteCollection(Collection<Agente> agenteCollection) {
        this.agenteCollection = agenteCollection;
    }

    public Direccion getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Direccion iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Telefono getIdtelefono1() {
        return idtelefono1;
    }

    public void setIdtelefono1(Telefono idtelefono1) {
        this.idtelefono1 = idtelefono1;
    }

    public Telefono getIdtelefono2() {
        return idtelefono2;
    }

    public void setIdtelefono2(Telefono idtelefono2) {
        this.idtelefono2 = idtelefono2;
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
        hash += (idsucursal != null ? idsucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idsucursal == null && other.idsucursal != null) || (this.idsucursal != null && !this.idsucursal.equals(other.idsucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Sucursal[ idsucursal=" + idsucursal + " ]";
    }
    
}
