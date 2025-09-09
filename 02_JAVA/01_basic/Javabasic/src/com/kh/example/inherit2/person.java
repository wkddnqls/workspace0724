package com.kh.example.inherit2;

public class person {

	
	private String name;
	private int age;
	private double height;
	private double weight;
	
	
	
	public person() {
		super();
	}



	public person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	public double getWdight() {
		return weight;
	}



	public void setWdight(double wdight) {
		this.weight = wdight;
	}
	
	public String toString() {
	    return "(" +name+ " ," +age+"," +height+"," +weight+")";
	}
	
	
	
	
	
}
