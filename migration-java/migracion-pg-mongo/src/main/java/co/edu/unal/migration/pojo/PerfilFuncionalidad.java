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
@Table(name = "perfil_funcionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilFuncionalidad.findAll", query = "SELECT p FROM PerfilFuncionalidad p")
    , @NamedQuery(name = "PerfilFuncionalidad.findByIdpf", query = "SELECT p FROM PerfilFuncionalidad p WHERE p.idpf = :idpf")
    , @NamedQuery(name = "PerfilFuncionalidad.findByIdfuncionalidad", query = "SELECT p FROM PerfilFuncionalidad p WHERE p.idfuncionalidad = :idfuncionalidad")})
public class PerfilFuncionalidad implements Serializable {

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
    private Perfil idperfil;

    public PerfilFuncionalidad() {
    }

    public PerfilFuncionalidad(String idpf) {
        this.idpf = idpf;
    }

    public PerfilFuncionalidad(String idpf, int idfuncionalidad) {
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

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
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
        if (!(object instanceof PerfilFuncionalidad)) {
            return false;
        }
        PerfilFuncionalidad other = (PerfilFuncionalidad) object;
        if ((this.idpf == null && other.idpf != null) || (this.idpf != null && !this.idpf.equals(other.idpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.PerfilFuncionalidad[ idpf=" + idpf + " ]";
    }
    
}
