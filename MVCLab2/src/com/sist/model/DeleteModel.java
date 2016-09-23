package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class DeleteModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		String msg="Delete Form";
		request.setAttribute("msg", msg);
		
		return "view/delete.jsp";
	}

}
