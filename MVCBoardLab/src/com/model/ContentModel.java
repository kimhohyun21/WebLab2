package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;

public class ContentModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strNo=request.getParameter("no");
		String strPage=request.getParameter("page");
		int no=Integer.parseInt(strNo);
		
		BoardDAO dao=new BoardDAO();
		BoardDTO dto=dao.boardContentData(no);
		
		request.setAttribute("page", strPage);
		request.setAttribute("dto", dto);
		
		return "board/content.jsp";
	}

}
