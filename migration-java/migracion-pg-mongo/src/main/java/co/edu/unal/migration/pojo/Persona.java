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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona")
    , @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Persona.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Persona.findByNumdocumento", query = "SELECT p FROM Persona p WHERE p.numdocumento = :numdocumento")
    , @NamedQuery(name = "Persona.findByGenero", query = "SELECT p FROM Persona p WHERE p.genero = :genero")
    , @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email")
    , @NamedQuery(name = "Persona.findByCreatedAt", query = "SELECT p FROM Persona p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Persona.findByUpdatedAt", query = "SELECT p FROM Persona p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "Persona.findByPathFotografia", query = "SELECT p FROM Persona p WHERE p.pathFotografia = :pathFotografia")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByClavePbx", query = "SELECT p FROM Persona p WHERE p.clavePbx = :clavePbx")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Integer idpersona;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "numdocumento")
    private long numdocumento;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "path_fotografia")
    private String pathFotografia;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "clave_pbx")
    private String clavePbx;
    @OneToMany(mappedBy = "idpersonaOrigen")
    private Collection<Llamada> llamadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaCreated")
    private Collection<FpqrDireccionamiento> fpqrDireccionamientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaDireccionada")
    private Collection<FpqrDireccionamiento> fpqrDireccionamientoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaDes")
    private Collection<Transferencia> transferenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaOri")
    private Collection<Transferencia> transferenciaCollection1;
    @JoinColumn(name = "iddireccion_residencia", referencedColumnName = "iddireccion")
    @ManyToOne
    private Direccion iddireccionResidencia;
    @JoinColumn(name = "idtipodoc", referencedColumnName = "idtipodoc")
    @ManyToOne(optional = false)
    private Documentotipo idtipodoc;
    @JoinColumn(name = "idextension", referencedColumnName = "idextension")
    @ManyToOne
    private Extension idextension;
    @JoinColumn(name = "idusuario_created", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuarioCreated;
    @JoinColumn(name = "idusuario_updated", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuarioUpdated;
    @OneToMany(mappedBy = "idpersona")
    private Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaContacto")
    private Collection<Clientecorporativo> clientecorporativoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaCreated")
    private Collection<FpqrGestion> fpqrGestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaCreated")
    private Collection<FpqrCierre> fpqrCierreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private Collection<PersonaTelefono> personaTelefonoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaCreated")
    private Collection<Fpqr> fpqrCollection;
    @OneToMany(mappedBy = "idpersonaSolicitante")
    private Collection<Fpqr> fpqrCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private Collection<Agente> agenteCollection;
    @OneToMany(mappedBy = "idpersonaProxLlamada")
    private Collection<Agente> agenteCollection1;
    @OneToMany(mappedBy = "idpersona")
    private Collection<Llamadaprogramada> llamadaprogramadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaDestino")
    private Collection<Chatmensaje> chatmensajeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonaOrigen")
    private Collection<Chatmensaje> chatmensajeCollection1;

    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(Integer idpersona, String nombres, String apellidos, long numdocumento, String genero, String email, Date createdAt, Date updatedAt) {
        this.idpersona = idpersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numdocumento = numdocumento;
        this.genero = genero;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(long numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPathFotografia() {
        return pathFotografia;
    }

    public void setPathFotografia(String pathFotografia) {
        this.pathFotografia = pathFotografia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getClavePbx() {
        return clavePbx;
    }

    public void setClavePbx(String clavePbx) {
        this.clavePbx = clavePbx;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
    }

    @XmlTransient
    public Collection<FpqrDireccionamiento> getFpqrDireccionamientoCollection() {
        return fpqrDireccionamientoCollection;
    }

    public void setFpqrDireccionamientoCollection(Collection<FpqrDireccionamiento> fpqrDireccionamientoCollection) {
        this.fpqrDireccionamientoCollection = fpqrDireccionamientoCollection;
    }

    @XmlTransient
    public Collection<FpqrDireccionamiento> getFpqrDireccionamientoCollection1() {
        return fpqrDireccionamientoCollection1;
    }

    public void setFpqrDireccionamientoCollection1(Collection<FpqrDireccionamiento> fpqrDireccionamientoCollection1) {
        this.fpqrDireccionamientoCollection1 = fpqrDireccionamientoCollection1;
    }

    @XmlTransient
    public Collection<Transferencia> getTransferenciaCollection() {
        return transferenciaCollection;
    }

    public void setTransferenciaCollection(Collection<Transferencia> transferenciaCollection) {
        this.transferenciaCollection = transferenciaCollection;
    }

    @XmlTransient
    public Collection<Transferencia> getTransferenciaCollection1() {
        return transferenciaCollection1;
    }

    public void setTransferenciaCollection1(Collection<Transferencia> transferenciaCollection1) {
        this.transferenciaCollection1 = transferenciaCollection1;
    }

    public Direccion getIddireccionResidencia() {
        return iddireccionResidencia;
    }

    public void setIddireccionResidencia(Direccion iddireccionResidencia) {
        this.iddireccionResidencia = iddireccionResidencia;
    }

    public Documentotipo getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(Documentotipo idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public Extension getIdextension() {
        return idextension;
    }

    public void setIdextension(Extension idextension) {
        this.idextension = idextension;
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

    @XmlTransient
    public Collection<CampanabasedatosHasPersona> getCampanabasedatosHasPersonaCollection() {
        return campanabasedatosHasPersonaCollection;
    }

    public void setCampanabasedatosHasPersonaCollection(Collection<CampanabasedatosHasPersona> campanabasedatosHasPersonaCollection) {
        this.campanabasedatosHasPersonaCollection = campanabasedatosHasPersonaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Clientecorporativo> getClientecorporativoCollection() {
        return clientecorporativoCollection;
    }

    public void setClientecorporativoCollection(Collection<Clientecorporativo> clientecorporativoCollection) {
        this.clientecorporativoCollection = clientecorporativoCollection;
    }

    @XmlTransient
    public Collection<FpqrGestion> getFpqrGestionCollection() {
        return fpqrGestionCollection;
    }

    public void setFpqrGestionCollection(Collection<FpqrGestion> fpqrGestionCollection) {
        this.fpqrGestionCollection = fpqrGestionCollection;
    }

    @XmlTransient
    public Collection<FpqrCierre> getFpqrCierreCollection() {
        return fpqrCierreCollection;
    }

    public void setFpqrCierreCollection(Collection<FpqrCierre> fpqrCierreCollection) {
        this.fpqrCierreCollection = fpqrCierreCollection;
    }

    @XmlTransient
    public Collection<PersonaTelefono> getPersonaTelefonoCollection() {
        return personaTelefonoCollection;
    }

    public void setPersonaTelefonoCollection(Collection<PersonaTelefono> personaTelefonoCollection) {
        this.personaTelefonoCollection = personaTelefonoCollection;
    }

    @XmlTransient
    public Collection<Fpqr> getFpqrCollection() {
        return fpqrCollection;
    }

    public void setFpqrCollection(Collection<Fpqr> fpqrCollection) {
        this.fpqrCollection = fpqrCollection;
    }

    @XmlTransient
    public Collection<Fpqr> getFpqrCollection1() {
        return fpqrCollection1;
    }

    public void setFpqrCollection1(Collection<Fpqr> fpqrCollection1) {
        this.fpqrCollection1 = fpqrCollection1;
    }

    @XmlTransient
    public Collection<Agente> getAgenteCollection() {
        return agenteCollection;
    }

    public void setAgenteCollection(Collection<Agente> agenteCollection) {
        this.agenteCollection = agenteCollection;
    }

    @XmlTransient
    public Collection<Agente> getAgenteCollection1() {
        return agenteCollection1;
    }

    public void setAgenteCollection1(Collection<Agente> agenteCollection1) {
        this.agenteCollection1 = agenteCollection1;
    }

    @XmlTransient
    public Collection<Llamadaprogramada> getLlamadaprogramadaCollection() {
        return llamadaprogramadaCollection;
    }

    public void setLlamadaprogramadaCollection(Collection<Llamadaprogramada> llamadaprogramadaCollection) {
        this.llamadaprogramadaCollection = llamadaprogramadaCollection;
    }

    @XmlTransient
    public Collection<Chatmensaje> getChatmensajeCollection() {
        return chatmensajeCollection;
    }

    public void setChatmensajeCollection(Collection<Chatmensaje> chatmensajeCollection) {
        this.chatmensajeCollection = chatmensajeCollection;
    }

    @XmlTransient
    public Collection<Chatmensaje> getChatmensajeCollection1() {
        return chatmensajeCollection1;
    }

    public void setChatmensajeCollection1(Collection<Chatmensaje> chatmensajeCollection1) {
        this.chatmensajeCollection1 = chatmensajeCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Persona[ idpersona=" + idpersona + " ]";
    }
    
}
