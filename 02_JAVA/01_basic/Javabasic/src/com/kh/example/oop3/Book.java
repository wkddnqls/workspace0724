package com.kh.example.oop3;

public class Book {
    private String title;
    private String publisher;
    private String suthor;
    private int price;
    private double discountRate;
	 
     
     
     
     public Book() {
		super();
		
	}


	 public Book(String title, String publisher, String suthor, int price, double discountRate) {
		 super();
		this.title = title;
		this.publisher = publisher;
		this.suthor = suthor;
		this.price = price;
		this.discountRate = discountRate;
	}


	 public Book(String title, String publisher, String suthor) {
		 this(title,publisher,suthor,0,0);
	 }
     
     

 public void inform() {
	 System.out.println("제목: "+title);
	 System.out.println("출판사: "+publisher);
	 System.out.println("저자: "+suthor);
	 System.out.println("숫자: "+price);
	 System.out.println("2숫자: "+discountRate);
	 
 }
 
 
 
 
}