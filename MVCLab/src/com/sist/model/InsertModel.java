package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel {
	public String handlerRequest(HttpServletRequest request){
		String msg="�Խù� �ۼ�";
		request.setAttribute("msg", msg);
		return "view/insert.jsp";
	}
	
	
}
