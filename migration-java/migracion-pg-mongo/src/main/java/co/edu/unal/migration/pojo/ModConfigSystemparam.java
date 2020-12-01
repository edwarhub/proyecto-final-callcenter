/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "mod_config_systemparam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModConfigSystemparam.findAll", query = "SELECT m FROM ModConfigSystemparam m")
    , @NamedQuery(name = "ModConfigSystemparam.findByIdparam", query = "SELECT m FROM ModConfigSystemparam m WHERE m.idparam = :idparam")
    , @NamedQuery(name = "ModConfigSystemparam.findByValue", query = "SELECT m FROM ModConfigSystemparam m WHERE m.value = :value")
    , @NamedQuery(name = "ModConfigSystemparam.findByUpdatedAt", query = "SELECT m FROM ModConfigSystemparam m WHERE m.updatedAt = :updatedAt")})
public class ModConfigSystemparam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idparam")
    private Integer idparam;
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;

    public ModConfigSystemparam() {
    }

    public ModConfigSystemparam(Integer idparam) {
        this.idparam = idparam;
    }

    public ModConfigSystemparam(Integer idparam, Date updatedAt) {
        this.idparam = idparam;
        this.updatedAt = updatedAt;
    }

    public Integer getIdparam() {
        return idparam;
    }

    public void setIdparam(Integer idparam) {
        this.idparam = idparam;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparam != null ? idparam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModConfigSystemparam)) {
            return false;
        }
        ModConfigSystemparam other = (ModConfigSystemparam) object;
        if ((this.idparam == null && other.idparam != null) || (this.idparam != null && !this.idparam.equals(other.idparam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ModConfigSystemparam[ idparam=" + idparam + " ]";
    }
    
}
