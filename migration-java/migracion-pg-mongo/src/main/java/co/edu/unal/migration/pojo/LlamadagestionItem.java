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
@Table(name = "llamadagestion_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlamadagestionItem.findAll", query = "SELECT l FROM LlamadagestionItem l")
    , @NamedQuery(name = "LlamadagestionItem.findByIditem", query = "SELECT l FROM LlamadagestionItem l WHERE l.iditem = :iditem")
    , @NamedQuery(name = "LlamadagestionItem.findByGestion", query = "SELECT l FROM LlamadagestionItem l WHERE l.gestion = :gestion")
    , @NamedQuery(name = "LlamadagestionItem.findByCreatedAt", query = "SELECT l FROM LlamadagestionItem l WHERE l.createdAt = :createdAt")})
public class LlamadagestionItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iditem")
    private String iditem;
    @Basic(optional = false)
    @Column(name = "gestion")
    private String gestion;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "idcampo", referencedColumnName = "idcampo")
    @ManyToOne(optional = false)
    private Campanacampo idcampo;
    @JoinColumn(name = "idgestion", referencedColumnName = "idgestion")
    @ManyToOne(optional = false)
    private Llamadagestion idgestion;

    public LlamadagestionItem() {
    }

    public LlamadagestionItem(String iditem) {
        this.iditem = iditem;
    }

    public LlamadagestionItem(String iditem, String gestion, Date createdAt) {
        this.iditem = iditem;
        this.gestion = gestion;
        this.createdAt = createdAt;
    }

    public String getIditem() {
        return iditem;
    }

    public void setIditem(String iditem) {
        this.iditem = iditem;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Campanacampo getIdcampo() {
        return idcampo;
    }

    public void setIdcampo(Campanacampo idcampo) {
        this.idcampo = idcampo;
    }

    public Llamadagestion getIdgestion() {
        return idgestion;
    }

    public void setIdgestion(Llamadagestion idgestion) {
        this.idgestion = idgestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlamadagestionItem)) {
            return false;
        }
        LlamadagestionItem other = (LlamadagestionItem) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.LlamadagestionItem[ iditem=" + iditem + " ]";
    }
    
}
