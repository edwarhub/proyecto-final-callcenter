/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b")
    , @NamedQuery(name = "Barrio.findByIdbarrio", query = "SELECT b FROM Barrio b WHERE b.idbarrio = :idbarrio")
    , @NamedQuery(name = "Barrio.findByCodoficial", query = "SELECT b FROM Barrio b WHERE b.codoficial = :codoficial")
    , @NamedQuery(name = "Barrio.findByNombre", query = "SELECT b FROM Barrio b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "Barrio.findByObservaciones", query = "SELECT b FROM Barrio b WHERE b.observaciones = :observaciones")
    , @NamedQuery(name = "Barrio.findByLatitud", query = "SELECT b FROM Barrio b WHERE b.latitud = :latitud")
    , @NamedQuery(name = "Barrio.findByLongitud", query = "SELECT b FROM Barrio b WHERE b.longitud = :longitud")})
public class Barrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbarrio")
    private Integer idbarrio;
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
    @OneToMany(mappedBy = "idbarrio")
    private Collection<Direccion> direccionCollection;
    @JoinColumn(name = "idlocalidad", referencedColumnName = "idlocalidad")
    @ManyToOne(optional = false)
    private Localidad idlocalidad;

    public Barrio() {
    }

    public Barrio(Integer idbarrio) {
        this.idbarrio = idbarrio;
    }

    public Barrio(Integer idbarrio, String nombre) {
        this.idbarrio = idbarrio;
        this.nombre = nombre;
    }

    public Integer getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(Integer idbarrio) {
        this.idbarrio = idbarrio;
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

    @XmlTransient
    public Collection<Direccion> getDireccionCollection() {
        return direccionCollection;
    }

    public void setDireccionCollection(Collection<Direccion> direccionCollection) {
        this.direccionCollection = direccionCollection;
    }

    public Localidad getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Localidad idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbarrio != null ? idbarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.idbarrio == null && other.idbarrio != null) || (this.idbarrio != null && !this.idbarrio.equals(other.idbarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Barrio[ idbarrio=" + idbarrio + " ]";
    }
    
}
