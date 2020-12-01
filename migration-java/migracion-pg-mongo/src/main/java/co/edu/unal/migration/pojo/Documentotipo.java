/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "documentotipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentotipo.findAll", query = "SELECT d FROM Documentotipo d")
    , @NamedQuery(name = "Documentotipo.findByIdtipodoc", query = "SELECT d FROM Documentotipo d WHERE d.idtipodoc = :idtipodoc")
    , @NamedQuery(name = "Documentotipo.findByNombre", query = "SELECT d FROM Documentotipo d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Documentotipo.findByCodigooficial", query = "SELECT d FROM Documentotipo d WHERE d.codigooficial = :codigooficial")})
public class Documentotipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipodoc")
    private Integer idtipodoc;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "codigooficial")
    private String codigooficial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipodoc")
    private Collection<Persona> personaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipodoc")
    private Collection<Clientecorporativo> clientecorporativoCollection;

    public Documentotipo() {
    }

    public Documentotipo(Integer idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public Documentotipo(Integer idtipodoc, String nombre, String codigooficial) {
        this.idtipodoc = idtipodoc;
        this.nombre = nombre;
        this.codigooficial = codigooficial;
    }

    public Integer getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(Integer idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigooficial() {
        return codigooficial;
    }

    public void setCodigooficial(String codigooficial) {
        this.codigooficial = codigooficial;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    public Collection<Clientecorporativo> getClientecorporativoCollection() {
        return clientecorporativoCollection;
    }

    public void setClientecorporativoCollection(Collection<Clientecorporativo> clientecorporativoCollection) {
        this.clientecorporativoCollection = clientecorporativoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipodoc != null ? idtipodoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentotipo)) {
            return false;
        }
        Documentotipo other = (Documentotipo) object;
        if ((this.idtipodoc == null && other.idtipodoc != null) || (this.idtipodoc != null && !this.idtipodoc.equals(other.idtipodoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Documentotipo[ idtipodoc=" + idtipodoc + " ]";
    }
    
}
