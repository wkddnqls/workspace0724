package com.kh.example.collection3;

public class Member {

	private String password;
	private String name;
	
	public Member() {
		super();
	}

	public Member(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
	    return "Member [name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
