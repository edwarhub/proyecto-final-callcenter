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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdciudad", query = "SELECT c FROM Ciudad c WHERE c.idciudad = :idciudad")
    , @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Ciudad.findByCodoficial", query = "SELECT c FROM Ciudad c WHERE c.codoficial = :codoficial")
    , @NamedQuery(name = "Ciudad.findByLatitud", query = "SELECT c FROM Ciudad c WHERE c.latitud = :latitud")
    , @NamedQuery(name = "Ciudad.findByLongitud", query = "SELECT c FROM Ciudad c WHERE c.longitud = :longitud")
    , @NamedQuery(name = "Ciudad.findByTelCodArea", query = "SELECT c FROM Ciudad c WHERE c.telCodArea = :telCodArea")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idciudad")
    private Integer idciudad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codoficial")
    private String codoficial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "tel_cod_area")
    private Integer telCodArea;
    @OneToMany(mappedBy = "idciudad")
    private Collection<Telefono> telefonoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idciudad")
    private Collection<Direccion> direccionCollection;
    @JoinColumn(name = "iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne(optional = false)
    private Departamentoestado iddepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idciudad")
    private Collection<Localidad> localidadCollection;

    public Ciudad() {
    }

    public Ciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }

    public Ciudad(Integer idciudad, String nombre) {
        this.idciudad = idciudad;
        this.nombre = nombre;
    }

    public Integer getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodoficial() {
        return codoficial;
    }

    public void setCodoficial(String codoficial) {
        this.codoficial = codoficial;
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

    public Integer getTelCodArea() {
        return telCodArea;
    }

    public void setTelCodArea(Integer telCodArea) {
        this.telCodArea = telCodArea;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection() {
        return telefonoCollection;
    }

    public void setTelefonoCollection(Collection<Telefono> telefonoCollection) {
        this.telefonoCollection = telefonoCollection;
    }

    @XmlTransient
    public Collection<Direccion> getDireccionCollection() {
        return direccionCollection;
    }

    public void setDireccionCollection(Collection<Direccion> direccionCollection) {
        this.direccionCollection = direccionCollection;
    }

    public Departamentoestado getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Departamentoestado iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @XmlTransient
    public Collection<Localidad> getLocalidadCollection() {
        return localidadCollection;
    }

    public void setLocalidadCollection(Collection<Localidad> localidadCollection) {
        this.localidadCollection = localidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idciudad != null ? idciudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idciudad == null && other.idciudad != null) || (this.idciudad != null && !this.idciudad.equals(other.idciudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Ciudad[ idciudad=" + idciudad + " ]";
    }
    
}
