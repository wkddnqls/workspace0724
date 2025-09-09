package com.kh.inherit;

public class Man extends Object{

	private String name;

	
	public Man() {
		super();
		System.out.println("기본생성자 Man");
	}




	public Man(String name) {
		super();// Object의 생성자
		this.name = name;
		System.out.println("Man : " +name);
		System.out.println("name 포함 생성자");
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void tellYourName() {
		System.out.println("안녕");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
