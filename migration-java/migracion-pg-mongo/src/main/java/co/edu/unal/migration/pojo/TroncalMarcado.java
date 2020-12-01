/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "troncal_marcado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TroncalMarcado.findAll", query = "SELECT t FROM TroncalMarcado t")
    , @NamedQuery(name = "TroncalMarcado.findByIdregla", query = "SELECT t FROM TroncalMarcado t WHERE t.idregla = :idregla")
    , @NamedQuery(name = "TroncalMarcado.findByUpdatedAt", query = "SELECT t FROM TroncalMarcado t WHERE t.updatedAt = :updatedAt")
    , @NamedQuery(name = "TroncalMarcado.findByReglaMarcadoTel", query = "SELECT t FROM TroncalMarcado t WHERE t.reglaMarcadoTel = :reglaMarcadoTel")
    , @NamedQuery(name = "TroncalMarcado.findByReglaMarcadoPrefijo", query = "SELECT t FROM TroncalMarcado t WHERE t.reglaMarcadoPrefijo = :reglaMarcadoPrefijo")
    , @NamedQuery(name = "TroncalMarcado.findByIncluirPrefijoMarcado", query = "SELECT t FROM TroncalMarcado t WHERE t.incluirPrefijoMarcado = :incluirPrefijoMarcado")})
public class TroncalMarcado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregla")
    private Integer idregla;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "regla_marcado_tel")
    private String reglaMarcadoTel;
    @Column(name = "regla_marcado_prefijo")
    private String reglaMarcadoPrefijo;
    @Basic(optional = false)
    @Column(name = "incluir_prefijo_marcado")
    private boolean incluirPrefijoMarcado;
    @JoinColumn(name = "idtroncal", referencedColumnName = "idtroncal")
    @ManyToOne(optional = false)
    private Troncal idtroncal;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(mappedBy = "marcadoIdreglaCel")
    private Collection<Campana> campanaCollection;
    @OneToMany(mappedBy = "marcadoIdreglaFijo")
    private Collection<Campana> campanaCollection1;
    @OneToMany(mappedBy = "marcadoIdreglaFijoNal")
    private Collection<Campana> campanaCollection2;

    public TroncalMarcado() {
    }

    public TroncalMarcado(Integer idregla) {
        this.idregla = idregla;
    }

    public TroncalMarcado(Integer idregla, Date updatedAt, String reglaMarcadoTel, boolean incluirPrefijoMarcado) {
        this.idregla = idregla;
        this.updatedAt = updatedAt;
        this.reglaMarcadoTel = reglaMarcadoTel;
        this.incluirPrefijoMarcado = incluirPrefijoMarcado;
    }

    public Integer getIdregla() {
        return idregla;
    }

    public void setIdregla(Integer idregla) {
        this.idregla = idregla;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getReglaMarcadoTel() {
        return reglaMarcadoTel;
    }

    public void setReglaMarcadoTel(String reglaMarcadoTel) {
        this.reglaMarcadoTel = reglaMarcadoTel;
    }

    public String getReglaMarcadoPrefijo() {
        return reglaMarcadoPrefijo;
    }

    public void setReglaMarcadoPrefijo(String reglaMarcadoPrefijo) {
        this.reglaMarcadoPrefijo = reglaMarcadoPrefijo;
    }

    public boolean getIncluirPrefijoMarcado() {
        return incluirPrefijoMarcado;
    }

    public void setIncluirPrefijoMarcado(boolean incluirPrefijoMarcado) {
        this.incluirPrefijoMarcado = incluirPrefijoMarcado;
    }

    public Troncal getIdtroncal() {
        return idtroncal;
    }

    public void setIdtroncal(Troncal idtroncal) {
        this.idtroncal = idtroncal;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection() {
        return campanaCollection;
    }

    public void setCampanaCollection(Collection<Campana> campanaCollection) {
        this.campanaCollection = campanaCollection;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection1() {
        return campanaCollection1;
    }

    public void setCampanaCollection1(Collection<Campana> campanaCollection1) {
        this.campanaCollection1 = campanaCollection1;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection2() {
        return campanaCollection2;
    }

    public void setCampanaCollection2(Collection<Campana> campanaCollection2) {
        this.campanaCollection2 = campanaCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregla != null ? idregla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TroncalMarcado)) {
            return false;
        }
        TroncalMarcado other = (TroncalMarcado) object;
        if ((this.idregla == null && other.idregla != null) || (this.idregla != null && !this.idregla.equals(other.idregla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.TroncalMarcado[ idregla=" + idregla + " ]";
    }
    
}
