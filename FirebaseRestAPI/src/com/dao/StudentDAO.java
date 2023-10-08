
package com.dao;

import com.bean.Student;
import com.bean.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.Rest;

public class StudentDAO {
    String path = "/students";
    ObjectMapper mapper = new ObjectMapper();
    public StudentMap findAll() {
        JsonNode resp = Rest.get(  path);
        return mapper.convertValue(resp, StudentMap.class);
    }
    
    public Student findByKey(String key) {
        JsonNode resp = Rest.get(path+"/"+key);
        return mapper.convertValue(resp, Student.class);
    }
    public  String  create (Student data) {
        JsonNode resp = Rest.post(path, data);
        return  resp.get("name").asText();
    }
    public Student update(String key,  Student data){
        JsonNode resp = Rest.put(path+"/"+key, data);
        return mapper.convertValue(resp, Student.class);
    }
    public void delete(String key){
        Rest.delete(path+"/" + key);
    }

}
