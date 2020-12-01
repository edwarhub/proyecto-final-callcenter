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
@Table(name = "pbx_cdr_asterisk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PbxCdrAsterisk.findAll", query = "SELECT p FROM PbxCdrAsterisk p")
    , @NamedQuery(name = "PbxCdrAsterisk.findByIdcdr", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.idcdr = :idcdr")
    , @NamedQuery(name = "PbxCdrAsterisk.findByCalldate", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.calldate = :calldate")
    , @NamedQuery(name = "PbxCdrAsterisk.findByClid", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.clid = :clid")
    , @NamedQuery(name = "PbxCdrAsterisk.findBySrc", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.src = :src")
    , @NamedQuery(name = "PbxCdrAsterisk.findByDst", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.dst = :dst")
    , @NamedQuery(name = "PbxCdrAsterisk.findByDcontext", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.dcontext = :dcontext")
    , @NamedQuery(name = "PbxCdrAsterisk.findByChannel", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.channel = :channel")
    , @NamedQuery(name = "PbxCdrAsterisk.findByDstchannel", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.dstchannel = :dstchannel")
    , @NamedQuery(name = "PbxCdrAsterisk.findByLastapp", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.lastapp = :lastapp")
    , @NamedQuery(name = "PbxCdrAsterisk.findByLastdata", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.lastdata = :lastdata")
    , @NamedQuery(name = "PbxCdrAsterisk.findByDuration", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.duration = :duration")
    , @NamedQuery(name = "PbxCdrAsterisk.findByBillsec", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.billsec = :billsec")
    , @NamedQuery(name = "PbxCdrAsterisk.findByDisposition", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.disposition = :disposition")
    , @NamedQuery(name = "PbxCdrAsterisk.findByAmaflags", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.amaflags = :amaflags")
    , @NamedQuery(name = "PbxCdrAsterisk.findByAccountcode", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.accountcode = :accountcode")
    , @NamedQuery(name = "PbxCdrAsterisk.findByUniqueid", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.uniqueid = :uniqueid")
    , @NamedQuery(name = "PbxCdrAsterisk.findByUserfield", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.userfield = :userfield")
    , @NamedQuery(name = "PbxCdrAsterisk.findByPearaccount", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.pearaccount = :pearaccount")
    , @NamedQuery(name = "PbxCdrAsterisk.findByLinkedid", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.linkedid = :linkedid")
    , @NamedQuery(name = "PbxCdrAsterisk.findBySequence", query = "SELECT p FROM PbxCdrAsterisk p WHERE p.sequence = :sequence")})
public class PbxCdrAsterisk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcdr")
    private Long idcdr;
    @Basic(optional = false)
    @Column(name = "calldate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calldate;
    @Basic(optional = false)
    @Column(name = "clid")
    private String clid;
    @Basic(optional = false)
    @Column(name = "src")
    private String src;
    @Basic(optional = false)
    @Column(name = "dst")
    private String dst;
    @Basic(optional = false)
    @Column(name = "dcontext")
    private String dcontext;
    @Basic(optional = false)
    @Column(name = "channel")
    private String channel;
    @Basic(optional = false)
    @Column(name = "dstchannel")
    private String dstchannel;
    @Basic(optional = false)
    @Column(name = "lastapp")
    private String lastapp;
    @Basic(optional = false)
    @Column(name = "lastdata")
    private String lastdata;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "billsec")
    private int billsec;
    @Basic(optional = false)
    @Column(name = "disposition")
    private String disposition;
    @Basic(optional = false)
    @Column(name = "amaflags")
    private int amaflags;
    @Basic(optional = false)
    @Column(name = "accountcode")
    private String accountcode;
    @Basic(optional = false)
    @Column(name = "uniqueid")
    private String uniqueid;
    @Basic(optional = false)
    @Column(name = "userfield")
    private String userfield;
    @Basic(optional = false)
    @Column(name = "pearaccount")
    private String pearaccount;
    @Basic(optional = false)
    @Column(name = "linkedid")
    private String linkedid;
    @Basic(optional = false)
    @Column(name = "sequence")
    private long sequence;

    public PbxCdrAsterisk() {
    }

    public PbxCdrAsterisk(Long idcdr) {
        this.idcdr = idcdr;
    }

    public PbxCdrAsterisk(Long idcdr, Date calldate, String clid, String src, String dst, String dcontext, String channel, String dstchannel, String lastapp, String lastdata, int duration, int billsec, String disposition, int amaflags, String accountcode, String uniqueid, String userfield, String pearaccount, String linkedid, long sequence) {
        this.idcdr = idcdr;
        this.calldate = calldate;
        this.clid = clid;
        this.src = src;
        this.dst = dst;
        this.dcontext = dcontext;
        this.channel = channel;
        this.dstchannel = dstchannel;
        this.lastapp = lastapp;
        this.lastdata = lastdata;
        this.duration = duration;
        this.billsec = billsec;
        this.disposition = disposition;
        this.amaflags = amaflags;
        this.accountcode = accountcode;
        this.uniqueid = uniqueid;
        this.userfield = userfield;
        this.pearaccount = pearaccount;
        this.linkedid = linkedid;
        this.sequence = sequence;
    }

    public Long getIdcdr() {
        return idcdr;
    }

    public void setIdcdr(Long idcdr) {
        this.idcdr = idcdr;
    }

    public Date getCalldate() {
        return calldate;
    }

    public void setCalldate(Date calldate) {
        this.calldate = calldate;
    }

    public String getClid() {
        return clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getDcontext() {
        return dcontext;
    }

    public void setDcontext(String dcontext) {
        this.dcontext = dcontext;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDstchannel() {
        return dstchannel;
    }

    public void setDstchannel(String dstchannel) {
        this.dstchannel = dstchannel;
    }

    public String getLastapp() {
        return lastapp;
    }

    public void setLastapp(String lastapp) {
        this.lastapp = lastapp;
    }

    public String getLastdata() {
        return lastdata;
    }

    public void setLastdata(String lastdata) {
        this.lastdata = lastdata;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBillsec() {
        return billsec;
    }

    public void setBillsec(int billsec) {
        this.billsec = billsec;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public int getAmaflags() {
        return amaflags;
    }

    public void setAmaflags(int amaflags) {
        this.amaflags = amaflags;
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getUserfield() {
        return userfield;
    }

    public void setUserfield(String userfield) {
        this.userfield = userfield;
    }

    public String getPearaccount() {
        return pearaccount;
    }

    public void setPearaccount(String pearaccount) {
        this.pearaccount = pearaccount;
    }

    public String getLinkedid() {
        return linkedid;
    }

    public void setLinkedid(String linkedid) {
        this.linkedid = linkedid;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcdr != null ? idcdr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PbxCdrAsterisk)) {
            return false;
        }
        PbxCdrAsterisk other = (PbxCdrAsterisk) object;
        if ((this.idcdr == null && other.idcdr != null) || (this.idcdr != null && !this.idcdr.equals(other.idcdr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.PbxCdrAsterisk[ idcdr=" + idcdr + " ]";
    }
    
}
