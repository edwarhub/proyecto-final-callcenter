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
@Table(name = "campana")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campana.findAll", query = "SELECT c FROM Campana c")
    , @NamedQuery(name = "Campana.findByIdcampana", query = "SELECT c FROM Campana c WHERE c.idcampana = :idcampana")
    , @NamedQuery(name = "Campana.findByNombre", query = "SELECT c FROM Campana c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Campana.findByIsActiva", query = "SELECT c FROM Campana c WHERE c.isActiva = :isActiva")
    , @NamedQuery(name = "Campana.findByObservaciones", query = "SELECT c FROM Campana c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "Campana.findByCreatedAt", query = "SELECT c FROM Campana c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "Campana.findByUpdatedAt", query = "SELECT c FROM Campana c WHERE c.updatedAt = :updatedAt")
    , @NamedQuery(name = "Campana.findByTipo", query = "SELECT c FROM Campana c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Campana.findByEntradaObligaPersona", query = "SELECT c FROM Campana c WHERE c.entradaObligaPersona = :entradaObligaPersona")
    , @NamedQuery(name = "Campana.findByMarcadorTipo", query = "SELECT c FROM Campana c WHERE c.marcadorTipo = :marcadorTipo")
    , @NamedQuery(name = "Campana.findByMarcadorAccion", query = "SELECT c FROM Campana c WHERE c.marcadorAccion = :marcadorAccion")
    , @NamedQuery(name = "Campana.findByMarcadorLlamadasExtra", query = "SELECT c FROM Campana c WHERE c.marcadorLlamadasExtra = :marcadorLlamadasExtra")
    , @NamedQuery(name = "Campana.findByMarcadorNumReintentos", query = "SELECT c FROM Campana c WHERE c.marcadorNumReintentos = :marcadorNumReintentos")
    , @NamedQuery(name = "Campana.findByMarcadorHorarioXml", query = "SELECT c FROM Campana c WHERE c.marcadorHorarioXml = :marcadorHorarioXml")
    , @NamedQuery(name = "Campana.findByMarcadorAplicacionId", query = "SELECT c FROM Campana c WHERE c.marcadorAplicacionId = :marcadorAplicacionId")
    , @NamedQuery(name = "Campana.findByFuncionaFestivos", query = "SELECT c FROM Campana c WHERE c.funcionaFestivos = :funcionaFestivos")})
