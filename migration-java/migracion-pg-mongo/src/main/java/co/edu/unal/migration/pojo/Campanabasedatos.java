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
@Table(name = "campanabasedatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campanabasedatos.findAll", query = "SELECT c FROM Campanabasedatos c")
    , @NamedQuery(name = "Campanabasedatos.findByIdbd", query = "SELECT c FROM Campanabasedatos c WHERE c.idbd = :idbd")
    , @NamedQuery(name = "Campanabasedatos.findByNombre", query = "SELECT c FROM Campanabasedatos c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Campanabasedatos.findByObservaciones", query = "SELECT c FROM Campanabasedatos c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "Campanabasedatos.findByCreatedAt", query = "SELECT c FROM Campanabasedatos c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Campanabasedatos.findByReparticion", query = "SELECT c FROM Campanabasedatos c WHERE c.reparticion = :reparticion")})
public class Campanabasedatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbd")
    private Long idbd;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "reparticion")
    private String reparticion;
    @JoinColumn(name = "idcampana", referencedColumnName = "idcampana")
    @ManyToOne(optional = false)
    private Campana idcampana;
    @JoinColumn(name = "idusuario_created", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioCreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbd")
    private Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection;

    public Campanabasedatos() {
    }

    public Campanabasedatos(Long idbd) {
        this.idbd = idbd;
    }

    public Campanabasedatos(Long idbd, String nombre, Date createdAt, String reparticion) {
        this.idbd = idbd;
        this.nombre = nombre;
        this.createdAt = createdAt;
        this.reparticion = reparticion;
    }

    public Long getIdbd() {
        return idbd;
    }

    public void setIdbd(Long idbd) {
        this.idbd = idbd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getReparticion() {
        return reparticion;
    }

    public void setReparticion(String reparticion) {
        this.reparticion = reparticion;
    }

    public Campana getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(Campana idcampana) {
        this.idcampana = idcampana;
    }

    public Usuario getIdusuarioCreated() {
        return idusuarioCreated;
    }

    public void setIdusuarioCreated(Usuario idusuarioCreated) {
        this.idusuarioCreated = idusuarioCreated;
    }

    @XmlTransient
    public Collection<CampanabasedatosHasPersona> getCampanabasedatosHasPersonaCollection() {
        return campanabasedatosHasPersonaCollection;
    }

    public void setCampanabasedatosHasPersonaCollection(Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection) {
        this.campanabasedatosHasPersonaCollection = campanabasedatosHasPersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbd != null ? idbd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campanabasedatos)) {
            return false;
        }
        Campanabasedatos other = (Campanabasedatos) object;
        if ((this.idbd == null && other.idbd != null) || (this.idbd != null && !this.idbd.equals(other.idbd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Campanabasedatos[ idbd=" + idbd + " ]";
    }
    
}
