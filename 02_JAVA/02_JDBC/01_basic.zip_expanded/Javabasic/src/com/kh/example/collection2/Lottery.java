package com.kh.example.collection2;

import java.util.Objects;

import com.kh.example.collection1.Music;

public class Lottery {
   
	private String  name;
	private String phone;

	
	public Lottery() {
		super();
	}


	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name,phone);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "( " + phone + ")" ;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Lottery) {
			Lottery m = (Lottery)obj;
			return this.name.equals(m.getName()) && this.phone.equals(m.getPhone());
		}
			return false;
	}
	
	
	
	
}
