package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class ListModel {
	public String handlerRequest(HttpServletRequest request){
		String msg="�Խ��� ���";
		request.setAttribute("msg", msg);
		return "view/list.jsp";		
	}
}
