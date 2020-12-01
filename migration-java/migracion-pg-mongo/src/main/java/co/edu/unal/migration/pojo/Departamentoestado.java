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
@Table(name = "departamentoestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentoestado.findAll", query = "SELECT d FROM Departamentoestado d")
    , @NamedQuery(name = "Departamentoestado.findByIddepartamento", query = "SELECT d FROM Departamentoestado d WHERE d.iddepartamento = :iddepartamento")
    , @NamedQuery(name = "Departamentoestado.findByCodoficial", query = "SELECT d FROM Departamentoestado d WHERE d.codoficial = :codoficial")
    , @NamedQuery(name = "Departamentoestado.findByNombre", query = "SELECT d FROM Departamentoestado d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Departamentoestado.findByLalitud", query = "SELECT d FROM Departamentoestado d WHERE d.lalitud = :lalitud")
    , @NamedQuery(name = "Departamentoestado.findByLongitud", query = "SELECT d FROM Departamentoestado d WHERE d.longitud = :longitud")
    , @NamedQuery(name = "Departamentoestado.findByTelCodArea", query = "SELECT d FROM Departamentoestado d WHERE d.telCodArea = :telCodArea")})
public class Departamentoestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddepartamento")
    private Integer iddepartamento;
    @Basic(optional = false)
    @Column(name = "codoficial")
    private String codoficial;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lalitud")
    private Double lalitud;
    @Column(name = "longitud")
    private Double longitud;
    @Basic(optional = false)
    @Column(name = "tel_cod_area")
    private int telCodArea;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false)
    private Pais idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepartamento")
    private Collection<Ciudad> ciudadCollection;

    public Departamentoestado() {
    }

    public Departamentoestado(Integer iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public Departamentoestado(Integer iddepartamento, String codoficial, String nombre, int telCodArea) {
        this.iddepartamento = iddepartamento;
        this.codoficial = codoficial;
        this.nombre = nombre;
        this.telCodArea = telCodArea;
    }

    public Integer getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Integer iddepartamento) {
        this.iddepartamento = iddepartamento;
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

    public Double getLalitud() {
        return lalitud;
    }

    public void setLalitud(Double lalitud) {
        this.lalitud = lalitud;
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

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentoestado)) {
            return false;
        }
        Departamentoestado other = (Departamentoestado) object;
        if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Departamentoestado[ iddepartamento=" + iddepartamento + " ]";
    }
    
}
