package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		request.setAttribute("jsp", "board.jsp");
		request.setAttribute("board_jsp", "../board/insert.jsp");
		
		return "main/main.jsp";
	}

}