public class Campana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcampana")
    private Integer idcampana;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "is_activa")
    private boolean isActiva;
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "entrada_obliga_persona")
    private boolean entradaObligaPersona;
    @Column(name = "marcador_tipo")
    private String marcadorTipo;
    @Column(name = "marcador_accion")
    private String marcadorAccion;
    @Column(name = "marcador_llamadas_extra")
    private Integer marcadorLlamadasExtra;
    @Column(name = "marcador_num_reintentos")
    private Integer marcadorNumReintentos;
    @Column(name = "marcador_horario_xml")
    private String marcadorHorarioXml;
    @Column(name = "marcador_aplicacion_id")
    private Integer marcadorAplicacionId;
    @Basic(optional = false)
    @Column(name = "funciona_festivos")
    private boolean funcionaFestivos;
    @OneToMany(mappedBy = "idcampana")
    private Collection<Llamada> llamadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampana")
    private Collection<Campanabasedatos> campanabasedatosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampana")
    private Collection<Campanahorario> campanahorarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampana")
    private Collection<Campanacampo> campanacampoCollection;
    @OneToMany(mappedBy = "idcampanaProxLlamada")
    private Collection<Agente> agenteCollection;
    @OneToMany(mappedBy = "idcampana")
    private Collection<IvrOpcion> ivrOpcionCollection;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Clientecorporativo idcliente;
    @JoinColumn(name = "idaudio_horario_fuera", referencedColumnName = "idaudio")
    @ManyToOne
    private Audio idaudioHorarioFuera;
    @JoinColumn(name = "marcador_acc_idaudio", referencedColumnName = "idaudio")
    @ManyToOne
    private Audio marcadorAccIdaudio;
    @JoinColumn(name = "idcola", referencedColumnName = "idcola")
    @ManyToOne(optional = false)
    private Cola idcola;
    @JoinColumn(name = "marcador_acc_idcola", referencedColumnName = "idcola")
    @ManyToOne
    private Cola marcadorAccIdcola;
    @JoinColumn(name = "marcador_acc_idextension", referencedColumnName = "idextension")
    @ManyToOne
    private Extension marcadorAccIdextension;
    @JoinColumn(name = "idguion", referencedColumnName = "idguion")
    @ManyToOne
    private Guion idguion;
    @JoinColumn(name = "marcador_acc_idivr", referencedColumnName = "idivr")
    @ManyToOne
    private Ivr marcadorAccIdivr;
    @JoinColumn(name = "idusuario_created", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioCreated;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuarioUpdated;
    @JoinColumn(name = "marcado_idregla_cel", referencedColumnName = "idregla")
    @ManyToOne
    private TroncalMarcado marcadoIdreglaCel;
    @JoinColumn(name = "marcado_idregla_fijo", referencedColumnName = "idregla")
    @ManyToOne
    private TroncalMarcado marcadoIdreglaFijo;
    @JoinColumn(name = "marcado_idregla_fijo_nal", referencedColumnName = "idregla")
    @ManyToOne
    private TroncalMarcado marcadoIdreglaFijoNal;

    public Campana() {
    }

    public Campana(Integer idcampana) {
        this.idcampana = idcampana;
    }

    public Campana(Integer idcampana, String nombre, boolean isActiva, Date createdAt, Date updatedAt, String tipo, boolean entradaObligaPersona, boolean funcionaFestivos) {
        this.idcampana = idcampana;
        this.nombre = nombre;
        this.isActiva = isActiva;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tipo = tipo;
        this.entradaObligaPersona = entradaObligaPersona;
        this.funcionaFestivos = funcionaFestivos;
    }

    public Integer getIdcampana() {
        return idcampana;
    }

    public void setIdcampana(Integer idcampana) {
        this.idcampana = idcampana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getIsActiva() {
        return isActiva;
    }

    public void setIsActiva(boolean isActiva) {
        this.isActiva = isActiva;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getEntradaObligaPersona() {
        return entradaObligaPersona;
    }

    public void setEntradaObligaPersona(boolean entradaObligaPersona) {
        this.entradaObligaPersona = entradaObligaPersona;
    }

    public String getMarcadorTipo() {
        return marcadorTipo;
    }

    public void setMarcadorTipo(String marcadorTipo) {
        this.marcadorTipo = marcadorTipo;
    }

    public String getMarcadorAccion() {
        return marcadorAccion;
    }

    public void setMarcadorAccion(String marcadorAccion) {
        this.marcadorAccion = marcadorAccion;
    }

    public Integer getMarcadorLlamadasExtra() {
        return marcadorLlamadasExtra;
    }

    public void setMarcadorLlamadasExtra(Integer marcadorLlamadasExtra) {
        this.marcadorLlamadasExtra = marcadorLlamadasExtra;
    }

    public Integer getMarcadorNumReintentos() {
        return marcadorNumReintentos;
    }

    public void setMarcadorNumReintentos(Integer marcadorNumReintentos) {
        this.marcadorNumReintentos = marcadorNumReintentos;
    }

    public String getMarcadorHorarioXml() {
        return marcadorHorarioXml;
    }

    public void setMarcadorHorarioXml(String marcadorHorarioXml) {
        this.marcadorHorarioXml = marcadorHorarioXml;
    }

    public Integer getMarcadorAplicacionId() {
        return marcadorAplicacionId;
    }

    public void setMarcadorAplicacionId(Integer marcadorAplicacionId) {
        this.marcadorAplicacionId = marcadorAplicacionId;
    }

    public boolean getFuncionaFestivos() {
        return funcionaFestivos;
    }

    public void setFuncionaFestivos(boolean funcionaFestivos) {
        this.funcionaFestivos = funcionaFestivos;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
    }

    @XmlTransient
    public Collection<Campanabasedatos> getCampanabasedatosCollection() {
        return campanabasedatosCollection;
    }

    public void setCampanabasedatosCollection(Collection<Campanabasedatos> campanabasedatosCollection) {
        this.campanabasedatosCollection = campanabasedatosCollection;
    }

    @XmlTransient
    public Collection<Campanahorario> getCampanahorarioCollection() {
        return campanahorarioCollection;
    }

    public void setCampanahorarioCollection(Collection<Campanahorario> campanahorarioCollection) {
        this.campanahorarioCollection = campanahorarioCollection;
    }

    @XmlTransient
    public Collection<Campanacampo> getCampanacampoCollection() {
        return campanacampoCollection;
    }

    public void setCampanacampoCollection(Collection<Campanacampo> campanacampoCollection) {
        this.campanacampoCollection = campanacampoCollection;
    }

    @XmlTransient
    public Collection<Agente> getAgenteCollection() {
        return agenteCollection;
    }

    public void setAgenteCollection(Collection<Agente> agenteCollection) {
        this.agenteCollection = agenteCollection;
    }

    @XmlTransient
    public Collection<IvrOpcion> getIvrOpcionCollection() {
        return ivrOpcionCollection;
    }

    public void setIvrOpcionCollection(Collection<IvrOpcion> ivrOpcionCollection) {
        this.ivrOpcionCollection = ivrOpcionCollection;
    }

    public Clientecorporativo getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientecorporativo idcliente) {
        this.idcliente = idcliente;
    }

    public Audio getIdaudioHorarioFuera() {
        return idaudioHorarioFuera;
    }

    public void setIdaudioHorarioFuera(Audio idaudioHorarioFuera) {
        this.idaudioHorarioFuera = idaudioHorarioFuera;
    }

    public Audio getMarcadorAccIdaudio() {
        return marcadorAccIdaudio;
    }

    public void setMarcadorAccIdaudio(Audio marcadorAccIdaudio) {
        this.marcadorAccIdaudio = marcadorAccIdaudio;
    }

    public Cola getIdcola() {
        return idcola;
    }

    public void setIdcola(Cola idcola) {
        this.idcola = idcola;
    }

    public Cola getMarcadorAccIdcola() {
        return marcadorAccIdcola;
    }

    public void setMarcadorAccIdcola(Cola marcadorAccIdcola) {
        this.marcadorAccIdcola = marcadorAccIdcola;
    }

    public Extension getMarcadorAccIdextension() {
        return marcadorAccIdextension;
    }

    public void setMarcadorAccIdextension(Extension marcadorAccIdextension) {
        this.marcadorAccIdextension = marcadorAccIdextension;
    }

    public Guion getIdguion() {
        return idguion;
    }

    public void setIdguion(Guion idguion) {
        this.idguion = idguion;
    }

    public Ivr getMarcadorAccIdivr() {
        return marcadorAccIdivr;
    }

    public void setMarcadorAccIdivr(Ivr marcadorAccIdivr) {
        this.marcadorAccIdivr = marcadorAccIdivr;
    }

    public Usuario getIdusuarioCreated() {
        return idusuarioCreated;
    }

    public void setIdusuarioCreated(Usuario idusuarioCreated) {
        this.idusuarioCreated = idusuarioCreated;
    }

    public Usuario getIdusuarioUpdated() {
        return idusuarioUpdated;
    }

    public void setIdusuarioUpdated(Usuario idusuarioUpdated) {
        this.idusuarioUpdated = idusuarioUpdated;
    }

    public TroncalMarcado getMarcadoIdreglaCel() {
        return marcadoIdreglaCel;
    }

    public void setMarcadoIdreglaCel(TroncalMarcado marcadoIdreglaCel) {
        this.marcadoIdreglaCel = marcadoIdreglaCel;
    }

    public TroncalMarcado getMarcadoIdreglaFijo() {
        return marcadoIdreglaFijo;
    }

    public void setMarcadoIdreglaFijo(TroncalMarcado marcadoIdreglaFijo) {
        this.marcadoIdreglaFijo = marcadoIdreglaFijo;
    }

    public TroncalMarcado getMarcadoIdreglaFijoNal() {
        return marcadoIdreglaFijoNal;
    }

    public void setMarcadoIdreglaFijoNal(TroncalMarcado marcadoIdreglaFijoNal) {
        this.marcadoIdreglaFijoNal = marcadoIdreglaFijoNal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampana != null ? idcampana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campana)) {
            return false;
        }
        Campana other = (Campana) object;
        if ((this.idcampana == null && other.idcampana != null) || (this.idcampana != null && !this.idcampana.equals(other.idcampana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Campana[ idcampana=" + idcampana + " ]";
    }
    
}
