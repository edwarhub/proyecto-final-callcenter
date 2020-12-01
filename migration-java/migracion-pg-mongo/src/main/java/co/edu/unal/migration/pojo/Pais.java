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
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
    , @NamedQuery(name = "Pais.findByIdpais", query = "SELECT p FROM Pais p WHERE p.idpais = :idpais")
    , @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pais.findByCodOficialIso", query = "SELECT p FROM Pais p WHERE p.codOficialIso = :codOficialIso")
    , @NamedQuery(name = "Pais.findByIso2", query = "SELECT p FROM Pais p WHERE p.iso2 = :iso2")
    , @NamedQuery(name = "Pais.findByIso3", query = "SELECT p FROM Pais p WHERE p.iso3 = :iso3")
    , @NamedQuery(name = "Pais.findByLatitud", query = "SELECT p FROM Pais p WHERE p.latitud = :latitud")
    , @NamedQuery(name = "Pais.findByLongitud", query = "SELECT p FROM Pais p WHERE p.longitud = :longitud")
    , @NamedQuery(name = "Pais.findByTelCodArea", query = "SELECT p FROM Pais p WHERE p.telCodArea = :telCodArea")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpais")
    private Integer idpais;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cod_oficial_iso")
    private String codOficialIso;
    @Column(name = "iso2")
    private String iso2;
    @Column(name = "iso3")
    private String iso3;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
    @Basic(optional = false)
    @Column(name = "tel_cod_area")
    private int telCodArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpais")
    private Collection<Departamentoestado> departamentoestadoCollection;
    @OneToMany(mappedBy = "idpais")
    private Collection<Telefono> telefonoCollection;

    public Pais() {
    }

    public Pais(Integer idpais) {
        this.idpais = idpais;
    }

    public Pais(Integer idpais, String nombre, int telCodArea) {
        this.idpais = idpais;
        this.nombre = nombre;
        this.telCodArea = telCodArea;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodOficialIso() {
        return codOficialIso;
    }

    public void setCodOficialIso(String codOficialIso) {
        this.codOficialIso = codOficialIso;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
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

    public int getTelCodArea() {
        return telCodArea;
    }

    public void setTelCodArea(int telCodArea) {
        this.telCodArea = telCodArea;
    }

    @XmlTransient
    public Collection<Departamentoestado> getDepartamentoestadoCollection() {
        return departamentoestadoCollection;
    }

    public void setDepartamentoestadoCollection(Collection<Departamentoestado> departamentoestadoCollection) {
        this.departamentoestadoCollection = departamentoestadoCollection;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection() {
        return telefonoCollection;
    }

    public void setTelefonoCollection(Collection<Telefono> telefonoCollection) {
        this.telefonoCollection = telefonoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Pais[ idpais=" + idpais + " ]";
    }
    
}
