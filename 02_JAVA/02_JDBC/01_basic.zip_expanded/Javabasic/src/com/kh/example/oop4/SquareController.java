package com.kh.example.oop4;

public class SquareController {

	private Shape s = new Shape();
	
	
	double calcPerimeter(double height, double width) {
		s = new Shape(4, height, width);
		return width*2 + height*2 ;
	}
	
	
	double calcArea(double height, double width) {
		 s = new Shape(4, height, width);
		return width * height;
	}
	
	
	  
    void paintColor(String color) {
        s.setColor(color); // setter 사용
    }

   
    String print() {
        return "사각형 " + s.information();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
