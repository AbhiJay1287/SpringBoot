package com.javaexpress;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaexpress.models.Student;

public class JSONToObject {
public static void main(String[] args) throws Exception, DatabindException, IOException {
	var mapper  = new ObjectMapper();
	var student = mapper.readValue(new File("student.json"), Student.class);
	System.out.println(student);
}
}
