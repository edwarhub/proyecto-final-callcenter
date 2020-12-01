/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo.json;

/**
 *
 * @author edwar
 */
public class AgenteJson {
    Integer idagente;
    String nombre;
    String numdocumento;
    String email;
    String ext;

    public Integer getIdagente() {
        return idagente;
    }

    public void setIdagente(Integer idagente) {
        this.idagente = idagente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(String numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
    
    
}
