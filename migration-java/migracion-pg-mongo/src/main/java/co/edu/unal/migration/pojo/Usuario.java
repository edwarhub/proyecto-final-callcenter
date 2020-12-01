/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByIsactivo", query = "SELECT u FROM Usuario u WHERE u.isactivo = :isactivo")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByLoginUser", query = "SELECT u FROM Usuario u WHERE u.loginUser = :loginUser")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @Column(name = "isactivo")
    private boolean isactivo;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "login_user")
    private String loginUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<ModSeguridadPerfilHasUsuario> modSeguridadPerfilHasUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Agenteestado> agenteestadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<PerfilHasUsuario> perfilHasUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioCreated")
    private Collection<Campanabasedatos> campanabasedatosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioCreated")
    private Collection<Telefono> telefonoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Telefono> telefonoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Festivo> festivoCollection;
    @OneToMany(mappedBy = "idusuarioCreated")
    private Collection<Persona> personaCollection;
    @OneToMany(mappedBy = "idusuarioUpdated")
    private Collection<Persona> personaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioCreated")
    private Collection<Direccion> direccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Direccion> direccionCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<ModMonitoreoSesion> modMonitoreoSesionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioCreated")
    private Collection<Guion> guionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Guion> guionCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<ModInformeConcurrencia> modInformeConcurrenciaCollection;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Extensiongrupo> extensiongrupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Extension> extensionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<InformeUsuario> informeUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Campanacampo> campanacampoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Cola> colaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<TroncalMarcado> troncalMarcadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioCreated")
    private Collection<Llamadagestion> llamadagestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Audio> audioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<ModInformeUsuario> modInformeUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Ivr> ivrCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioCreated")
    private Collection<Campana> campanaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Campana> campanaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Sucursal> sucursalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<Troncal> troncalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioUpdated")
    private Collection<ModConfigSystemparam> modConfigSystemparamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Collection<InformeConcurrencia> informeConcurrenciaCollection;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, boolean isactivo, String contrasena, String loginUser) {
        this.idusuario = idusuario;
        this.isactivo = isactivo;
        this.contrasena = contrasena;
        this.loginUser = loginUser;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public boolean getIsactivo() {
        return isactivo;
    }

    public void setIsactivo(boolean isactivo) {
        this.isactivo = isactivo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    @XmlTransient
    public Collection<ModSeguridadPerfilHasUsuario> getModSeguridadPerfilHasUsuarioCollection() {
        return modSeguridadPerfilHasUsuarioCollection;
    }

    public void setModSeguridadPerfilHasUsuarioCollection(Collection<ModSeguridadPerfilHasUsuario> modSeguridadPerfilHasUsuarioCollection) {
        this.modSeguridadPerfilHasUsuarioCollection = modSeguridadPerfilHasUsuarioCollection;
    }

    @XmlTransient
    public Collection<Agenteestado> getAgenteestadoCollection() {
        return agenteestadoCollection;
    }

    public void setAgenteestadoCollection(Collection<Agenteestado> agenteestadoCollection) {
        this.agenteestadoCollection = agenteestadoCollection;
    }

    @XmlTransient
    public Collection<PerfilHasUsuario> getPerfilHasUsuarioCollection() {
        return perfilHasUsuarioCollection;
    }

    public void setPerfilHasUsuarioCollection(Collection<PerfilHasUsuario> perfilHasUsuarioCollection) {
        this.perfilHasUsuarioCollection = perfilHasUsuarioCollection;
    }

    @XmlTransient
    public Collection<Campanabasedatos> getCampanabasedatosCollection() {
        return campanabasedatosCollection;
    }

    public void setCampanabasedatosCollection(Collection<Campanabasedatos> campanabasedatosCollection) {
        this.campanabasedatosCollection = campanabasedatosCollection;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection() {
        return telefonoCollection;
    }

    public void setTelefonoCollection(Collection<Telefono> telefonoCollection) {
        this.telefonoCollection = telefonoCollection;
    }

    @XmlTransient
    public Collection<Telefono> getTelefonoCollection1() {
        return telefonoCollection1;
    }

    public void setTelefonoCollection1(Collection<Telefono> telefonoCollection1) {
        this.telefonoCollection1 = telefonoCollection1;
    }

    @XmlTransient
    public Collection<Festivo> getFestivoCollection() {
        return festivoCollection;
    }

    public void setFestivoCollection(Collection<Festivo> festivoCollection) {
        this.festivoCollection = festivoCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection1() {
        return personaCollection1;
    }

    public void setPersonaCollection1(Collection<Persona> personaCollection1) {
        this.personaCollection1 = personaCollection1;
    }

    @XmlTransient
    public Collection<Direccion> getDireccionCollection() {
        return direccionCollection;
    }

    public void setDireccionCollection(Collection<Direccion> direccionCollection) {
        this.direccionCollection = direccionCollection;
    }

    @XmlTransient
    public Collection<Direccion> getDireccionCollection1() {
        return direccionCollection1;
    }

    public void setDireccionCollection1(Collection<Direccion> direccionCollection1) {
        this.direccionCollection1 = direccionCollection1;
    }

    @XmlTransient
    public Collection<ModMonitoreoSesion> getModMonitoreoSesionCollection() {
        return modMonitoreoSesionCollection;
    }

    public void setModMonitoreoSesionCollection(Collection<ModMonitoreoSesion> modMonitoreoSesionCollection) {
        this.modMonitoreoSesionCollection = modMonitoreoSesionCollection;
    }

    @XmlTransient
    public Collection<Guion> getGuionCollection() {
        return guionCollection;
    }

    public void setGuionCollection(Collection<Guion> guionCollection) {
        this.guionCollection = guionCollection;
    }

    @XmlTransient
    public Collection<Guion> getGuionCollection1() {
        return guionCollection1;
    }

    public void setGuionCollection1(Collection<Guion> guionCollection1) {
        this.guionCollection1 = guionCollection1;
    }

    @XmlTransient
    public Collection<ModInformeConcurrencia> getModInformeConcurrenciaCollection() {
        return modInformeConcurrenciaCollection;
    }

    public void setModInformeConcurrenciaCollection(Collection<ModInformeConcurrencia> modInformeConcurrenciaCollection) {
        this.modInformeConcurrenciaCollection = modInformeConcurrenciaCollection;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @XmlTransient
    public Collection<Extensiongrupo> getExtensiongrupoCollection() {
        return extensiongrupoCollection;
    }

    public void setExtensiongrupoCollection(Collection<Extensiongrupo> extensiongrupoCollection) {
        this.extensiongrupoCollection = extensiongrupoCollection;
    }

    @XmlTransient
    public Collection<Extension> getExtensionCollection() {
        return extensionCollection;
    }

    public void setExtensionCollection(Collection<Extension> extensionCollection) {
        this.extensionCollection = extensionCollection;
    }

    @XmlTransient
    public Collection<InformeUsuario> getInformeUsuarioCollection() {
        return informeUsuarioCollection;
    }

    public void setInformeUsuarioCollection(Collection<InformeUsuario> informeUsuarioCollection) {
        this.informeUsuarioCollection = informeUsuarioCollection;
    }

    @XmlTransient
    public Collection<Campanacampo> getCampanacampoCollection() {
        return campanacampoCollection;
    }

    public void setCampanacampoCollection(Collection<Campanacampo> campanacampoCollection) {
        this.campanacampoCollection = campanacampoCollection;
    }

    @XmlTransient
    public Collection<Cola> getColaCollection() {
        return colaCollection;
    }

    public void setColaCollection(Collection<Cola> colaCollection) {
        this.colaCollection = colaCollection;
    }

    @XmlTransient
    public Collection<TroncalMarcado> getTroncalMarcadoCollection() {
        return troncalMarcadoCollection;
    }

    public void setTroncalMarcadoCollection(Collection<TroncalMarcado> troncalMarcadoCollection) {
        this.troncalMarcadoCollection = troncalMarcadoCollection;
    }

    @XmlTransient
    public Collection<Llamadagestion> getLlamadagestionCollection() {
        return llamadagestionCollection;
    }

    public void setLlamadagestionCollection(Collection<Llamadagestion> llamadagestionCollection) {
        this.llamadagestionCollection = llamadagestionCollection;
    }

    @XmlTransient
    public Collection<Audio> getAudioCollection() {
        return audioCollection;
    }

    public void setAudioCollection(Collection<Audio> audioCollection) {
        this.audioCollection = audioCollection;
    }

    @XmlTransient
    public Collection<ModInformeUsuario> getModInformeUsuarioCollection() {
        return modInformeUsuarioCollection;
    }

    public void setModInformeUsuarioCollection(Collection<ModInformeUsuario> modInformeUsuarioCollection) {
        this.modInformeUsuarioCollection = modInformeUsuarioCollection;
    }

    @XmlTransient
    public Collection<Ivr> getIvrCollection() {
        return ivrCollection;
    }

    public void setIvrCollection(Collection<Ivr> ivrCollection) {
        this.ivrCollection = ivrCollection;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection() {
        return campanaCollection;
    }

    public void setCampanaCollection(Collection<Campana> campanaCollection) {
        this.campanaCollection = campanaCollection;
    }

    @XmlTransient
    public Collection<Campana> getCampanaCollection1() {
        return campanaCollection1;
    }

    public void setCampanaCollection1(Collection<Campana> campanaCollection1) {
        this.campanaCollection1 = campanaCollection1;
    }

    @XmlTransient
    public Collection<Sucursal> getSucursalCollection() {
        return sucursalCollection;
    }

    public void setSucursalCollection(Collection<Sucursal> sucursalCollection) {
        this.sucursalCollection = sucursalCollection;
    }

    @XmlTransient
    public Collection<Troncal> getTroncalCollection() {
        return troncalCollection;
    }

    public void setTroncalCollection(Collection<Troncal> troncalCollection) {
        this.troncalCollection = troncalCollection;
    }

    @XmlTransient
    public Collection<ModConfigSystemparam> getModConfigSystemparamCollection() {
        return modConfigSystemparamCollection;
    }

    public void setModConfigSystemparamCollection(Collection<ModConfigSystemparam> modConfigSystemparamCollection) {
        this.modConfigSystemparamCollection = modConfigSystemparamCollection;
    }

    @XmlTransient
    public Collection<InformeConcurrencia> getInformeConcurrenciaCollection() {
        return informeConcurrenciaCollection;
    }

    public void setInformeConcurrenciaCollection(Collection<InformeConcurrencia> informeConcurrenciaCollection) {
        this.informeConcurrenciaCollection = informeConcurrenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
