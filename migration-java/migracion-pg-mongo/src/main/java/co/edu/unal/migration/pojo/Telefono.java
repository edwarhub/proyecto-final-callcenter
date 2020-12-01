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
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
    , @NamedQuery(name = "Telefono.findByIdtelefono", query = "SELECT t FROM Telefono t WHERE t.idtelefono = :idtelefono")
    , @NamedQuery(name = "Telefono.findByTipo", query = "SELECT t FROM Telefono t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Telefono.findByNumero", query = "SELECT t FROM Telefono t WHERE t.numero = :numero")
    , @NamedQuery(name = "Telefono.findByExtension", query = "SELECT t FROM Telefono t WHERE t.extension = :extension")
    , @NamedQuery(name = "Telefono.findByUpdatedAt", query = "SELECT t FROM Telefono t WHERE t.updatedAt = :updatedAt")
    , @NamedQuery(name = "Telefono.findByCreatedAt", query = "SELECT t FROM Telefono t WHERE t.createdAt = :createdAt")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtelefono")
    private Long idtelefono;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Column(name = "extension")
    private String extension;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelefonoDes")
    private Collection<Llamada> llamadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelefonoOri")
    private Collection<Llamada> llamadaCollection1;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne
    private Ciudad idciudad;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne
    private Pais idpais;
    @JoinColumn(name = "idusuario_created", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioCreated;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelefono")
    private Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelefono1")
    private Collection<Clientecorporativo> clientecorporativoCollection;
    @OneToMany(mappedBy = "idtelefono2")
    private Collection<Clientecorporativo> clientecorporativoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelefono")
    private Collection<PersonaTelefono> personaTelefonoCollection;
    @OneToMany(mappedBy = "idtelefonoProxLlamada")
    private Collection<Agente> agenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelefono")
    private Collection<Llamadaprogramada> llamadaprogramadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelefono1")
    private Collection<Sucursal> sucursalCollection;
    @OneToMany(mappedBy = "idtelefono2")
    private Collection<Sucursal> sucursalCollection1;

    public Telefono() {
    }

    public Telefono(Long idtelefono) {
        this.idtelefono = idtelefono;
    }

    public Telefono(Long idtelefono, String tipo, String numero, Date updatedAt, Date createdAt) {
        this.idtelefono = idtelefono;
        this.tipo = tipo;
        this.numero = numero;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Long getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Long idtelefono) {
        this.idtelefono = idtelefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection1() {
        return llamadaCollection1;
    }

    public void setLlamadaCollection1(Collection<Llamada> llamadaCollection1) {
        this.llamadaCollection1 = llamadaCollection1;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    public Pais getIdpais() {
        return idpais;
    }

    public void setIdpais(Pais idpais) {
        this.idpais = idpais;
    }

    public Usuario getIdusuarioCreated() {
        return idusuarioCreated;
    }

    public void setIdusuarioCreated(Usuario idusuarioCreated) {
        this.idusuarioCreated = idusuarioCreated;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @XmlTransient
    public Collection<CampanabasedatosHasPersona> getCampanabasedatosHasPersonaCollection() {
        return campanabasedatosHasPersonaCollection;
    }

    public void setCampanabasedatosHasPersonaCollection(Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection) {
        this.campanabasedatosHasPersonaCollection = campanabasedatosHasPersonaCollection;
    }

    @XmlTransient
    public Collection<Clientecorporativo> getClientecorporativoCollection() {
        return clientecorporativoCollection;
    }

    public void setClientecorporativoCollection(Collection<Clientecorporativo> clientecorporativoCollection) {
        this.clientecorporativoCollection = clientecorporativoCollection;
    }

    @XmlTransient
    public Collection<Clientecorporativo> getClientecorporativoCollection1() {
        return clientecorporativoCollection1;
    }

    public void setClientecorporativoCollection1(Collection<Clientecorporativo> clientecorporativoCollection1) {
        this.clientecorporativoCollection1 = clientecorporativoCollection1;
    }

    @XmlTransient
    public Collection<PersonaTelefono> getPersonaTelefonoCollection() {
        return personaTelefonoCollection;
    }

    public void setPersonaTelefonoCollection(Collection<PersonaTelefono> personaTelefonoCollection) {
        this.personaTelefonoCollection = personaTelefonoCollection;
    }

    @XmlTransient
    public Collection<Agente> getAgenteCollection() {
        return agenteCollection;
    }

    public void setAgenteCollection(Collection<Agente> agenteCollection) {
        this.agenteCollection = agenteCollection;
    }

    @XmlTransient
    public Collection<Llamadaprogramada> getLlamadaprogramadaCollection() {
        return llamadaprogramadaCollection;
    }

    public void setLlamadaprogramadaCollection(Collection<Llamadaprogramada> llamadaprogramadaCollection) {
        this.llamadaprogramadaCollection = llamadaprogramadaCollection;
    }

    @XmlTransient
    public Collection<Sucursal> getSucursalCollection() {
        return sucursalCollection;
    }

    public void setSucursalCollection(Collection<Sucursal> sucursalCollection) {
        this.sucursalCollection = sucursalCollection;
    }

    @XmlTransient
    public Collection<Sucursal> getSucursalCollection1() {
        return sucursalCollection1;
    }

    public void setSucursalCollection1(Collection<Sucursal> sucursalCollection1) {
        this.sucursalCollection1 = sucursalCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtelefono != null ? idtelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.idtelefono == null && other.idtelefono != null) || (this.idtelefono != null && !this.idtelefono.equals(other.idtelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Telefono[ idtelefono=" + idtelefono + " ]";
    }
    
}
