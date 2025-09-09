package com.kh.ploymorphism;

public class Avante extends Car{

	
	public Avante(String color, String fuel, int year) 
	{
		super(color, fuel, year);
	
	}
	public void moveSonata() {
		System.out.println("빵빵 ~ 소나탕 ");
	}
	
	public void moveAvante() {
		System.out.println("빵빵 ~ 아반퉤");
	}
	public void driveCar(Car car) {
		
		//매개변수로 넘어온 car가 실제 메모리 공간에 Avante를 구현하고있어야 moveAvante()사용가능
	 if( car instanceof Avante) {
		 ((Avante)car).moveAvante(); 
	 }
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if( obj instanceof Avante) {
			 //비교 
		 }return false;
		
	}
	
	
	//매개변수에 부모타입 참조변수를 사용하면 모든 자식타입을 받을 수 있음
}
