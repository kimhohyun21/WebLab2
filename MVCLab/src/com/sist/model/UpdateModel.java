package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class UpdateModel {
	public String handlerRequest(HttpServletRequest request){
		String msg="게시물 수정";
		request.setAttribute("msg", msg);
		return "view/update.jsp";
	}
}
