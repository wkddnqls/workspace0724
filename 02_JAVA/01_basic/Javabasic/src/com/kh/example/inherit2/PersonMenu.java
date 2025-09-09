package com.kh.example.inherit2;

import java.util.Scanner;

public class PersonMenu {

	
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		// 0 =>학생수 ,  1-> 사원수
		while(true) {
		int[] count = pc.personCount();
		

		
		System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
		System.out.printf("현재저장된 학생은 %d 명 입니다 . /n" , count[0]);
		
		System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
		System.out.printf("현재저장된 사원은 %d 명 입니다 . /n" , count[1]);
		
		
		System.out.println("1. 학생 메뉴 : ");
		System.out.println("1. 사원 메뉴 : ");
		System.out.println("9. 끝내기 : ");
		System.out.println("메뉴 번호 : ");
	    int select = sc.nextInt();
	    sc.nextLine();
	    
	    switch(select) {
	    case 1 : studentMenu();
	    break;
	    case 2 :
	    	EmployeeMenu();
	    	break;
	    case 9 :
	    	System.out.println("종료");
	    default :
	    	System.out.println("잘못입력했습니다");
	    }
	}
	
	}
public void studentMenu() {
	while(true) {
		
		System.out.println("1. 학생 추가 : ");
		System.out.println("1.학생 보기 : ");
		System.out.println("9.메인으로 : ");
		System.out.println("메뉴 번호 : ");
	    int select = sc.nextInt();
	    sc.nextLine();
	    
	    switch(select) {
	    case 1 : 
	    	insertStudent();
	    break;
	    case 2 :
	    	printStudent();
	    break;	
	    case 9 :
	    	
	    	System.out.println("종료");
	    	return;
	    default :
	    	System.out.println("잘못입력했습니다");
	    }
	}
}
	
	
	
	
	public void EmployeeMenu() {
		while(true) {
			
			System.out.println("1. 사원 추가 : ");
			System.out.println("1.사원 보기 : ");
			System.out.println("9.메인으로 : ");
			System.out.println("메뉴 번호 : ");
		    int select = sc.nextInt();
		    sc.nextLine();
		    
		    switch(select) {
		    case 1 : 
		    	insertEmployee() ;
		    break;
		    case 2 :
		    	printEmployee();
		    break;	
		    case 9 :
		    	
		    	System.out.println("종료");
		    	return;
		    default :
		    	System.out.println("잘못입력했습니다");
		    }
		}}
	
	public void insertStudent() {
	
			if(pc.personCount()[0] >=3) {
				System.out.println("학생꽊차서 종료합니다");
				return;
			}
			
			while(true) {
			
		System.out.print("학생 이름 : ");
		String name = sc.next();
		System.out.print("학생 나이 : ");
		int age = sc.nextInt();
	
		System.out.print("학생 키 : ");
	    double height = sc.nextDouble()	;
		System.out.print("학생 몸무게 : ");
	    double weight = sc.nextDouble()	;
		System.out.print("학생 학년 : ");
		int grade = sc.nextInt();
		System.out.print("학생 전공 : ");
		String major = sc.next();
	   
		pc.insertStudent(name, age, height, weight, grade, major);
		if(pc.personCount()[0] >=3) {
			System.out.println("학생꽊차서 종료합니다 ");
			break;
		}
	
		System.out.println("그만하려면 n,N 이어하려면 아무키나 누르시오");
		char an = sc.next().toUpperCase().charAt(0);
		if(an=='N') {break;}
	}
	}
	
	
	public void printStudent(){
		Student[] stArr = pc.printStudent();
		for(Student st: stArr) {
		 System.out.println(st.toString());
		 
		}
	
}
	
	public void insertEmployee() {
		
		if(pc.personCount()[1] >=10) {
			System.out.println("사원꽊차서 종료합니다");
			return;
		}
		
		while(true) {
		
	System.out.print("사원 이름 : ");
	String name = sc.next();
	System.out.print("사원 나이 : ");
	int age = sc.nextInt();

	System.out.print("사원 키 : ");
    double height = sc.nextDouble()	;
	System.out.print("사원 몸무게 : ");
    double weight = sc.nextDouble()	;
	System.out.print("사원 학년 : ");
	int salary = sc.nextInt();
	System.out.print("사원 전공 : ");
	String dept = sc.next();
   
	pc.insertEmployee(name, age, height, weight, salary, dept );
	
	if(pc.personCount()[1] >=10) {
		System.out.println("학생꽊차서 종료합니다 ");
		break;
	}

	System.out.println("그만하려면 n,N 이어하려면 아무키나 누르시오");
	char an = sc.next().toUpperCase().charAt(0);
	if(an=='N') {break;}
}
}
	
	
	public void printEmployee(){
		Student[] empArr = pc.printStudent();
		for(Student emp: empArr) {
			if(emp==null) break;
			System.out.println(emp.toString());
		 
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
