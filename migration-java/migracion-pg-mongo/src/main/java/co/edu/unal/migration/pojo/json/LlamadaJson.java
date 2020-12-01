/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.pojo.json;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwar
 */
public class LlamadaJson {
    String idllamada;
    CampanaJson campana;
    String tel_ori;
    String tel_des;
    Integer idagente;
    String fecha;
    Long duracion_seg;
    List<GestionJson> gestion=new ArrayList<>();

    public String getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(String idllamada) {
        this.idllamada = idllamada;
    }

    public CampanaJson getCampana() {
        return campana;
    }

    public void setCampana(CampanaJson campana) {
        this.campana = campana;
    }

    public String getTel_ori() {
        return tel_ori;
    }

    public void setTel_ori(String tel_ori) {
        this.tel_ori = tel_ori;
    }

    public String getTel_des() {
        return tel_des;
    }

    public void setTel_des(String tel_des) {
        this.tel_des = tel_des;
    }

    public Integer getIdagente() {
        return idagente;
    }

    public void setIdagente(Integer idagente) {
        this.idagente = idagente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getDuracion_seg() {
        return duracion_seg;
    }

    public void setDuracion_seg(Long duracion_seg) {
        this.duracion_seg = duracion_seg;
    }

    public List<GestionJson> getGestion() {
        return gestion;
    }

    public void setGestion(List<GestionJson> gestion) {
        this.gestion = gestion;
    }
    
    
}
