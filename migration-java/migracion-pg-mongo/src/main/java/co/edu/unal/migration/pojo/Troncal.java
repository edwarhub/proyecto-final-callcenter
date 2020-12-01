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
@Table(name = "troncal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Troncal.findAll", query = "SELECT t FROM Troncal t")
    , @NamedQuery(name = "Troncal.findByIdtroncal", query = "SELECT t FROM Troncal t WHERE t.idtroncal = :idtroncal")
    , @NamedQuery(name = "Troncal.findByNombre", query = "SELECT t FROM Troncal t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Troncal.findByTipo", query = "SELECT t FROM Troncal t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Troncal.findByPropiedadesConexion", query = "SELECT t FROM Troncal t WHERE t.propiedadesConexion = :propiedadesConexion")
    , @NamedQuery(name = "Troncal.findByUpdatedAt", query = "SELECT t FROM Troncal t WHERE t.updatedAt = :updatedAt")
    , @NamedQuery(name = "Troncal.findByGrabarLlamadas", query = "SELECT t FROM Troncal t WHERE t.grabarLlamadas = :grabarLlamadas")
    , @NamedQuery(name = "Troncal.findByPropiedadesDahdiIdentificador", query = "SELECT t FROM Troncal t WHERE t.propiedadesDahdiIdentificador = :propiedadesDahdiIdentificador")
    , @NamedQuery(name = "Troncal.findByPropiedadesDahdi", query = "SELECT t FROM Troncal t WHERE t.propiedadesDahdi = :propiedadesDahdi")
    , @NamedQuery(name = "Troncal.findByPropiedadesDahdiChan", query = "SELECT t FROM Troncal t WHERE t.propiedadesDahdiChan = :propiedadesDahdiChan")
    , @NamedQuery(name = "Troncal.findByPropiedadesDahdiSystem", query = "SELECT t FROM Troncal t WHERE t.propiedadesDahdiSystem = :propiedadesDahdiSystem")})
public class Troncal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtroncal")
    private Integer idtroncal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "propiedades_conexion")
    private String propiedadesConexion;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "grabar_llamadas")
    private boolean grabarLlamadas;
    @Column(name = "propiedades_dahdi_identificador")
    private String propiedadesDahdiIdentificador;
    @Column(name = "propiedades_dahdi")
    private String propiedadesDahdi;
    @Column(name = "propiedades_dahdi_chan")
    private String propiedadesDahdiChan;
    @Column(name = "propiedades_dahdi_system")
    private String propiedadesDahdiSystem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtroncal")
    private Collection<TroncalLinea> troncalLineaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtroncal")
    private Collection<TroncalMarcado> troncalMarcadoCollection;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;

    public Troncal() {
    }

    public Troncal(Integer idtroncal) {
        this.idtroncal = idtroncal;
    }

    public Troncal(Integer idtroncal, String nombre, String tipo, Date updatedAt, boolean grabarLlamadas) {
        this.idtroncal = idtroncal;
        this.nombre = nombre;
        this.tipo = tipo;
        this.updatedAt = updatedAt;
        this.grabarLlamadas = grabarLlamadas;
    }

    public Integer getIdtroncal() {
        return idtroncal;
    }

    public void setIdtroncal(Integer idtroncal) {
        this.idtroncal = idtroncal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPropiedadesConexion() {
        return propiedadesConexion;
    }

    public void setPropiedadesConexion(String propiedadesConexion) {
        this.propiedadesConexion = propiedadesConexion;
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

    public String getPropiedadesDahdiIdentificador() {
        return propiedadesDahdiIdentificador;
    }

    public void setPropiedadesDahdiIdentificador(String propiedadesDahdiIdentificador) {
        this.propiedadesDahdiIdentificador = propiedadesDahdiIdentificador;
    }

    public String getPropiedadesDahdi() {
        return propiedadesDahdi;
    }

    public void setPropiedadesDahdi(String propiedadesDahdi) {
        this.propiedadesDahdi = propiedadesDahdi;
    }

    public String getPropiedadesDahdiChan() {
        return propiedadesDahdiChan;
    }

    public void setPropiedadesDahdiChan(String propiedadesDahdiChan) {
        this.propiedadesDahdiChan = propiedadesDahdiChan;
    }

    public String getPropiedadesDahdiSystem() {
        return propiedadesDahdiSystem;
    }

    public void setPropiedadesDahdiSystem(String propiedadesDahdiSystem) {
        this.propiedadesDahdiSystem = propiedadesDahdiSystem;
    }

    @XmlTransient
    public Collection<TroncalLinea> getTroncalLineaCollection() {
        return troncalLineaCollection;
    }

    public void setTroncalLineaCollection(Collection<TroncalLinea> troncalLineaCollection) {
        this.troncalLineaCollection = troncalLineaCollection;
    }

    @XmlTransient
    public Collection<TroncalMarcado> getTroncalMarcadoCollection() {
        return troncalMarcadoCollection;
    }

    public void setTroncalMarcadoCollection(Collection<TroncalMarcado> troncalMarcadoCollection) {
        this.troncalMarcadoCollection = troncalMarcadoCollection;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtroncal != null ? idtroncal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Troncal)) {
            return false;
        }
        Troncal other = (Troncal) object;
        if ((this.idtroncal == null && other.idtroncal != null) || (this.idtroncal != null && !this.idtroncal.equals(other.idtroncal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Troncal[ idtroncal=" + idtroncal + " ]";
    }
    
}
