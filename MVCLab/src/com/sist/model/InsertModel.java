package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel {
	public String handlerRequest(HttpServletRequest request){
		String msg="게시물 작성";
		request.setAttribute("msg", msg);
		return "view/insert.jsp";
	}
	
	
}
