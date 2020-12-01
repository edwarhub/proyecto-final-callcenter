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
@Table(name = "cola_has_agente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColaHasAgente.findAll", query = "SELECT c FROM ColaHasAgente c")
    , @NamedQuery(name = "ColaHasAgente.findByIdca", query = "SELECT c FROM ColaHasAgente c WHERE c.idca = :idca")})
public class ColaHasAgente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idca")
    private String idca;
    @JoinColumn(name = "idagente", referencedColumnName = "idagente")
    @ManyToOne(optional = false)
    private Agente idagente;
    @JoinColumn(name = "idcola", referencedColumnName = "idcola")
    @ManyToOne(optional = false)
    private Cola idcola;

    public ColaHasAgente() {
    }

    public ColaHasAgente(String idca) {
        this.idca = idca;
    }

    public String getIdca() {
        return idca;
    }

    public void setIdca(String idca) {
        this.idca = idca;
    }

    public Agente getIdagente() {
        return idagente;
    }

    public void setIdagente(Agente idagente) {
        this.idagente = idagente;
    }

    public Cola getIdcola() {
        return idcola;
    }

    public void setIdcola(Cola idcola) {
        this.idcola = idcola;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idca != null ? idca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColaHasAgente)) {
            return false;
        }
        ColaHasAgente other = (ColaHasAgente) object;
        if ((this.idca == null && other.idca != null) || (this.idca != null && !this.idca.equals(other.idca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ColaHasAgente[ idca=" + idca + " ]";
    }
    
}
