/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "mod_seguridad_perfil_funcionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModSeguridadPerfilFuncionalidad.findAll", query = "SELECT m FROM ModSeguridadPerfilFuncionalidad m")
    , @NamedQuery(name = "ModSeguridadPerfilFuncionalidad.findByIdpf", query = "SELECT m FROM ModSeguridadPerfilFuncionalidad m WHERE m.idpf = :idpf")
    , @NamedQuery(name = "ModSeguridadPerfilFuncionalidad.findByIdfuncionalidad", query = "SELECT m FROM ModSeguridadPerfilFuncionalidad m WHERE m.idfuncionalidad = :idfuncionalidad")})
public class ModSeguridadPerfilFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpf")
    private String idpf;
    @Basic(optional = false)
    @Column(name = "idfuncionalidad")
    private int idfuncionalidad;
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    @ManyToOne(optional = false)
    private ModSeguridadPerfil idperfil;

    public ModSeguridadPerfilFuncionalidad() {
    }

    public ModSeguridadPerfilFuncionalidad(String idpf) {
        this.idpf = idpf;
    }

    public ModSeguridadPerfilFuncionalidad(String idpf, int idfuncionalidad) {
        this.idpf = idpf;
        this.idfuncionalidad = idfuncionalidad;
    }

    public String getIdpf() {
        return idpf;
    }

    public void setIdpf(String idpf) {
        this.idpf = idpf;
    }

    public int getIdfuncionalidad() {
        return idfuncionalidad;
    }

    public void setIdfuncionalidad(int idfuncionalidad) {
        this.idfuncionalidad = idfuncionalidad;
    }

    public ModSeguridadPerfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(ModSeguridadPerfil idperfil) {
        this.idperfil = idperfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpf != null ? idpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModSeguridadPerfilFuncionalidad)) {
            return false;
        }
        ModSeguridadPerfilFuncionalidad other = (ModSeguridadPerfilFuncionalidad) object;
        if ((this.idpf == null && other.idpf != null) || (this.idpf != null && !this.idpf.equals(other.idpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ModSeguridadPerfilFuncionalidad[ idpf=" + idpf + " ]";
    }
    
}
