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
@Table(name = "mod_informe_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModInformeUsuario.findAll", query = "SELECT m FROM ModInformeUsuario m")
    , @NamedQuery(name = "ModInformeUsuario.findByIdiu", query = "SELECT m FROM ModInformeUsuario m WHERE m.idiu = :idiu")
    , @NamedQuery(name = "ModInformeUsuario.findByIdinforme", query = "SELECT m FROM ModInformeUsuario m WHERE m.idinforme = :idinforme")})
public class ModInformeUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idiu")
    private String idiu;
    @Basic(optional = false)
    @Column(name = "idinforme")
    private int idinforme;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public ModInformeUsuario() {
    }

    public ModInformeUsuario(String idiu) {
        this.idiu = idiu;
    }

    public ModInformeUsuario(String idiu, int idinforme) {
        this.idiu = idiu;
        this.idinforme = idinforme;
    }

    public String getIdiu() {
        return idiu;
    }

    public void setIdiu(String idiu) {
        this.idiu = idiu;
    }

    public int getIdinforme() {
        return idinforme;
    }

    public void setIdinforme(int idinforme) {
        this.idinforme = idinforme;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idiu != null ? idiu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModInformeUsuario)) {
            return false;
        }
        ModInformeUsuario other = (ModInformeUsuario) object;
        if ((this.idiu == null && other.idiu != null) || (this.idiu != null && !this.idiu.equals(other.idiu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ModInformeUsuario[ idiu=" + idiu + " ]";
    }
    
}
