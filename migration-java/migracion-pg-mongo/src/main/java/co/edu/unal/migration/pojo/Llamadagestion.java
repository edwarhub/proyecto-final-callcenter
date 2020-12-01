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
@Table(name = "llamadagestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamadagestion.findAll", query = "SELECT l FROM Llamadagestion l")
    , @NamedQuery(name = "Llamadagestion.findByIdgestion", query = "SELECT l FROM Llamadagestion l WHERE l.idgestion = :idgestion")
    , @NamedQuery(name = "Llamadagestion.findByCreatedAt", query = "SELECT l FROM Llamadagestion l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "Llamadagestion.findByTiempoSegundos", query = "SELECT l FROM Llamadagestion l WHERE l.tiempoSegundos = :tiempoSegundos")})
public class Llamadagestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgestion")
    private Long idgestion;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "tiempo_segundos")
    private long tiempoSegundos;
    @OneToMany(mappedBy = "idgestionUltima")
    private Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgestion")
    private Collection<LlamadagestionItem> llamadagestionItemCollection;
    @JoinColumn(name = "idfpqr", referencedColumnName = "idfpqr")
    @ManyToOne
    private Fpqr idfpqr;
    @JoinColumn(name = "idllamada", referencedColumnName = "idllamada")
    @ManyToOne(optional = false)
    private Llamada idllamada;
    @JoinColumn(name = "idusuario_created", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioCreated;

    public Llamadagestion() {
    }

    public Llamadagestion(Long idgestion) {
        this.idgestion = idgestion;
    }

    public Llamadagestion(Long idgestion, Date createdAt, long tiempoSegundos) {
        this.idgestion = idgestion;
        this.createdAt = createdAt;
        this.tiempoSegundos = tiempoSegundos;
    }

    public Long getIdgestion() {
        return idgestion;
    }

    public void setIdgestion(Long idgestion) {
        this.idgestion = idgestion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getTiempoSegundos() {
        return tiempoSegundos;
    }

    public void setTiempoSegundos(long tiempoSegundos) {
        this.tiempoSegundos = tiempoSegundos;
    }

    @XmlTransient
    public Collection<CampanabasedatosHasPersona> getCampanabasedatosHasPersonaCollection() {
        return campanabasedatosHasPersonaCollection;
    }

    public void setCampanabasedatosHasPersonaCollection(Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection) {
        this.campanabasedatosHasPersonaCollection = campanabasedatosHasPersonaCollection;
    }

    @XmlTransient
    public Collection<LlamadagestionItem> getLlamadagestionItemCollection() {
        return llamadagestionItemCollection;
    }

    public void setLlamadagestionItemCollection(Collection<LlamadagestionItem> llamadagestionItemCollection) {
        this.llamadagestionItemCollection = llamadagestionItemCollection;
    }

    public Fpqr getIdfpqr() {
        return idfpqr;
    }

    public void setIdfpqr(Fpqr idfpqr) {
        this.idfpqr = idfpqr;
    }

    public Llamada getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(Llamada idllamada) {
        this.idllamada = idllamada;
    }

    public Usuario getIdusuarioCreated() {
        return idusuarioCreated;
    }

    public void setIdusuarioCreated(Usuario idusuarioCreated) {
        this.idusuarioCreated = idusuarioCreated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgestion != null ? idgestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamadagestion)) {
            return false;
        }
        Llamadagestion other = (Llamadagestion) object;
        if ((this.idgestion == null && other.idgestion != null) || (this.idgestion != null && !this.idgestion.equals(other.idgestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Llamadagestion[ idgestion=" + idgestion + " ]";
    }
    
}
