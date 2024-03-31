package com.javaexpress;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import com.javaexpress.models.Student;


@XmlRootElement
public class ObjectToXML {
	public static void main(String[] args) throws Exception {
		Student s = new Student();
		s.setStudentId(101);
		s.setStudentName("Abhi");
		s.setStudentSkill("SPRINGBOOT");
		s.setStudentAge("30");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(s,System.out);
	}
	
}
