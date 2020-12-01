/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwar
 */
@Entity
@Table(name = "cliente_webservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteWebservice.findAll", query = "SELECT c FROM ClienteWebservice c")
    , @NamedQuery(name = "ClienteWebservice.findByIdwebservice", query = "SELECT c FROM ClienteWebservice c WHERE c.idwebservice = :idwebservice")
    , @NamedQuery(name = "ClienteWebservice.findByNombre", query = "SELECT c FROM ClienteWebservice c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ClienteWebservice.findByTipo", query = "SELECT c FROM ClienteWebservice c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "ClienteWebservice.findByUri", query = "SELECT c FROM ClienteWebservice c WHERE c.uri = :uri")
    , @NamedQuery(name = "ClienteWebservice.findByPath", query = "SELECT c FROM ClienteWebservice c WHERE c.path = :path")
    , @NamedQuery(name = "ClienteWebservice.findByUsuario", query = "SELECT c FROM ClienteWebservice c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "ClienteWebservice.findByLlave", query = "SELECT c FROM ClienteWebservice c WHERE c.llave = :llave")
    , @NamedQuery(name = "ClienteWebservice.findByParamXml", query = "SELECT c FROM ClienteWebservice c WHERE c.paramXml = :paramXml")})
public class ClienteWebservice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idwebservice")
    private Integer idwebservice;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "uri")
    private String uri;
    @Column(name = "path")
    private String path;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "llave")
    private String llave;
    @Column(name = "param_xml")
    private String paramXml;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Clientecorporativo idcliente;

    public ClienteWebservice() {
    }

    public ClienteWebservice(Integer idwebservice) {
        this.idwebservice = idwebservice;
    }

    public ClienteWebservice(Integer idwebservice, String nombre, String tipo) {
        this.idwebservice = idwebservice;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getIdwebservice() {
        return idwebservice;
    }

    public void setIdwebservice(Integer idwebservice) {
        this.idwebservice = idwebservice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getParamXml() {
        return paramXml;
    }

    public void setParamXml(String paramXml) {
        this.paramXml = paramXml;
    }

    public Clientecorporativo getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientecorporativo idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idwebservice != null ? idwebservice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteWebservice)) {
            return false;
        }
        ClienteWebservice other = (ClienteWebservice) object;
        if ((this.idwebservice == null && other.idwebservice != null) || (this.idwebservice != null && !this.idwebservice.equals(other.idwebservice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unal.migration.pojo.ClienteWebservice[ idwebservice=" + idwebservice + " ]";
    }
    
}
