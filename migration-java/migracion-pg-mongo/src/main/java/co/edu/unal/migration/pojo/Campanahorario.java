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
@Table(name = "campanahorario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campanahorario.findAll", query = "SELECT c FROM Campanahorario c")
    , @NamedQuery(name = "Campanahorario.findByIdhorario", query = "SELECT c FROM Campanahorario c WHERE c.idhorario = :idhorario")
    , @NamedQuery(name = "Campanahorario.findByDia", query = "SELECT c FROM Campanahorario c WHERE c.dia = :dia")
    , @NamedQuery(name = "Campanahorario.findByHoraIni", query = "SELECT c FROM Campanahorario c WHERE c.horaIni = :horaIni")
    , @NamedQuery(name = "Campanahorario.findByHoraFin", query = "SELECT c FROM Campanahorario c WHERE c.horaFin = :horaFin")})
public class Campanahorario implements Serializable {

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
    @JoinColumn(name = "idcampana", referencedColumnName = "idcampana")
    @ManyToOne(optional = false)
    private Campana idcampana;

    public Campanahorario() {
    }

    public Campanahorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Campanahorario(Integer idhorario, String dia, Date horaIni, Date horaFin) {
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

    public Campana getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(Campana idcampana) {
        this.idcampana = idcampana;
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
        if (!(object instanceof Campanahorario)) {
            return false;
        }
        Campanahorario other = (Campanahorario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Campanahorario[ idhorario=" + idhorario + " ]";
    }
    
}
