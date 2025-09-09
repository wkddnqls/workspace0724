package com.kh.ploymorphism;

public class Car {
   private String color;
   private String fuel;
   private int year;
   public Car() {
	super();
   }
   public Car(String color, String fuel, int year) {
	super();
	this.color = color;
	this.fuel = fuel;
	this.year = year;
   }
   public String getColor() {
	return color;
   }
   public void setColor(String color) {
	this.color = color;
   }
   public String getRuel() {
	return fuel;
   }
   public void setRuel(String fuel) {
	this.fuel = fuel;
   }
   public int getYear() {
	return year;
   }
   public void setYear(int year) {
	this.year = year;
   }
   @Override
   public String toString() {
	// TODO Auto-generated method stub
	return color + "," +fuel + " , "+ year;
   }
   public void drive() {
	   System.out.println("부릉부릉");
   }
   
	
	
	
	
	
	
	
	
	
	
	
}
