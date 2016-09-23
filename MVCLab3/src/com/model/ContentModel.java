package com.model;

import com.dao.*;

public class ContentModel {
	public MemberDTO handlerRequest(){
		MemberDTO dto=new MemberDTO("이성계", "남자", "서울");
		
		return dto;
	}
}
