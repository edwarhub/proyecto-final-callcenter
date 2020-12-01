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
@Table(name = "campanacampo_opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CampanacampoOpcion.findAll", query = "SELECT c FROM CampanacampoOpcion c")
    , @NamedQuery(name = "CampanacampoOpcion.findByIdpocion", query = "SELECT c FROM CampanacampoOpcion c WHERE c.idpocion = :idpocion")
    , @NamedQuery(name = "CampanacampoOpcion.findByValor", query = "SELECT c FROM CampanacampoOpcion c WHERE c.valor = :valor")})
public class CampanacampoOpcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpocion")
    private Integer idpocion;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "idcampo", referencedColumnName = "idcampo")
    @ManyToOne(optional = false)
    private Campanacampo idcampo;

    public CampanacampoOpcion() {
    }

    public CampanacampoOpcion(Integer idpocion) {
        this.idpocion = idpocion;
    }

    public CampanacampoOpcion(Integer idpocion, String valor) {
        this.idpocion = idpocion;
        this.valor = valor;
    }

    public Integer getIdpocion() {
        return idpocion;
    }

    public void setIdpocion(Integer idpocion) {
        this.idpocion = idpocion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Campanacampo getIdcampo() {
        return idcampo;
    }

    public void setIdcampo(Campanacampo idcampo) {
        this.idcampo = idcampo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpocion != null ? idpocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampanacampoOpcion)) {
            return false;
        }
        CampanacampoOpcion other = (CampanacampoOpcion) object;
        if ((this.idpocion == null && other.idpocion != null) || (this.idpocion != null && !this.idpocion.equals(other.idpocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.CampanacampoOpcion[ idpocion=" + idpocion + " ]";
    }
    
}
