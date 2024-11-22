/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lab4.Dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab4.Model.Rest;
import com.lab4.Model.*;

/**
 *
 * @author PC
 */
public class StudentDao {
    ObjectMapper mapper=new ObjectMapper();
    
    public StudentMap findAll()
    {
        JsonNode resp=Rest.get("/student");
        return mapper.convertValue(resp, StudentMap.class);
    }
    
    public Student findByKey(String key)
    {
        JsonNode resp=Rest.get("/student/"+key);
        return mapper.convertValue(resp, Student.class);
    }
    public String create(Student data)
    {
        JsonNode resp=Rest.post("/student", data);
        return resp.get("name").asText();
    }
    
    public Student update(String key,Student data)
    {
        JsonNode resp=Rest.put("/student/"+key, data);
        return mapper.convertValue(resp, Student.class);
    }
    
    public void delete(String key)
    {
        Rest.delete("/student/"+key);
    }
}
