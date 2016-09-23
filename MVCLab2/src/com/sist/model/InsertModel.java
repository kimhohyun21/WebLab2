package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		String msg="Insert Form";
		request.setAttribute("msg", msg);
		
		return "view/insert.jsp";
	}

}
