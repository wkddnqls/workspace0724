package com.kh.interface1;

public class Dog implements Animal {

	private String color;
	
	
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("강아지가 달립니다 .");
	}
	
	
	public void eat() {
		
		System.out.println("냠냠");
	}
	

}
