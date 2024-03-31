package com.javaexpress.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Student {
		private  Integer studentId;
		
		private String studentName;
		
		private String studentSkill;
		
		private String studentAge;
}
