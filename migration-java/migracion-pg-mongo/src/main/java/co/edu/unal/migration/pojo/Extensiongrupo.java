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
@Table(name = "extensiongrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extensiongrupo.findAll", query = "SELECT e FROM Extensiongrupo e")
    , @NamedQuery(name = "Extensiongrupo.findByIdgrupo", query = "SELECT e FROM Extensiongrupo e WHERE e.idgrupo = :idgrupo")
    , @NamedQuery(name = "Extensiongrupo.findByNombre", query = "SELECT e FROM Extensiongrupo e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Extensiongrupo.findByObservaciones", query = "SELECT e FROM Extensiongrupo e WHERE e.observaciones = :observaciones")
    , @NamedQuery(name = "Extensiongrupo.findByUpdatedAt", query = "SELECT e FROM Extensiongrupo e WHERE e.updatedAt = :updatedAt")
    , @NamedQuery(name = "Extensiongrupo.findByGrabarLlamadas", query = "SELECT e FROM Extensiongrupo e WHERE e.grabarLlamadas = :grabarLlamadas")})
public class Extensiongrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupo")
    private Integer idgrupo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "grabar_llamadas")
    private boolean grabarLlamadas;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrupo")
    private Collection<Extension> extensionCollection;

    public Extensiongrupo() {
    }

    public Extensiongrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Extensiongrupo(Integer idgrupo, String nombre, Date updatedAt, boolean grabarLlamadas) {
        this.idgrupo = idgrupo;
        this.nombre = nombre;
        this.updatedAt = updatedAt;
        this.grabarLlamadas = grabarLlamadas;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getGrabarLlamadas() {
        return grabarLlamadas;
    }

    public void setGrabarLlamadas(boolean grabarLlamadas) {
        this.grabarLlamadas = grabarLlamadas;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<Extension> getExtensionCollection() {
        return extensionCollection;
    }

    public void setExtensionCollection(Collection<Extension> extensionCollection) {
        this.extensionCollection = extensionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupo != null ? idgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extensiongrupo)) {
            return false;
        }
        Extensiongrupo other = (Extensiongrupo) object;
        if ((this.idgrupo == null && other.idgrupo != null) || (this.idgrupo != null && !this.idgrupo.equals(other.idgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Extensiongrupo[ idgrupo=" + idgrupo + " ]";
    }
    
}
