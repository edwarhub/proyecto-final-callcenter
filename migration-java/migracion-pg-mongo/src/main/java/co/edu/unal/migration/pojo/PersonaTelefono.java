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
@Table(name = "persona_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonaTelefono.findAll", query = "SELECT p FROM PersonaTelefono p")
    , @NamedQuery(name = "PersonaTelefono.findByIdpt", query = "SELECT p FROM PersonaTelefono p WHERE p.idpt = :idpt")
    , @NamedQuery(name = "PersonaTelefono.findByIsVerificado", query = "SELECT p FROM PersonaTelefono p WHERE p.isVerificado = :isVerificado")})
public class PersonaTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpt")
    private String idpt;
    @Basic(optional = false)
    @Column(name = "is_verificado")
    private boolean isVerificado;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idtelefono", referencedColumnName = "idtelefono")
    @ManyToOne(optional = false)
    private Telefono idtelefono;

    public PersonaTelefono() {
    }

    public PersonaTelefono(String idpt) {
        this.idpt = idpt;
    }

    public PersonaTelefono(String idpt, boolean isVerificado) {
        this.idpt = idpt;
        this.isVerificado = isVerificado;
    }

    public String getIdpt() {
        return idpt;
    }

    public void setIdpt(String idpt) {
        this.idpt = idpt;
    }

    public boolean getIsVerificado() {
        return isVerificado;
    }

    public void setIsVerificado(boolean isVerificado) {
        this.isVerificado = isVerificado;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Telefono getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Telefono idtelefono) {
        this.idtelefono = idtelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpt != null ? idpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaTelefono)) {
            return false;
        }
        PersonaTelefono other = (PersonaTelefono) object;
        if ((this.idpt == null && other.idpt != null) || (this.idpt != null && !this.idpt.equals(other.idpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.PersonaTelefono[ idpt=" + idpt + " ]";
    }
    
}
