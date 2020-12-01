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
@Table(name = "chatmensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chatmensaje.findAll", query = "SELECT c FROM Chatmensaje c")
    , @NamedQuery(name = "Chatmensaje.findByIdmensaje", query = "SELECT c FROM Chatmensaje c WHERE c.idmensaje = :idmensaje")
    , @NamedQuery(name = "Chatmensaje.findByLeido", query = "SELECT c FROM Chatmensaje c WHERE c.leido = :leido")
    , @NamedQuery(name = "Chatmensaje.findByEnviadoAt", query = "SELECT c FROM Chatmensaje c WHERE c.enviadoAt = :enviadoAt")
    , @NamedQuery(name = "Chatmensaje.findByMensaje", query = "SELECT c FROM Chatmensaje c WHERE c.mensaje = :mensaje")})
public class Chatmensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmensaje")
    private Integer idmensaje;
    @Basic(optional = false)
    @Column(name = "leido")
    private boolean leido;
    @Basic(optional = false)
    @Column(name = "enviado_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enviadoAt;
    @Basic(optional = false)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "idpersona_destino", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaDestino;
    @JoinColumn(name = "idpersona_origen", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersonaOrigen;

    public Chatmensaje() {
    }

    public Chatmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Chatmensaje(Integer idmensaje, boolean leido, Date enviadoAt, String mensaje) {
        this.idmensaje = idmensaje;
        this.leido = leido;
        this.enviadoAt = enviadoAt;
        this.mensaje = mensaje;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public boolean getLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Date getEnviadoAt() {
        return enviadoAt;
    }

    public void setEnviadoAt(Date enviadoAt) {
        this.enviadoAt = enviadoAt;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Persona getIdpersonaDestino() {
        return idpersonaDestino;
    }

    public void setIdpersonaDestino(Persona idpersonaDestino) {
        this.idpersonaDestino = idpersonaDestino;
    }

    public Persona getIdpersonaOrigen() {
        return idpersonaOrigen;
    }

    public void setIdpersonaOrigen(Persona idpersonaOrigen) {
        this.idpersonaOrigen = idpersonaOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensaje != null ? idmensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatmensaje)) {
            return false;
        }
        Chatmensaje other = (Chatmensaje) object;
        if ((this.idmensaje == null && other.idmensaje != null) || (this.idmensaje != null && !this.idmensaje.equals(other.idmensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Chatmensaje[ idmensaje=" + idmensaje + " ]";
    }
    
}
