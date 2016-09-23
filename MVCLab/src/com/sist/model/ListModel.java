package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class ListModel {
	public String handlerRequest(HttpServletRequest request){
		String msg="게시판 목록";
		request.setAttribute("msg", msg);
		return "view/list.jsp";		
	}
}
