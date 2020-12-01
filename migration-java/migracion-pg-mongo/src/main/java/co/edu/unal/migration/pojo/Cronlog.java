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
@Table(name = "cronlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cronlog.findAll", query = "SELECT c FROM Cronlog c")
    , @NamedQuery(name = "Cronlog.findByIdlog", query = "SELECT c FROM Cronlog c WHERE c.idlog = :idlog")
    , @NamedQuery(name = "Cronlog.findByLog", query = "SELECT c FROM Cronlog c WHERE c.log = :log")
    , @NamedQuery(name = "Cronlog.findBySuccessful", query = "SELECT c FROM Cronlog c WHERE c.successful = :successful")
    , @NamedQuery(name = "Cronlog.findByProcesoId", query = "SELECT c FROM Cronlog c WHERE c.procesoId = :procesoId")
    , @NamedQuery(name = "Cronlog.findByFechaIni", query = "SELECT c FROM Cronlog c WHERE c.fechaIni = :fechaIni")
    , @NamedQuery(name = "Cronlog.findByFechaFin", query = "SELECT c FROM Cronlog c WHERE c.fechaFin = :fechaFin")})
public class Cronlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlog")
    private Long idlog;
    @Basic(optional = false)
    @Column(name = "log")
    private String log;
    @Basic(optional = false)
    @Column(name = "successful")
    private boolean successful;
    @Basic(optional = false)
    @Column(name = "proceso_id")
    private int procesoId;
    @Basic(optional = false)
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    public Cronlog() {
    }

    public Cronlog(Long idlog) {
        this.idlog = idlog;
    }

    public Cronlog(Long idlog, String log, boolean successful, int procesoId, Date fechaIni) {
        this.idlog = idlog;
        this.log = log;
        this.successful = successful;
        this.procesoId = procesoId;
        this.fechaIni = fechaIni;
    }

    public Long getIdlog() {
        return idlog;
    }

    public void setIdlog(Long idlog) {
        this.idlog = idlog;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public int getProcesoId() {
        return procesoId;
    }

    public void setProcesoId(int procesoId) {
        this.procesoId = procesoId;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlog != null ? idlog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cronlog)) {
            return false;
        }
        Cronlog other = (Cronlog) object;
        if ((this.idlog == null && other.idlog != null) || (this.idlog != null && !this.idlog.equals(other.idlog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Cronlog[ idlog=" + idlog + " ]";
    }
    
}
