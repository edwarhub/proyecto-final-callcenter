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
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByIdperfil", query = "SELECT p FROM Perfil p WHERE p.idperfil = :idperfil")
    , @NamedQuery(name = "Perfil.findByNombre", query = "SELECT p FROM Perfil p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Perfil.findByIcono", query = "SELECT p FROM Perfil p WHERE p.icono = :icono")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperfil")
    private Integer idperfil;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "icono")
    private String icono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperfil")
    private Collection<PerfilFuncionalidad> perfilFuncionalidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperfil")
    private Collection<PerfilHasUsuario> perfilHasUsuarioCollection;

    public Perfil() {
    }

    public Perfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public Perfil(Integer idperfil, String nombre) {
        this.idperfil = idperfil;
        this.nombre = nombre;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @XmlTransient
    public Collection<PerfilFuncionalidad> getPerfilFuncionalidadCollection() {
        return perfilFuncionalidadCollection;
    }

    public void setPerfilFuncionalidadCollection(Collection<PerfilFuncionalidad> perfilFuncionalidadCollection) {
        this.perfilFuncionalidadCollection = perfilFuncionalidadCollection;
    }

    @XmlTransient
    public Collection<PerfilHasUsuario> getPerfilHasUsuarioCollection() {
        return perfilHasUsuarioCollection;
    }

    public void setPerfilHasUsuarioCollection(Collection<PerfilHasUsuario> perfilHasUsuarioCollection) {
        this.perfilHasUsuarioCollection = perfilHasUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Perfil[ idperfil=" + idperfil + " ]";
    }
    
}
