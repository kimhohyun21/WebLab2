package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strPage=request.getParameter("page");
		String strNo=request.getParameter("no");
		
		request.setAttribute("page", strPage);
		request.setAttribute("no", strNo);		
		
		return "board/delete.jsp";
	}

}
