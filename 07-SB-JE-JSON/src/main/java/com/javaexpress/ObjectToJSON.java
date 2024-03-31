package com.javaexpress;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaexpress.models.Student;

public class ObjectToJSON {
	public static void main(String[] args) throws Exception {
		Student s = new Student();
		s.setStudentId(101);
		s.setStudentName("Abhi");
		s.setStudentSkill("SPRINGBOOT");
		s.setStudentAge("30");
		
		// json
		var mapper  = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("student.json"),s);
		System.out.println(mapper.writeValueAsString(s));
	}
}
