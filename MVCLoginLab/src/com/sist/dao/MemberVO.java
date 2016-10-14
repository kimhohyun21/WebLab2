package com.sist.dao;
/*
	ID     NOT NULL VARCHAR2(20) 
	PWD    NOT NULL VARCHAR2(10) 
	NAME   NOT NULL VARCHAR2(34) 
	GENDER          VARCHAR2(10) 
 */
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
