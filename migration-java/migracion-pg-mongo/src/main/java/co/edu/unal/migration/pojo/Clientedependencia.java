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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "clientedependencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientedependencia.findAll", query = "SELECT c FROM Clientedependencia c")
    , @NamedQuery(name = "Clientedependencia.findByIddependencia", query = "SELECT c FROM Clientedependencia c WHERE c.iddependencia = :iddependencia")
    , @NamedQuery(name = "Clientedependencia.findByNombre", query = "SELECT c FROM Clientedependencia c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientedependencia.findByObservaciones", query = "SELECT c FROM Clientedependencia c WHERE c.observaciones = :observaciones")})
public class Clientedependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddependencia")
    private Integer iddependencia;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Clientecorporativo idcliente;

    public Clientedependencia() {
    }

    public Clientedependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
    }

    public Clientedependencia(Integer iddependencia, String nombre) {
        this.iddependencia = iddependencia;
        this.nombre = nombre;
    }

    public Integer getIddependencia() {
        return iddependencia;
    }

    public void setIddependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
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

    public Clientecorporativo getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientecorporativo idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddependencia != null ? iddependencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientedependencia)) {
            return false;
        }
        Clientedependencia other = (Clientedependencia) object;
        if ((this.iddependencia == null && other.iddependencia != null) || (this.iddependencia != null && !this.iddependencia.equals(other.iddependencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Clientedependencia[ iddependencia=" + iddependencia + " ]";
    }
    
}
