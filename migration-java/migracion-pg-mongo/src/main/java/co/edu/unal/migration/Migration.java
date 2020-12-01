/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration;

import co.edu.unal.migration.pojo.Agente;
import co.edu.unal.migration.pojo.Campana;
import co.edu.unal.migration.pojo.Campanacampo;
import co.edu.unal.migration.pojo.Llamada;
import co.edu.unal.migration.pojo.Llamadagestion;
import co.edu.unal.migration.pojo.LlamadagestionItem;
import co.edu.unal.migration.pojo.PbxCdrAsterisk;
import co.edu.unal.migration.pojo.Telefono;
import co.edu.unal.migration.pojo.json.AgenteJson;
import co.edu.unal.migration.pojo.json.CampanaJson;
import co.edu.unal.migration.pojo.json.GestionJson;
import co.edu.unal.migration.pojo.json.LlamadaJson;
import co.edu.unal.migration.util.JsonUtil;
import co.edu.unal.migration.util.TimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author edwar
 */
public class Migration {

    public List<AgenteJson> getAgentesList() {
        List<AgenteJson> lstJson = new ArrayList();
        List<Agente> lstA = DbManager.getInstance().listFromHql("SELECT a FROM Agente a");
        for (Agente agente : lstA) {
            AgenteJson aj = new AgenteJson();
            aj.setIdagente(agente.getIdagente());
            aj.setEmail(agente.getIdpersona().getEmail());
            aj.setExt("000");
            aj.setNumdocumento(agente.getIdpersona().getNumdocumento() + "");
            aj.setNombre(agente.getIdpersona().getNombres().toUpperCase() + " " + agente.getIdpersona().getApellidos().toUpperCase());

            lstJson.add(aj);
        }
        return lstJson;
    }

    public String getAgentesJson() {
        return JsonUtil.objectToJson(getAgentesList());
    }

    public List<LlamadaJson> getLlamadaList() {
        List<LlamadaJson> lstLlamadaJson = new ArrayList<>();

        List<Llamada> lstLl = getLlamadasListFromDb();
        HashMap<String, PbxCdrAsterisk> mapCdr = mapCdr();
        HashMap<Long, List<LlamadagestionItem>> mapGestion = mapGestionFromDb();

        for (Llamada llamada : lstLl) {
            LlamadaJson llj = new LlamadaJson();
            llj.setIdllamada(llamada.getIdllamadaPbx());

            CampanaJson cj = new CampanaJson();
            cj.setIdcampana(llamada.getIdcampana().getIdcampana());
            cj.setNombre(llamada.getIdcampana().getNombre());
            llj.setCampana(cj);

            llj.setTel_ori(llamada.getIdtelefonoOri().getNumero());
            llj.setTel_des(llamada.getIdtelefonoDes().getNumero());
            llj.setFecha(TimeUtil.getFecha2("yyyy-MM-dd HH:mm:ss", llamada.getFechaIni()));

            int d = 0;
            PbxCdrAsterisk cdr = mapCdr.get(llamada.getIdllamadaPbx());
            if (cdr != null) {
                llj.setDuracion_seg(new Long(cdr.getBillsec()));
            }

            List<LlamadagestionItem> lstG = mapGestion.get(llamada.getIdllamada());
            if (lstG != null) {
                for (LlamadagestionItem gi : lstG) {
                    GestionJson gij = new GestionJson();
                    String val = "XXX XX XXX X";
                    /*if(gi.getIdcampo().getNombre().toUpperCase().contains("documento")||gi.getIdcampo().getNombre().toUpperCase().contains("nombre")){
                        val="XXX XX XXX";
                    }*/
                    gij.setCampo(gi.getIdcampo().getNombre());
                    gij.setValor(val);
                    llj.getGestion().add(gij);
                }
            }

            lstLlamadaJson.add(llj);
        }

        return lstLlamadaJson;
    }

    public String getLlamadasJson() {
        return JsonUtil.objectToJson(getLlamadaList());
    }

    /**
     *
     * @return MAP<key: uniqueid, value: PbxCdrAsterisk>
     */
    private HashMap<String, PbxCdrAsterisk> mapCdr() {
        HashMap<String, PbxCdrAsterisk> map = new HashMap<>();

        String hql = "SELECT c.uniqueid,c.billsec"
                + " FROM PbxCdrAsterisk c"
                + "  WHERE c.uniqueid IN (SELECT ll.idllamadaPbx FROM Llamada ll WHERE ll.idcampana !=null)"
                + " ORDER BY c.uniqueid";
        List<Object[]> lst = DbManager.getInstance().listFromHql(hql);
        for (Object[] o : lst) {
            PbxCdrAsterisk c = new PbxCdrAsterisk();
            c.setUniqueid((String) o[0]);
            c.setBillsec((Integer) o[1]);

            map.put(c.getUniqueid(), c);
        }
        return map;
    }

    private List<Llamada> getLlamadasListFromDb() {
        List<Llamada> lstLL = new ArrayList<>();

        String hql = "SELECT ll.idllamada,ll.idllamadaPbx,ll.idcampana.idcampana,ll.idcampana.nombre,ll.idtelefonoOri.idtelefono,ll.idtelefonoOri.numero,ll.idtelefonoDes.idtelefono,ll.idtelefonoDes.numero,ll.fechaIni"
                + "    FROM Llamada ll"
                + " WHERE ll.idcampana !=null";

        List<Object[]> lst = DbManager.getInstance().listFromHql(hql);
        for (Object[] o : lst) {
            Llamada ll = new Llamada((Long) o[0]);
            ll.setIdllamadaPbx((String) o[1]);
            ll.setIdcampana(new Campana((Integer) o[2]));
            ll.getIdcampana().setNombre((String) o[3]);
            ll.setIdtelefonoOri(new Telefono((Long) o[4]));
            ll.getIdtelefonoOri().setNumero((String) o[5]);
            ll.setIdtelefonoDes(new Telefono((Long) o[6]));
            ll.getIdtelefonoDes().setNumero((String) o[7]);
            ll.setFechaIni((Date) o[8]);

            lstLL.add(ll);
        }
        return lstLL;
    }

    /**
     *
     * @return Map<key:idllamada, val: List<LlamadagestionItem>>
     */
    private HashMap<Long, List<LlamadagestionItem>> mapGestionFromDb() {
        HashMap<Long, List<LlamadagestionItem>> map = new HashMap<>();

        String hql = "SELECT gi.idgestion.idgestion,gi.idgestion.idllamada.idllamada,gi.idcampo.idcampo,gi.idcampo.nombre,gi.gestion "
                + " FROM LlamadagestionItem gi";

        List<Object[]> lst = DbManager.getInstance().listFromHql(hql);
        for (Object[] o : lst) {
            LlamadagestionItem it = new LlamadagestionItem();
            it.setIdgestion(new Llamadagestion((Long) o[0]));
            it.getIdgestion().setIdllamada(new Llamada((Long) o[1]));
            it.setIdcampo(new Campanacampo((Integer) o[2]));
            it.getIdcampo().setNombre((String) o[3]);
            it.setGestion((String) o[4]);

            List<LlamadagestionItem> lstIt = map.get(it.getIdgestion().getIdllamada().getIdllamada());
            if (lstIt == null) {
                lstIt = new ArrayList<>();
                map.put(it.getIdgestion().getIdllamada().getIdllamada(), lstIt);
            }
            lstIt.add(it);
        }

        return map;
    }
}
