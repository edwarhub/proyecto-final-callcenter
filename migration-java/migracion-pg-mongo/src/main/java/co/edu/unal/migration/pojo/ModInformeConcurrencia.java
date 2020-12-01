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
@Table(name = "mod_informe_concurrencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModInformeConcurrencia.findAll", query = "SELECT m FROM ModInformeConcurrencia m")
    , @NamedQuery(name = "ModInformeConcurrencia.findByIdconcurrencia", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.idconcurrencia = :idconcurrencia")
    , @NamedQuery(name = "ModInformeConcurrencia.findByIdinforme", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.idinforme = :idinforme")
    , @NamedQuery(name = "ModInformeConcurrencia.findByFechaIni", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.fechaIni = :fechaIni")
    , @NamedQuery(name = "ModInformeConcurrencia.findByFechaUpdate", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.fechaUpdate = :fechaUpdate")
    , @NamedQuery(name = "ModInformeConcurrencia.findByPromedioMsPag", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.promedioMsPag = :promedioMsPag")
    , @NamedQuery(name = "ModInformeConcurrencia.findByCount", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.count = :count")
    , @NamedQuery(name = "ModInformeConcurrencia.findByTotalReg", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.totalReg = :totalReg")
    , @NamedQuery(name = "ModInformeConcurrencia.findByIsFinalizado", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.isFinalizado = :isFinalizado")
    , @NamedQuery(name = "ModInformeConcurrencia.findByIsCancelado", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.isCancelado = :isCancelado")
    , @NamedQuery(name = "ModInformeConcurrencia.findByIsGenarchivo", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.isGenarchivo = :isGenarchivo")
    , @NamedQuery(name = "ModInformeConcurrencia.findByPathTmpOut", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.pathTmpOut = :pathTmpOut")
    , @NamedQuery(name = "ModInformeConcurrencia.findByMsgErr", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.msgErr = :msgErr")
    , @NamedQuery(name = "ModInformeConcurrencia.findByMsg", query = "SELECT m FROM ModInformeConcurrencia m WHERE m.msg = :msg")})
public class ModInformeConcurrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconcurrencia")
    private Integer idconcurrencia;
    @Basic(optional = false)
    @Column(name = "idinforme")
    private int idinforme;
    @Basic(optional = false)
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Basic(optional = false)
    @Column(name = "fecha_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUpdate;
    @Basic(optional = false)
    @Column(name = "promedio_ms_pag")
    private long promedioMsPag;
    @Basic(optional = false)
    @Column(name = "count")
    private int count;
    @Basic(optional = false)
    @Column(name = "total_reg")
    private int totalReg;
    @Basic(optional = false)
    @Column(name = "is_finalizado")
    private boolean isFinalizado;
    @Basic(optional = false)
    @Column(name = "is_cancelado")
    private boolean isCancelado;
    @Basic(optional = false)
    @Column(name = "is_genarchivo")
    private boolean isGenarchivo;
    @Basic(optional = false)
    @Column(name = "path_tmp_out")
    private String pathTmpOut;
    @Column(name = "msg_err")
    private String msgErr;
    @Column(name = "msg")
    private String msg;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public ModInformeConcurrencia() {
    }

    public ModInformeConcurrencia(Integer idconcurrencia) {
        this.idconcurrencia = idconcurrencia;
    }

    public ModInformeConcurrencia(Integer idconcurrencia, int idinforme, Date fechaIni, Date fechaUpdate, long promedioMsPag, int count, int totalReg, boolean isFinalizado, boolean isCancelado, boolean isGenarchivo, String pathTmpOut) {
        this.idconcurrencia = idconcurrencia;
        this.idinforme = idinforme;
        this.fechaIni = fechaIni;
        this.fechaUpdate = fechaUpdate;
        this.promedioMsPag = promedioMsPag;
        this.count = count;
        this.totalReg = totalReg;
        this.isFinalizado = isFinalizado;
        this.isCancelado = isCancelado;
        this.isGenarchivo = isGenarchivo;
        this.pathTmpOut = pathTmpOut;
    }

    public Integer getIdconcurrencia() {
        return idconcurrencia;
    }

    public void setIdconcurrencia(Integer idconcurrencia) {
        this.idconcurrencia = idconcurrencia;
    }

    public int getIdinforme() {
        return idinforme;
    }

    public void setIdinforme(int idinforme) {
        this.idinforme = idinforme;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public long getPromedioMsPag() {
        return promedioMsPag;
    }

    public void setPromedioMsPag(long promedioMsPag) {
        this.promedioMsPag = promedioMsPag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalReg() {
        return totalReg;
    }

    public void setTotalReg(int totalReg) {
        this.totalReg = totalReg;
    }

    public boolean getIsFinalizado() {
        return isFinalizado;
    }

    public void setIsFinalizado(boolean isFinalizado) {
        this.isFinalizado = isFinalizado;
    }

    public boolean getIsCancelado() {
        return isCancelado;
    }

    public void setIsCancelado(boolean isCancelado) {
        this.isCancelado = isCancelado;
    }

    public boolean getIsGenarchivo() {
        return isGenarchivo;
    }

    public void setIsGenarchivo(boolean isGenarchivo) {
        this.isGenarchivo = isGenarchivo;
    }

    public String getPathTmpOut() {
        return pathTmpOut;
    }

    public void setPathTmpOut(String pathTmpOut) {
        this.pathTmpOut = pathTmpOut;
    }

    public String getMsgErr() {
        return msgErr;
    }

    public void setMsgErr(String msgErr) {
        this.msgErr = msgErr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
        hash += (idconcurrencia != null ? idconcurrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModInformeConcurrencia)) {
            return false;
        }
        ModInformeConcurrencia other = (ModInformeConcurrencia) object;
        if ((this.idconcurrencia == null && other.idconcurrencia != null) || (this.idconcurrencia != null && !this.idconcurrencia.equals(other.idconcurrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ModInformeConcurrencia[ idconcurrencia=" + idconcurrencia + " ]";
    }
    
}
