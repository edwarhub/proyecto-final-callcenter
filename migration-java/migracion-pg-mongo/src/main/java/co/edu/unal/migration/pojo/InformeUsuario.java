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
@Table(name = "informe_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformeUsuario.findAll", query = "SELECT i FROM InformeUsuario i")
    , @NamedQuery(name = "InformeUsuario.findByIdiu", query = "SELECT i FROM InformeUsuario i WHERE i.idiu = :idiu")
    , @NamedQuery(name = "InformeUsuario.findByInformeId", query = "SELECT i FROM InformeUsuario i WHERE i.informeId = :informeId")})
public class InformeUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idiu")
    private String idiu;
    @Basic(optional = false)
    @Column(name = "informe_id")
    private int informeId;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public InformeUsuario() {
    }

    public InformeUsuario(String idiu) {
        this.idiu = idiu;
    }

    public InformeUsuario(String idiu, int informeId) {
        this.idiu = idiu;
        this.informeId = informeId;
    }

    public String getIdiu() {
        return idiu;
    }

    public void setIdiu(String idiu) {
        this.idiu = idiu;
    }

    public int getInformeId() {
        return informeId;
    }

    public void setInformeId(int informeId) {
        this.informeId = informeId;
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
        if (!(object instanceof InformeUsuario)) {
            return false;
        }
        InformeUsuario other = (InformeUsuario) object;
        if ((this.idiu == null && other.idiu != null) || (this.idiu != null && !this.idiu.equals(other.idiu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.InformeUsuario[ idiu=" + idiu + " ]";
    }
    
}
