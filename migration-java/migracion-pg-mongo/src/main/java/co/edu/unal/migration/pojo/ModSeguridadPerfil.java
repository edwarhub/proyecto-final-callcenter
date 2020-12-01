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
@Table(name = "mod_seguridad_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModSeguridadPerfil.findAll", query = "SELECT m FROM ModSeguridadPerfil m")
    , @NamedQuery(name = "ModSeguridadPerfil.findByIdperfil", query = "SELECT m FROM ModSeguridadPerfil m WHERE m.idperfil = :idperfil")
    , @NamedQuery(name = "ModSeguridadPerfil.findByNombre", query = "SELECT m FROM ModSeguridadPerfil m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "ModSeguridadPerfil.findByIcono", query = "SELECT m FROM ModSeguridadPerfil m WHERE m.icono = :icono")})
public class ModSeguridadPerfil implements Serializable {

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
    private Collection<ModSeguridadPerfilFuncionalidad> modSeguridadPerfilFuncionalidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperfil")
    private Collection<ModSeguridadPerfilHasUsuario> modSeguridadPerfilHasUsuarioCollection;

    public ModSeguridadPerfil() {
    }

    public ModSeguridadPerfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public ModSeguridadPerfil(Integer idperfil, String nombre) {
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
    public Collection<ModSeguridadPerfilFuncionalidad> getModSeguridadPerfilFuncionalidadCollection() {
        return modSeguridadPerfilFuncionalidadCollection;
    }

    public void setModSeguridadPerfilFuncionalidadCollection(Collection<ModSeguridadPerfilFuncionalidad> modSeguridadPerfilFuncionalidadCollection) {
        this.modSeguridadPerfilFuncionalidadCollection = modSeguridadPerfilFuncionalidadCollection;
    }

    @XmlTransient
    public Collection<ModSeguridadPerfilHasUsuario> getModSeguridadPerfilHasUsuarioCollection() {
        return modSeguridadPerfilHasUsuarioCollection;
    }

    public void setModSeguridadPerfilHasUsuarioCollection(Collection<ModSeguridadPerfilHasUsuario> modSeguridadPerfilHasUsuarioCollection) {
        this.modSeguridadPerfilHasUsuarioCollection = modSeguridadPerfilHasUsuarioCollection;
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
        if (!(object instanceof ModSeguridadPerfil)) {
            return false;
        }
        ModSeguridadPerfil other = (ModSeguridadPerfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ModSeguridadPerfil[ idperfil=" + idperfil + " ]";
    }
    
}
