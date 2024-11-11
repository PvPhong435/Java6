package com.J601.Jackson;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jackson1 {
	public static void main(String[] args) throws Exception
	{
		demo1();
		demo2();
	}

	private static void demo1() throws Exception {
		// chuỗi json
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\student.json";
		ObjectMapper mapper=new ObjectMapper();
		JsonNode student=mapper.readTree(new File(path));
		
		System.out.println(">> Name:"+student.get("name").asText());
		System.out.println(">> Marks:"+student.get("marks").asText());
		System.out.println(">> Gender:"+student.get("gender").asText());
		System.out.println(">> Email:"+student.get("contact").get("email").asText());
		System.out.println(">> Phone:"+student.findValue("phone").asText());
		
		student.get("subjects").iterator().forEachRemaining(subject->System.out.println(">> Subject:"+subject.asText()));
		
	} 
	
	private static void demo2() throws Exception {
		// chuỗi json
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\students.json";
		ObjectMapper mapper=new ObjectMapper();
		JsonNode student=mapper.readTree(new File(path));
		student.iterator().forEachRemaining(sv->{
			System.out.println(">> Name:"+sv.get("name").asText());
			System.out.println(">> Marks:"+sv.get("marks").asText());
			System.out.println(">> Gender:"+sv.get("gender").asText());
			System.out.println(">> Email:"+sv.get("contact").get("email").asText());
			System.out.println(">> Phone:"+sv.findValue("phone").asText());
			sv.get("subjects").iterator().forEachRemaining(s->System.out.println(">> Subject:"+s.asText()));
			System.out.println("\n");
		});
		
		
	} 
	
}
