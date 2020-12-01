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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "campanacampo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campanacampo.findAll", query = "SELECT c FROM Campanacampo c")
    , @NamedQuery(name = "Campanacampo.findByIdcampo", query = "SELECT c FROM Campanacampo c WHERE c.idcampo = :idcampo")
    , @NamedQuery(name = "Campanacampo.findByNombre", query = "SELECT c FROM Campanacampo c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Campanacampo.findByTipo", query = "SELECT c FROM Campanacampo c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Campanacampo.findByObservaciones", query = "SELECT c FROM Campanacampo c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "Campanacampo.findByIsObligatorio", query = "SELECT c FROM Campanacampo c WHERE c.isObligatorio = :isObligatorio")
    , @NamedQuery(name = "Campanacampo.findByUpdatedAt", query = "SELECT c FROM Campanacampo c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Campanacampo.findByOrden", query = "SELECT c FROM Campanacampo c WHERE c.orden = :orden")})
public class Campanacampo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcampo")
    private Integer idcampo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "is_obligatorio")
    private boolean isObligatorio;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "orden")
    private int orden;
    @JoinColumn(name = "idcampana", referencedColumnName = "idcampana")
    @ManyToOne(optional = false)
    private Campana idcampana;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampo")
    private Collection<LlamadagestionItem> llamadagestionItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampo")
    private Collection<CampanacampoOpcion> campanacampoOpcionCollection;

    public Campanacampo() {
    }

    public Campanacampo(Integer idcampo) {
        this.idcampo = idcampo;
    }

    public Campanacampo(Integer idcampo, String nombre, String tipo, boolean isObligatorio, Date updatedAt, int orden) {
        this.idcampo = idcampo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.isObligatorio = isObligatorio;
        this.updatedAt = updatedAt;
        this.orden = orden;
    }

    public Integer getIdcampo() {
        return idcampo;
    }

    public void setIdcampo(Integer idcampo) {
        this.idcampo = idcampo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getIsObligatorio() {
        return isObligatorio;
    }

    public void setIsObligatorio(boolean isObligatorio) {
        this.isObligatorio = isObligatorio;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Campana getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(Campana idcampana) {
        this.idcampana = idcampana;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<LlamadagestionItem> getLlamadagestionItemCollection() {
        return llamadagestionItemCollection;
    }

    public void setLlamadagestionItemCollection(Collection<LlamadagestionItem> llamadagestionItemCollection) {
        this.llamadagestionItemCollection = llamadagestionItemCollection;
    }

    @XmlTransient
    public Collection<CampanacampoOpcion> getCampanacampoOpcionCollection() {
        return campanacampoOpcionCollection;
    }

    public void setCampanacampoOpcionCollection(Collection<CampanacampoOpcion> campanacampoOpcionCollection) {
        this.campanacampoOpcionCollection = campanacampoOpcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampo != null ? idcampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campanacampo)) {
            return false;
        }
        Campanacampo other = (Campanacampo) object;
        if ((this.idcampo == null && other.idcampo != null) || (this.idcampo != null && !this.idcampo.equals(other.idcampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Campanacampo[ idcampo=" + idcampo + " ]";
    }
    
}
