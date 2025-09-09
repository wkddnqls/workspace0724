package com.kh.override;

public class Man {
  private String naem;
  private String number;
  public Man(String naem, String number) {
	super();
	this.naem = naem;
	this.number = number;
  }
  public String getNaem() {
	return naem;
  }
  public void setNaem(String naem) {
	this.naem = naem;
  }
  public String getNumber() {
	return number;
  }
  public void setNumber(String number) {
	this.number = number;
  }
  @Override
  public String toString() {
	return "Man [naem=" + naem + ", number=" + number + "]";
  }
  @Override
  public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return this.number == ((Man)obj).getNumber();
  }
  
  
  
  
}

