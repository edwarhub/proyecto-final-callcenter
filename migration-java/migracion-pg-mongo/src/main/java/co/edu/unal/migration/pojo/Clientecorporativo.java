/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "clientecorporativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientecorporativo.findAll", query = "SELECT c FROM Clientecorporativo c")
    , @NamedQuery(name = "Clientecorporativo.findByIdcliente", query = "SELECT c FROM Clientecorporativo c WHERE c.idcliente = :idcliente")
    , @NamedQuery(name = "Clientecorporativo.findByNombre", query = "SELECT c FROM Clientecorporativo c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientecorporativo.findByNumdocumento", query = "SELECT c FROM Clientecorporativo c WHERE c.numdocumento = :numdocumento")})
public class Clientecorporativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "numdocumento")
    private BigInteger numdocumento;
    @JoinColumn(name = "iddireccion", referencedColumnName = "iddireccion")
    @ManyToOne
    private Direccion iddireccion;
    @JoinColumn(name = "idtipodoc", referencedColumnName = "idtipodoc")
    @ManyToOne(optional = false)
    private Documentotipo idtipodoc;
    @JoinColumn(name = "idpersona_contacto", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaContacto;
    @JoinColumn(name = "idtelefono1", referencedColumnName = "idtelefono")
    @ManyToOne(optional = false)
    private Telefono idtelefono1;
    @JoinColumn(name = "idtelefono2", referencedColumnName = "idtelefono")
    @ManyToOne
    private Telefono idtelefono2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<Clientedependencia> clientedependenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<Campana> campanaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<ClienteWebservice> clienteWebserviceCollection;

    public Clientecorporativo() {
    }

    public Clientecorporativo(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Clientecorporativo(Integer idcliente, String nombre, BigInteger numdocumento) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.numdocumento = numdocumento;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(BigInteger numdocumento) {
        this.numdocumento = numdocumento;
    }

    public Direccion getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Direccion iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Documentotipo getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(Documentotipo idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public Persona getIdpersonaContacto() {
        return idpersonaContacto;
    }

    public void setIdpersonaContacto(Persona idpersonaContacto) {
        this.idpersonaContacto = idpersonaContacto;
    }

    public Telefono getIdtelefono1() {
        return idtelefono1;
    }

    public void setIdtelefono1(Telefono idtelefono1) {
        this.idtelefono1 = idtelefono1;
    }

    public Telefono getIdtelefono2() {
        return idtelefono2;
    }

    public void setIdtelefono2(Telefono idtelefono2) {
        this.idtelefono2 = idtelefono2;
    }

    @XmlTransient
    public Collection<Clientedependencia> getClientedependenciaCollection() {
        return clientedependenciaCollection;
    }

    public void setClientedependenciaCollection(Collection<Clientedependencia> clientedependenciaCollection) {
        this.clientedependenciaCollection = clientedependenciaCollection;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection() {
        return campanaCollection;
    }

    public void setCampanaCollection(Collection<Campana> campanaCollection) {
        this.campanaCollection = campanaCollection;
    }

    @XmlTransient
    public Collection<ClienteWebservice> getClienteWebserviceCollection() {
        return clienteWebserviceCollection;
    }

    public void setClienteWebserviceCollection(Collection<ClienteWebservice> clienteWebserviceCollection) {
        this.clienteWebserviceCollection = clienteWebserviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientecorporativo)) {
            return false;
        }
        Clientecorporativo other = (Clientecorporativo) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Clientecorporativo[ idcliente=" + idcliente + " ]";
    }
    
}
