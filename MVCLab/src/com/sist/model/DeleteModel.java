package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class DeleteModel {
	public String handlerRequest(HttpServletRequest request){
		String msg="�Խù� ����";
		request.setAttribute("msg", msg);
		return "view/delete.jsp";
	}
}
