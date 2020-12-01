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
@Table(name = "ivr_opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrOpcion.findAll", query = "SELECT i FROM IvrOpcion i")
    , @NamedQuery(name = "IvrOpcion.findByIdopcion", query = "SELECT i FROM IvrOpcion i WHERE i.idopcion = :idopcion")
    , @NamedQuery(name = "IvrOpcion.findByAccion", query = "SELECT i FROM IvrOpcion i WHERE i.accion = :accion")
    , @NamedQuery(name = "IvrOpcion.findByDigito", query = "SELECT i FROM IvrOpcion i WHERE i.digito = :digito")
    , @NamedQuery(name = "IvrOpcion.findByAplicacionSecuenciaXml", query = "SELECT i FROM IvrOpcion i WHERE i.aplicacionSecuenciaXml = :aplicacionSecuenciaXml")
    , @NamedQuery(name = "IvrOpcion.findByIsAutonoma", query = "SELECT i FROM IvrOpcion i WHERE i.isAutonoma = :isAutonoma")})
public class IvrOpcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idopcion")
    private Integer idopcion;
    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;
    @Basic(optional = false)
    @Column(name = "digito")
    private String digito;
    @Column(name = "aplicacion_secuencia_xml")
    private String aplicacionSecuenciaXml;
    @Basic(optional = false)
    @Column(name = "is_autonoma")
    private boolean isAutonoma;
    @JoinColumn(name = "idcampana", referencedColumnName = "idcampana")
    @ManyToOne
    private Campana idcampana;
    @JoinColumn(name = "acc_idcola", referencedColumnName = "idcola")
    @ManyToOne
    private Cola accIdcola;
    @JoinColumn(name = "acc_idextension", referencedColumnName = "idextension")
    @ManyToOne
    private Extension accIdextension;
    @JoinColumn(name = "acc_idivr", referencedColumnName = "idivr")
    @ManyToOne
    private Ivr accIdivr;
    @JoinColumn(name = "idivr", referencedColumnName = "idivr")
    @ManyToOne(optional = false)
    private Ivr idivr;

    public IvrOpcion() {
    }

    public IvrOpcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public IvrOpcion(Integer idopcion, String accion, String digito, boolean isAutonoma) {
        this.idopcion = idopcion;
        this.accion = accion;
        this.digito = digito;
        this.isAutonoma = isAutonoma;
    }

    public Integer getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getAplicacionSecuenciaXml() {
        return aplicacionSecuenciaXml;
    }

    public void setAplicacionSecuenciaXml(String aplicacionSecuenciaXml) {
        this.aplicacionSecuenciaXml = aplicacionSecuenciaXml;
    }

    public boolean getIsAutonoma() {
        return isAutonoma;
    }

    public void setIsAutonoma(boolean isAutonoma) {
        this.isAutonoma = isAutonoma;
    }

    public Campana getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(Campana idcampana) {
        this.idcampana = idcampana;
    }

    public Cola getAccIdcola() {
        return accIdcola;
    }

    public void setAccIdcola(Cola accIdcola) {
        this.accIdcola = accIdcola;
    }

    public Extension getAccIdextension() {
        return accIdextension;
    }

    public void setAccIdextension(Extension accIdextension) {
        this.accIdextension = accIdextension;
    }

    public Ivr getAccIdivr() {
        return accIdivr;
    }

    public void setAccIdivr(Ivr accIdivr) {
        this.accIdivr = accIdivr;
    }

    public Ivr getIdivr() {
        return idivr;
    }

    public void setIdivr(Ivr idivr) {
        this.idivr = idivr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idopcion != null ? idopcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrOpcion)) {
            return false;
        }
        IvrOpcion other = (IvrOpcion) object;
        if ((this.idopcion == null && other.idopcion != null) || (this.idopcion != null && !this.idopcion.equals(other.idopcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.IvrOpcion[ idopcion=" + idopcion + " ]";
    }
    
}
