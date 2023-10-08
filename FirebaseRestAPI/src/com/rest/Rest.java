
package com.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;

public class Rest {
    private static ObjectMapper mapper = new ObjectMapper();
     
    public  static JsonNode get(String path){
        return request("GET", path, null);
    }
    public  static JsonNode post(String path, Object data){
        return request("POST", path, data);
    }
    public  static JsonNode put(String path, Object data){
        return request("PUT", path, data);
    }
    public  static void delete(String path){
        request("DELETE", path, null);
    }
    private static JsonNode request(String method, String path, Object data){
        try {
            //1. REQUEST
            String uri = "https://demoj6-d7041-default-rtdb.firebaseio.com" + path + ".json";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);
            
            // 1.1 DATA(POST & PUT only)
            if(method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")){
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(), data);
            }
     
            //2. RESPONSE
            int responseCode =  conn.getResponseCode();
            if(responseCode == 200) {
                return mapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return  null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
