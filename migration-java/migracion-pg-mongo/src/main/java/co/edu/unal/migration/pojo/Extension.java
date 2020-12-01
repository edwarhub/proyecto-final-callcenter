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
@Table(name = "extension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extension.findAll", query = "SELECT e FROM Extension e")
    , @NamedQuery(name = "Extension.findByIdextension", query = "SELECT e FROM Extension e WHERE e.idextension = :idextension")
    , @NamedQuery(name = "Extension.findByNumero", query = "SELECT e FROM Extension e WHERE e.numero = :numero")
    , @NamedQuery(name = "Extension.findByObservaciones", query = "SELECT e FROM Extension e WHERE e.observaciones = :observaciones")
    , @NamedQuery(name = "Extension.findByUpdatedAt", query = "SELECT e FROM Extension e WHERE e.updatedAt = :updatedAt")
    , @NamedQuery(name = "Extension.findByContrasena", query = "SELECT e FROM Extension e WHERE e.contrasena = :contrasena")
    , @NamedQuery(name = "Extension.findByCorreovozActivo", query = "SELECT e FROM Extension e WHERE e.correovozActivo = :correovozActivo")
    , @NamedQuery(name = "Extension.findByIsSoftphone", query = "SELECT e FROM Extension e WHERE e.isSoftphone = :isSoftphone")})
public class Extension implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idextension")
    private Integer idextension;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "correovoz_activo")
    private boolean correovozActivo;
    @Basic(optional = false)
    @Column(name = "is_softphone")
    private boolean isSoftphone;
    @OneToMany(mappedBy = "idextension")
    private Collection<Persona> personaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idextension")
    private Collection<TroncalLinea> troncalLineaCollection;
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    @ManyToOne(optional = false)
    private Extensiongrupo idgrupo;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idextension")
    private Collection<Cola> colaCollection;
    @OneToMany(mappedBy = "accIdextension")
    private Collection<IvrOpcion> ivrOpcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idextension")
    private Collection<Ivr> ivrCollection;
    @OneToMany(mappedBy = "idextensionTimeout")
    private Collection<Ivr> ivrCollection1;
    @OneToMany(mappedBy = "marcadorAccIdextension")
    private Collection<Campana> campanaCollection;

    public Extension() {
    }

    public Extension(Integer idextension) {
        this.idextension = idextension;
    }

    public Extension(Integer idextension, String numero, Date updatedAt, boolean correovozActivo, boolean isSoftphone) {
        this.idextension = idextension;
        this.numero = numero;
        this.updatedAt = updatedAt;
        this.correovozActivo = correovozActivo;
        this.isSoftphone = isSoftphone;
    }

    public Integer getIdextension() {
        return idextension;
    }

    public void setIdextension(Integer idextension) {
        this.idextension = idextension;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getCorreovozActivo() {
        return correovozActivo;
    }

    public void setCorreovozActivo(boolean correovozActivo) {
        this.correovozActivo = correovozActivo;
    }

    public boolean getIsSoftphone() {
        return isSoftphone;
    }

    public void setIsSoftphone(boolean isSoftphone) {
        this.isSoftphone = isSoftphone;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    public Collection<TroncalLinea> getTroncalLineaCollection() {
        return troncalLineaCollection;
    }

    public void setTroncalLineaCollection(Collection<TroncalLinea> troncalLineaCollection) {
        this.troncalLineaCollection = troncalLineaCollection;
    }

    public Extensiongrupo getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Extensiongrupo idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<Cola> getColaCollection() {
        return colaCollection;
    }

    public void setColaCollection(Collection<Cola> colaCollection) {
        this.colaCollection = colaCollection;
    }

    @XmlTransient
    public Collection<IvrOpcion> getIvrOpcionCollection() {
        return ivrOpcionCollection;
    }

    public void setIvrOpcionCollection(Collection<IvrOpcion> ivrOpcionCollection) {
        this.ivrOpcionCollection = ivrOpcionCollection;
    }

    @XmlTransient
    public Collection<Ivr> getIvrCollection() {
        return ivrCollection;
    }

    public void setIvrCollection(Collection<Ivr> ivrCollection) {
        this.ivrCollection = ivrCollection;
    }

    @XmlTransient
    public Collection<Ivr> getIvrCollection1() {
        return ivrCollection1;
    }

    public void setIvrCollection1(Collection<Ivr> ivrCollection1) {
        this.ivrCollection1 = ivrCollection1;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection() {
        return campanaCollection;
    }

    public void setCampanaCollection(Collection<Campana> campanaCollection) {
        this.campanaCollection = campanaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idextension != null ? idextension.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extension)) {
            return false;
        }
        Extension other = (Extension) object;
        if ((this.idextension == null && other.idextension != null) || (this.idextension != null && !this.idextension.equals(other.idextension))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Extension[ idextension=" + idextension + " ]";
    }
    
}
