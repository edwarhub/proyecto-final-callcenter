/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "transferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferencia.findAll", query = "SELECT t FROM Transferencia t")
    , @NamedQuery(name = "Transferencia.findByIdtransferencia", query = "SELECT t FROM Transferencia t WHERE t.idtransferencia = :idtransferencia")
    , @NamedQuery(name = "Transferencia.findByCreatedAt", query = "SELECT t FROM Transferencia t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "Transferencia.findByExtOri", query = "SELECT t FROM Transferencia t WHERE t.extOri = :extOri")
    , @NamedQuery(name = "Transferencia.findByExtDes", query = "SELECT t FROM Transferencia t WHERE t.extDes = :extDes")})
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransferencia")
    private Long idtransferencia;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "ext_ori")
    private String extOri;
    @Column(name = "ext_des")
    private String extDes;
    @JoinColumn(name = "idllamada", referencedColumnName = "idllamada")
    @ManyToOne(optional = false)
    private Llamada idllamada;
    @JoinColumn(name = "idpersona_des", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaDes;
    @JoinColumn(name = "idpersona_ori", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaOri;

    public Transferencia() {
    }

    public Transferencia(Long idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Transferencia(Long idtransferencia, Date createdAt) {
        this.idtransferencia = idtransferencia;
        this.createdAt = createdAt;
    }

    public Long getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(Long idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getExtOri() {
        return extOri;
    }

    public void setExtOri(String extOri) {
        this.extOri = extOri;
    }

    public String getExtDes() {
        return extDes;
    }

    public void setExtDes(String extDes) {
        this.extDes = extDes;
    }

    public Llamada getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(Llamada idllamada) {
        this.idllamada = idllamada;
    }

    public Persona getIdpersonaDes() {
        return idpersonaDes;
    }

    public void setIdpersonaDes(Persona idpersonaDes) {
        this.idpersonaDes = idpersonaDes;
    }

    public Persona getIdpersonaOri() {
        return idpersonaOri;
    }

    public void setIdpersonaOri(Persona idpersonaOri) {
        this.idpersonaOri = idpersonaOri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransferencia != null ? idtransferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.idtransferencia == null && other.idtransferencia != null) || (this.idtransferencia != null && !this.idtransferencia.equals(other.idtransferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Transferencia[ idtransferencia=" + idtransferencia + " ]";
    }
    
}
