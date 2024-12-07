package com.Thi.Dao;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.Thi.Model.Student;
import com.Thi.Model.StudentMap;
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
	
//	public Map<String, Student> findByFullnameLike(String find)
//	{
//		StudentMap list=rest.getForObject(url, StudentMap.class);
//		return list.values().stream().filter(student -> student.getFullname()
//				.toLowerCase().contains(find.toLowerCase()))
//				.collect(Collectors.toMap(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
//	}
}
