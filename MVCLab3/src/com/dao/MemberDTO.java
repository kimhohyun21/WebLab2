package com.dao;

public class MemberDTO {
	private String name;
	private String gender;
	private String addr;
	
	//getter,setter 持失
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	//持失切 猿走 持失
	public MemberDTO(String name, String gender, String addr) {
		super();
		this.name = name;
		this.gender = gender;
		this.addr = addr;
	}
	
	
}
