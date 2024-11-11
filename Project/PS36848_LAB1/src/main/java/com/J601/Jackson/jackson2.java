package com.J601.Jackson;

import java.io.File;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.J601.bean.Contact;
import com.J601.bean.Student;
import com.J601.bean.Student2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class jackson2 {

	public static void main(String[] args)throws Exception  {
		demo1();
		demo2();
		demo3();
		demo4();
		demo5();
		demo6();
		demo7();

	}

	private static void demo7()throws Exception {
		Contact contact=new Contact("yenltn@gmail.com","0382826669",null);
		List<String> subjectStrings=Arrays.asList("WEB205","COM108");
		Student2 student=new Student2("Phạm Kim Tuyền",true,9.5,contact,subjectStrings);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(student);
		//Write to output
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		//Write to file
		File file=new File("E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\studentfile.json");
		mapper.writeValue(file, student);
		
	}

	private static void demo6()throws Exception {
		Map<String, Object> contact=new HashMap<String, Object>();
		contact.put("email", "phongpvps36848@fpt.edu.vn");
		contact.put("phone", "0333002951");
		
		List<String> subjects=Arrays.asList("WEB205","COM108");
		Map<String, Object> student= new HashMap<String, Object>();
		student.put("name", "Lê Thị Ngọc yến");
		student.put("marks", 7.5);
		student.put("gender", true);
		student.put("contact", contact);
		student.put("subjects", subjects);
		
		ObjectMapper mapper=new ObjectMapper();
		//Write to String
		String json=mapper.writeValueAsString(student);
		System.out.println(json);
		//Write to output
		mapper.writeValue(System.out, student);
		//Write to file
		mapper.writeValue(new File("E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\studentfile.json"), student);
		
		
	}

	private static void demo5()throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		ObjectNode student=mapper.createObjectNode();
		student.put("name", "Phạm Văn Phong");
		student.put("marks", 7.5);
		student.put("gender", true);
		ObjectNode contact=student.putObject("contact");
		contact.put("email", "Phongpvps36848@gmail.com");
		contact.put("phone", "0333002951");
		ArrayNode subjects=student.putArray("subjects");
		subjects.add("WEB205");
		subjects.add("COM108");
		
		//Write to String
		String json=mapper.writeValueAsString(student);
		//Write to output
		mapper.writeValue(System.out, student);
		//Write to file
		mapper.writeValue(new File("E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\studentfile.json"), student);
	}

	private static void demo4()throws Exception  {
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\students.json";
		TypeReference<List<Student2>> type=new TypeReference<List<Student2>>(){};
		ObjectMapper mapper=new ObjectMapper();
		List<Student2> student=mapper.readValue(new File(path),type);
		
		student.forEach(sv->{
			System.out.println(">> Name:"+sv.getName());
			System.out.println(">> Marks:"+sv.getMarks());
			System.out.println(">> Gender:"+sv.getGender());
			Contact contact=sv.getContact();
			System.out.println(">>Email:"+contact.getEmail());
			System.out.println(">>Phone:"+contact.getPhone());
			List<String> subjects=sv.getSubjects();
			subjects.forEach(sub->System.out.println(">>Subject: "+sub));
			System.out.println("\n");
		});
		
	}

	private static void demo3()throws Exception {
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\student.json";
		ObjectMapper mapper=new ObjectMapper();
		Student2 student=mapper.readValue(new File(path),Student2.class);
		
		System.out.println(">> Name:"+student.getName());
		System.out.println(">> Marks:"+student.getMarks());
		System.out.println(">> Gender:"+student.getGender());
		Contact contact=student.getContact();
		System.out.println(">>Email:"+contact.getEmail());
		System.out.println(">>Phone:"+contact.getPhone());
		List<String> subjects=student.getSubjects();
		subjects.forEach(sub->System.out.println(">>Subject: "+sub));
		
	}

	private static void demo2()throws Exception {
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\students.json";
		ObjectMapper mapper=new ObjectMapper();
		List<Map<String, Object>> student=mapper.readValue(new File(path),List.class);
		
		student.forEach(sv->{
			System.out.println(">> Name:"+sv.get("name"));
			System.out.println(">> Marks:"+sv.get("marks"));
			System.out.println(">> Gender:"+sv.get("gender"));
			Map<String, Object> contact=(Map<String, Object>)sv.get("contact");
			System.out.println(">>Email:"+contact.get("email"));
			System.out.println(">>Phone:"+contact.get("phone"));
			List<String> subjects=(List<String>)sv.get("subjects");
			subjects.forEach(sub->System.out.println(">>Subject: "+sub));
			System.out.println("\n");
		});
	}

	private static void demo1()throws Exception   {
		String path="E:\\FPT Polytechnic\\JAVA\\Java6\\Project\\J601\\src\\main\\resources\\student.json";
		ObjectMapper mapper=new ObjectMapper();
		Map<String, Object> student=mapper.readValue(new File(path),Map.class);
		
		System.out.println(">> Name:"+student.get("name"));
		System.out.println(">> Marks:"+student.get("marks"));
		System.out.println(">> Gender:"+student.get("gender"));
		Map<String, Object> contact=(Map<String, Object>)student.get("contact");
		System.out.println(">>Email:"+contact.get("email"));
		System.out.println(">>Phone:"+contact.get("phone"));
		List<String> subjects=(List<String>)student.get("subjects");
		subjects.forEach(sub->System.out.println(">>Subject: "+sub));	
	}
}
