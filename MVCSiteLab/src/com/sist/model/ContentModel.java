package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;

public class ContentModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		String strNo=request.getParameter("no");
		int no=Integer.parseInt(strNo);
		String page=request.getParameter("page");
		
		BoardVO vo=BoardDAO.contentData(no);
		
		request.setAttribute("vo", vo);
		request.setAttribute("curPage", page);
		request.setAttribute("jsp", "board.jsp");
		request.setAttribute("board_jsp", "../board/content.jsp");
		
		return "main/main.jsp";
	}

}
