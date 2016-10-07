package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class ReserveModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		request.setAttribute("jsp", "reserve.jsp");
		request.setAttribute("reserve_jsp", "../reserve/reserve.jsp");
		
		return "main/main.jsp";
	}

}
