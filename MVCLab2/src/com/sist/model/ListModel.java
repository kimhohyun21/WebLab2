package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class ListModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		//ArrayList 만들고 이름 정도전, 이성계, 이방원 add
		List<String> list=new ArrayList<>();
		list.add("정도전");
		list.add("이성계");
		list.add("이방원");
		request.setAttribute("list", list);
		
		return "view/list.jsp";
	}
	
}
