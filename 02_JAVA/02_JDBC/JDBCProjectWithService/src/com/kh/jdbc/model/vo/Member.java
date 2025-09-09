package com.kh.jdbc.model.vo;

import java.time.LocalDateTime;

/*
 * VO(Value Object)
 * DB의 테이블 정보를 Java에서 사용하기위해 담아주는 객체
 * 한명의 회원 (db테이블의 한행의 데이터)에 대한 데이터를 기록할 수 있는 저장용 객체 
 * 
 */
public class Member {
    //필드는 기본적으로 db컬럼명과 유사하게 작업
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String gender;
	private int age;
	private String emall;
	private String phone;
	private String address;
	private String hobby;
	private LocalDateTime enrollDate;
	
	public Member() {
		super();
	}

	public Member(int userNo, String userId, String userPwd, String userName, String gender, int age, String emaill,
			String phone, String address, String hobby, LocalDateTime enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.emall = emall;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	
	public Member( String userId, String userPwd, String userName, String gender, int age, String emaill,
			String phone, String address, String hobby) {
		super();
		
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.emall = emall;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmall() {
		return emall;
	}

	public void setEmall(String emall) {
		this.emall = emall;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public LocalDateTime getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(LocalDateTime enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [유저의 고유 번호 : " + userNo + ", 아이디 : " + userId + ", 비밀번호 : " + userPwd + ", 이름 : " + userName
				+ ", 성별 : " + gender + ", 나이 : " + age + ", 이메일 : " + emall + ", 폰번호 : " + phone + ", 주소 : "
				+ address + ", 취미 : " + hobby + ", 가입일 : " + enrollDate + "]";
	}
	
	
}
