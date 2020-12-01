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
@Table(name = "ivrhorario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ivrhorario.findAll", query = "SELECT i FROM Ivrhorario i")
    , @NamedQuery(name = "Ivrhorario.findByIdhorario", query = "SELECT i FROM Ivrhorario i WHERE i.idhorario = :idhorario")
    , @NamedQuery(name = "Ivrhorario.findByDia", query = "SELECT i FROM Ivrhorario i WHERE i.dia = :dia")
    , @NamedQuery(name = "Ivrhorario.findByHoraIni", query = "SELECT i FROM Ivrhorario i WHERE i.horaIni = :horaIni")
    , @NamedQuery(name = "Ivrhorario.findByHoraFin", query = "SELECT i FROM Ivrhorario i WHERE i.horaFin = :horaFin")})
public class Ivrhorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorario")
    private Integer idhorario;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @Column(name = "hora_ini")
    @Temporal(TemporalType.TIME)
    private Date horaIni;
    @Basic(optional = false)
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumn(name = "idivr", referencedColumnName = "idivr")
    @ManyToOne(optional = false)
    private Ivr idivr;

    public Ivrhorario() {
    }

    public Ivrhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Ivrhorario(Integer idhorario, String dia, Date horaIni, Date horaFin) {
        this.idhorario = idhorario;
        this.dia = dia;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(Date horaIni) {
        this.horaIni = horaIni;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
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
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ivrhorario)) {
            return false;
        }
        Ivrhorario other = (Ivrhorario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Ivrhorario[ idhorario=" + idhorario + " ]";
    }
    
}
