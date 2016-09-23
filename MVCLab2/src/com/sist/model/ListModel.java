package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class ListModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		//ArrayList ����� �̸� ������, �̼���, �̹�� add
		List<String> list=new ArrayList<>();
		list.add("������");
		list.add("�̼���");
		list.add("�̹��");
		request.setAttribute("list", list);
		
		return "view/list.jsp";
	}
	
}
