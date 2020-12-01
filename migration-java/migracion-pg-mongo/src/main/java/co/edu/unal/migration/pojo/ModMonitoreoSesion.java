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
@Table(name = "mod_monitoreo_sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModMonitoreoSesion.findAll", query = "SELECT m FROM ModMonitoreoSesion m")
    , @NamedQuery(name = "ModMonitoreoSesion.findByIdsesion", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.idsesion = :idsesion")
    , @NamedQuery(name = "ModMonitoreoSesion.findBySistemaOperativo", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.sistemaOperativo = :sistemaOperativo")
    , @NamedQuery(name = "ModMonitoreoSesion.findByNavegador", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.navegador = :navegador")
    , @NamedQuery(name = "ModMonitoreoSesion.findByIp", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.ip = :ip")
    , @NamedQuery(name = "ModMonitoreoSesion.findByFechaIngreso", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "ModMonitoreoSesion.findByAplicacion", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.aplicacion = :aplicacion")
    , @NamedQuery(name = "ModMonitoreoSesion.findByFechaSalida", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "ModMonitoreoSesion.findByHeader", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.header = :header")
    , @NamedQuery(name = "ModMonitoreoSesion.findByFechaRefesh", query = "SELECT m FROM ModMonitoreoSesion m WHERE m.fechaRefesh = :fechaRefesh")})
public class ModMonitoreoSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsesion")
    private Long idsesion;
    @Basic(optional = false)
    @Column(name = "sistema_operativo")
    private String sistemaOperativo;
    @Basic(optional = false)
    @Column(name = "navegador")
    private String navegador;
    @Basic(optional = false)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "aplicacion")
    private String aplicacion;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "header")
    private String header;
    @Basic(optional = false)
    @Column(name = "fecha_refesh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRefesh;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public ModMonitoreoSesion() {
    }

    public ModMonitoreoSesion(Long idsesion) {
        this.idsesion = idsesion;
    }

    public ModMonitoreoSesion(Long idsesion, String sistemaOperativo, String navegador, String ip, Date fechaIngreso, String aplicacion, String header, Date fechaRefesh) {
        this.idsesion = idsesion;
        this.sistemaOperativo = sistemaOperativo;
        this.navegador = navegador;
        this.ip = ip;
        this.fechaIngreso = fechaIngreso;
        this.aplicacion = aplicacion;
        this.header = header;
        this.fechaRefesh = fechaRefesh;
    }

    public Long getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(Long idsesion) {
        this.idsesion = idsesion;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getFechaRefesh() {
        return fechaRefesh;
    }

    public void setFechaRefesh(Date fechaRefesh) {
        this.fechaRefesh = fechaRefesh;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsesion != null ? idsesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModMonitoreoSesion)) {
            return false;
        }
        ModMonitoreoSesion other = (ModMonitoreoSesion) object;
        if ((this.idsesion == null && other.idsesion != null) || (this.idsesion != null && !this.idsesion.equals(other.idsesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ModMonitoreoSesion[ idsesion=" + idsesion + " ]";
    }
    
}
