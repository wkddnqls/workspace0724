package com.kh.example.oop3;

public class Run {

	public static void main(String[] args) {
		Book b1 =new Book();
		
		b1.inform();
		
		System.out.println("---------------------------------");
		
		Book b2 = new Book("dsd","sd","아");
		b2.inform();
		
		System.out.println("---------------------------------");
	
		Book b3 = new Book("dsd","sd","아", 33,333);
		b3.inform();
		
		
	}

}
