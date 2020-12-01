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
@Table(name = "fpqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fpqr.findAll", query = "SELECT f FROM Fpqr f")
    , @NamedQuery(name = "Fpqr.findByIdfpqr", query = "SELECT f FROM Fpqr f WHERE f.idfpqr = :idfpqr")
    , @NamedQuery(name = "Fpqr.findByEstado", query = "SELECT f FROM Fpqr f WHERE f.estado = :estado")
    , @NamedQuery(name = "Fpqr.findByMedio", query = "SELECT f FROM Fpqr f WHERE f.medio = :medio")
    , @NamedQuery(name = "Fpqr.findByDescripcion", query = "SELECT f FROM Fpqr f WHERE f.descripcion = :descripcion")
    , @NamedQuery(name = "Fpqr.findByCreatedAt", query = "SELECT f FROM Fpqr f WHERE f.createdAt = :createdAt")})
public class Fpqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfpqr")
    private Long idfpqr;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "medio")
    private String medio;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfpqr")
    private Collection<FpqrDireccionamiento> fpqrDireccionamientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfpqr")
    private Collection<FpqrGestion> fpqrGestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfpqr")
    private Collection<FpqrCierre> fpqrCierreCollection;
    @OneToMany(mappedBy = "idfpqr")
    private Collection<Llamadagestion> llamadagestionCollection;
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo")
    @ManyToOne(optional = false)
    private FpqrMotivo idmotivo;
    @JoinColumn(name = "idtipo", referencedColumnName = "idtipo")
    @ManyToOne(optional = false)
    private FpqrTipo idtipo;
    @JoinColumn(name = "idllamada", referencedColumnName = "idllamada")
    @ManyToOne
    private Llamada idllamada;
    @JoinColumn(name = "idpersona_created", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaCreated;
    @JoinColumn(name = "idpersona_solicitante", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersonaSolicitante;

    public Fpqr() {
    }

    public Fpqr(Long idfpqr) {
        this.idfpqr = idfpqr;
    }

    public Fpqr(Long idfpqr, String estado, String medio, String descripcion, Date createdAt) {
        this.idfpqr = idfpqr;
        this.estado = estado;
        this.medio = medio;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
    }

    public Long getIdfpqr() {
        return idfpqr;
    }

    public void setIdfpqr(Long idfpqr) {
        this.idfpqr = idfpqr;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public Collection<FpqrDireccionamiento> getFpqrDireccionamientoCollection() {
        return fpqrDireccionamientoCollection;
    }

    public void setFpqrDireccionamientoCollection(Collection<FpqrDireccionamiento> fpqrDireccionamientoCollection) {
        this.fpqrDireccionamientoCollection = fpqrDireccionamientoCollection;
    }

    @XmlTransient
    public Collection<FpqrGestion> getFpqrGestionCollection() {
        return fpqrGestionCollection;
    }

    public void setFpqrGestionCollection(Collection<FpqrGestion> fpqrGestionCollection) {
        this.fpqrGestionCollection = fpqrGestionCollection;
    }

    @XmlTransient
    public Collection<FpqrCierre> getFpqrCierreCollection() {
        return fpqrCierreCollection;
    }

    public void setFpqrCierreCollection(Collection<FpqrCierre> fpqrCierreCollection) {
        this.fpqrCierreCollection = fpqrCierreCollection;
    }

    @XmlTransient
    public Collection<Llamadagestion> getLlamadagestionCollection() {
        return llamadagestionCollection;
    }

    public void setLlamadagestionCollection(Collection<Llamadagestion> llamadagestionCollection) {
        this.llamadagestionCollection = llamadagestionCollection;
    }

    public FpqrMotivo getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(FpqrMotivo idmotivo) {
        this.idmotivo = idmotivo;
    }

    public FpqrTipo getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(FpqrTipo idtipo) {
        this.idtipo = idtipo;
    }

    public Llamada getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(Llamada idllamada) {
        this.idllamada = idllamada;
    }

    public Persona getIdpersonaCreated() {
        return idpersonaCreated;
    }

    public void setIdpersonaCreated(Persona idpersonaCreated) {
        this.idpersonaCreated = idpersonaCreated;
    }

    public Persona getIdpersonaSolicitante() {
        return idpersonaSolicitante;
    }

    public void setIdpersonaSolicitante(Persona idpersonaSolicitante) {
        this.idpersonaSolicitante = idpersonaSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfpqr != null ? idfpqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fpqr)) {
            return false;
        }
        Fpqr other = (Fpqr) object;
        if ((this.idfpqr == null && other.idfpqr != null) || (this.idfpqr != null && !this.idfpqr.equals(other.idfpqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Fpqr[ idfpqr=" + idfpqr + " ]";
    }
    
}
