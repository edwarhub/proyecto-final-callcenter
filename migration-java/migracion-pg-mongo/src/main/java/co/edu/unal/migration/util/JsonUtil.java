/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.migration.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author inmoticamaster
 */
public class JsonUtil {

    public static <T> T jsonToObject(String json, Class<T> c) {
        T data = new Gson().fromJson(json, c);
        return data;
    }

    public static String objectToJson(Object obj) {
        return new Gson().toJson(obj);
    }

    public static Map<String, Object> buildMapFromJson(String dataJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(dataJson, Map.class);
            return map;
        } catch (Exception e) {
            e.toString();
        }
        return new HashMap<>();
    }

    public static String jsonPretty(String jsonData) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jsonData);
            return gson.toJson(je);
        } catch (Exception e) {
            e.printStackTrace();
            return jsonData;
        }
    }

    public static String findObjFromArray(String json, String attributeArray, String attributeCriteria,
            String valueCriteria) {
        try {
            JsonElement jsonElement = new JsonParser().parse(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray lstFind = new JsonArray();

            JsonArray elemArray = jsonObject.get(attributeArray).getAsJsonArray();

            for (JsonElement el : elemArray) {
                JsonObject o = el.getAsJsonObject();
                if (o.get(attributeCriteria).getAsString().equals(valueCriteria)) {
                    lstFind.add(o);
                }
            }

            return lstFind.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String mapToJson(Map<String, String> map) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(map);
        return json;
    }
    public static String mapToJsonObj(Map<String, Object> map) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(map);
        return json;
    }

    public static void main(String... args) throws Exception {
        TestData td = new TestData();
        td.setId(new Long(1));
        td.setName("First");
        td.getLstD().add("A");
        td.getLstD().add("B");
        td.getLstD().add("C");

        System.out.println("JSON:" + objectToJson(td));

        String json = "{\"id\":1,\"name\":\"First\",\"lstD\":[\"A\",\"B\",\"C\"]}";
        TestData tdRes = jsonToObject(json, TestData.class);
        System.out.println("ID:" + tdRes.getId());

        System.out.println("Example 2 -------------------------");
        json = "{data:[{\"id\":1,\"name\":\"First\",\"lstD\":[\"A\",\"B\",\"C\"]},{\"id\":2,\"name\":\"Second\",\"lstD\":[\"X\",\"Y\",\"Z\"]}]}";
        List<TestData> lstD = jsonToObject(json, TestData.class).getData();
        System.out.println("Size:" + lstD.size());

    }

}

class TestData {

    private Long id;
    private String name;
    private List<String> lstD = new ArrayList<>();
    private List<TestData> data = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLstD() {
        return lstD;
    }

    public void setLstD(List<String> lstD) {
        this.lstD = lstD;
    }

    public List<TestData> getData() {
        return data;
    }

    public void setData(List<TestData> data) {
        this.data = data;
    }

}
