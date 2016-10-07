package com.sist.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;

public class InsertOkModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setEmail(email);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		BoardDAO.boardinsert(vo);
		
		return "board/insert_ok.jsp";
	}

}
