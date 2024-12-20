package com.Lab4.Dao;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.Lab4.Model.Student;
import com.Lab4.Model.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class StudentDao {
	RestTemplate rest=new RestTemplate();
	
	String url="https://poly-java-6-58146-default-rtdb.firebaseio.com/student.json";
	
	private String getUrl(String key)
	{
		return url.replace(".json", "/"+key+".json");
	}
	
	public StudentMap findAll()
	{
		return rest.getForObject(url, StudentMap.class);
	}
	
	public Student findByKey(String key)
	{
		return rest.getForObject(getUrl(key), Student.class);
	}
	
	public String create(Student data)
	{
		HttpEntity<Student> entity=new HttpEntity<>(data);
		JsonNode resp=rest.postForObject(url, entity, JsonNode.class);
		return resp.get("name").asText();
	}
	
	public Student update(String key,Student data)
	{
		HttpEntity<Student> entity=new HttpEntity<>(data);
		rest.put(getUrl(key), entity);
		return data;
	}
	
	public void delete(String key)
	{
		rest.delete(getUrl(key));
	}
}
