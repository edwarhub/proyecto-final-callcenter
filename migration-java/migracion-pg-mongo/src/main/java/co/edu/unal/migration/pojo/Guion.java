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
@Table(name = "guion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guion.findAll", query = "SELECT g FROM Guion g")
    , @NamedQuery(name = "Guion.findByIdguion", query = "SELECT g FROM Guion g WHERE g.idguion = :idguion")
    , @NamedQuery(name = "Guion.findByNombre", query = "SELECT g FROM Guion g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Guion.findByGuion", query = "SELECT g FROM Guion g WHERE g.guion = :guion")
    , @NamedQuery(name = "Guion.findByCreatedAt", query = "SELECT g FROM Guion g WHERE g.createdAt = :createdAt")
    , @NamedQuery(name = "Guion.findByUpdatedAt", query = "SELECT g FROM Guion g WHERE g.updatedAt = :updatedAt")})
public class Guion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idguion")
    private Integer idguion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "guion")
    private String guion;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "idusuario_created", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioCreated;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(mappedBy = "idguion")
    private Collection<Campana> campanaCollection;

    public Guion() {
    }

    public Guion(Integer idguion) {
        this.idguion = idguion;
    }

    public Guion(Integer idguion, String nombre, String guion, Date createdAt, Date updatedAt) {
        this.idguion = idguion;
        this.nombre = nombre;
        this.guion = guion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIdguion() {
        return idguion;
    }

    public void setIdguion(Integer idguion) {
        this.idguion = idguion;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Usuario getIdusuarioCreated() {
        return idusuarioCreated;
    }

    public void setIdusuarioCreated(Usuario idusuarioCreated) {
        this.idusuarioCreated = idusuarioCreated;
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
        hash += (idguion != null ? idguion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guion)) {
            return false;
        }
        Guion other = (Guion) object;
        if ((this.idguion == null && other.idguion != null) || (this.idguion != null && !this.idguion.equals(other.idguion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Guion[ idguion=" + idguion + " ]";
    }
    
}
