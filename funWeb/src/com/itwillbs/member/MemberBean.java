package com.itwillbs.member;

import java.security.Timestamp;

public class MemberBean {
	//Data Transfer Object memberDTO = memberBean
	//DTO=Bean 같은 개념이라 생각
	//멤버 정보(DB테이블)를 저장하는 객체 
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String gender;
	private String email;
	private Timestamp regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	
	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", regdate=" + regdate + "]";
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
    
}
