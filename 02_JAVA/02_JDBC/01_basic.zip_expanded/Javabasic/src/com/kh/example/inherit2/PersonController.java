package com.kh.example.inherit2;

public class PersonController {
	Student[] s = new Student[3];
	 Employee[] e  = new Employee[10];
	 
	public int[] personCount() {
		//학생객체 생성후 배열 반환 //학생수
		int stCount =0, empCount =0;
		for(Student st : s) {
			if(st==null) {
				break;
			}  
			stCount++;
		}
		for(Employee st : e) {
			if(st==null) {
				break;
			}  
			empCount++;
	}
		//int[] countArr = {stCount, empCount};
		
		return new int[] {stCount, empCount};
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major
			) { //0부터 하나씩 인덱스 값을 검사해 빈공간을 찾아서 학생을 추가.
		Student st= new Student(name, age,height,weight,grade,major);
		for(int i=0;i<s.length ; i++) {
			if(s[i] == null) {
				s[i] = new Student (name, age,height,weight,grade,major);
				break;
				
				
			}
		}
	       
	
	
	}
	
	public Student[] printStudent() {
		return s;
	}
	
	
	
	public void insertEmployee (String name, int age, double height, double weight, int salary, String dept)
	{
		
		for(int i=0;i<e.length ; i++) {
			if(e[i] == null) {
				e[i] = new Employee (name, age,height,weight,salary,dept);
				break;
				
				
			}
		}
	}

	
	public Employee[] printEmployee() {
		return e;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
