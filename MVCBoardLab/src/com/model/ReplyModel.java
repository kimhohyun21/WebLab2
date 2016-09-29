package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1) Controller: 夸没蔼 贸府
 * 2) Model-class: 夸没 贸府
 * 3) View-jsp: 贸府 搬苞 免仿
 * 
 */

public class ReplyModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strNo=request.getParameter("no");
		String strPage=request.getParameter("page");
		request.setAttribute("no", strNo);
		request.setAttribute("page", strPage);
		
		return "board/reply.jsp";
	}

}
