package com.kh.abstractclass;

public abstract class Animal {
   //일반 메서드
	public void brcathe() {
		System.out.println("사람과 함께 달리기 ");
	}
	//추상메서드
	public abstract void speak();//소리내기
	public abstract void move(); //움직임
	
}
