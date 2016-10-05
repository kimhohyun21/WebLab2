package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class MainModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		request.setAttribute("jsp", "default.jsp");
		return "main/main.jsp";
	}
	
}
