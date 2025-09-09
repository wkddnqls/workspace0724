package com.kh.example.oop4;

public class TriangleController {
	Shape s =new Shape();
	
	
	
	
	
	double calcArea(double height, double width) {
		 s = new Shape(3, height, width);
		return (width * height)/2;
	}
	
	
	  
   void paintColor(String color) {
       s.setColor(color); // setter 사용
   }
	
	
   String print() {
       return "삼각형 " + s.information();
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
