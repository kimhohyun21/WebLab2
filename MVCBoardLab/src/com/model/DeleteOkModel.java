package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;

public class DeleteOkModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strPage=request.getParameter("page");
		String strNo=request.getParameter("no");
		int no=Integer.parseInt(strNo);
		String pwd=request.getParameter("pwd");
		System.out.println(pwd);
		
		//DB ¿¬µ¿
		BoardDAO dao=new BoardDAO();		
		boolean bCheck=dao.boardDelete(no, pwd);
		
		request.setAttribute("bCheck", bCheck);
		request.setAttribute("page", strPage);
		request.setAttribute("no", strPage);
		
		return "board/delete_ok.jsp";
	}

}
