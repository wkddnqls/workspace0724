package com.kh.example.abstractNInterface;

public abstract class SmartPhone {
   String maker;

 
   
   public SmartPhone(String maker) {
	super();
	this.maker = maker;
}
//각인터페이스의 매서들의 반환값을 모두 조합해서 반환(자식에서구현)
   public String printInformation() {
		  return "제조사: " + maker ;
	
	   }
   
  
 
  public void setMaker(String maker) {
	  this.maker = maker;
	  
  }
  
  public String getMaker() {
	  return maker;
  }
   
}





/*
 * public String printInformation() {
	  return "제조사: " + maker + "\n"
	       + "기능1: " + makeCall()   + "\n"
	       + "기능2: " + takeCall()   + "\n"
	       + "기능3: " + picture()    + "\n"
	       + "기능4: " + charge()     + "\n"
	       + "기능5: " + touch()      + "\n"
	       + "기능6: " + bluetoothPen();
   }
 */
