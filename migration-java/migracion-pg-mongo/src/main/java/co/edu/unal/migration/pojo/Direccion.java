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
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByIddireccion", query = "SELECT d FROM Direccion d WHERE d.iddireccion = :iddireccion")
    , @NamedQuery(name = "Direccion.findByDireccion", query = "SELECT d FROM Direccion d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "Direccion.findByLatitud", query = "SELECT d FROM Direccion d WHERE d.latitud = :latitud")
    , @NamedQuery(name = "Direccion.findByLongitud", query = "SELECT d FROM Direccion d WHERE d.longitud = :longitud")
    , @NamedQuery(name = "Direccion.findByCreatedAt", query = "SELECT d FROM Direccion d WHERE d.createdAt = :createdAt")
    , @NamedQuery(name = "Direccion.findByUpdatedAt", query = "SELECT d FROM Direccion d WHERE d.updatedAt = :updatedAt")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddireccion")
    private Integer iddireccion;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "iddireccionResidencia")
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "idbarrio", referencedColumnName = "idbarrio")
    @ManyToOne
    private Barrio idbarrio;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false)
    private Ciudad idciudad;
    @JoinColumn(name = "idusuario_created", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioCreated;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(mappedBy = "iddireccion")
    private Collection<Clientecorporativo> clientecorporativoCollection;
    @OneToMany(mappedBy = "iddireccion")
    private Collection<Sucursal> sucursalCollection;

    public Direccion() {
    }

    public Direccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Direccion(Integer iddireccion, String direccion, Date createdAt, Date updatedAt) {
        this.iddireccion = iddireccion;
        this.direccion = direccion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
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

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Barrio getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Barrio idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
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
    public Collection<Clientecorporativo> getClientecorporativoCollection() {
        return clientecorporativoCollection;
    }

    public void setClientecorporativoCollection(Collection<Clientecorporativo> clientecorporativoCollection) {
        this.clientecorporativoCollection = clientecorporativoCollection;
    }

    @XmlTransient
    public Collection<Sucursal> getSucursalCollection() {
        return sucursalCollection;
    }

    public void setSucursalCollection(Collection<Sucursal> sucursalCollection) {
        this.sucursalCollection = sucursalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddireccion != null ? iddireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.iddireccion == null && other.iddireccion != null) || (this.iddireccion != null && !this.iddireccion.equals(other.iddireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Direccion[ iddireccion=" + iddireccion + " ]";
    }
    
}
