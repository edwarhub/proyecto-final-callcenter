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
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l")
    , @NamedQuery(name = "Localidad.findByIdlocalidad", query = "SELECT l FROM Localidad l WHERE l.idlocalidad = :idlocalidad")
    , @NamedQuery(name = "Localidad.findByCodoficial", query = "SELECT l FROM Localidad l WHERE l.codoficial = :codoficial")
    , @NamedQuery(name = "Localidad.findByNombre", query = "SELECT l FROM Localidad l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Localidad.findByObservaciones", query = "SELECT l FROM Localidad l WHERE l.observaciones = :observaciones")
    , @NamedQuery(name = "Localidad.findByLatitud", query = "SELECT l FROM Localidad l WHERE l.latitud = :latitud")
    , @NamedQuery(name = "Localidad.findByLongitud", query = "SELECT l FROM Localidad l WHERE l.longitud = :longitud")})
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocalidad")
    private Integer idlocalidad;
    @Column(name = "codoficial")
    private String codoficial;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false)
    private Ciudad idciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlocalidad")
    private Collection<Barrio> barrioCollection;

    public Localidad() {
    }

    public Localidad(Integer idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public Localidad(Integer idlocalidad, String nombre) {
        this.idlocalidad = idlocalidad;
        this.nombre = nombre;
    }

    public Integer getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Integer idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getCodoficial() {
        return codoficial;
    }

    public void setCodoficial(String codoficial) {
        this.codoficial = codoficial;
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

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    @XmlTransient
    public Collection<Barrio> getBarrioCollection() {
        return barrioCollection;
    }

    public void setBarrioCollection(Collection<Barrio> barrioCollection) {
        this.barrioCollection = barrioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocalidad != null ? idlocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.idlocalidad == null && other.idlocalidad != null) || (this.idlocalidad != null && !this.idlocalidad.equals(other.idlocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Localidad[ idlocalidad=" + idlocalidad + " ]";
    }
    
}
