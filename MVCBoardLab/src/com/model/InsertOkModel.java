package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;

public class InsertOkModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//데이터(insert.jsp) 받기
		request.setCharacterEncoding("EUC-KR");
		
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		//dto에 모아서 전송 ==> dao ==> 오라클 데이터에 저장
		BoardDTO dto=new BoardDTO();
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setPwd(pwd);
		
		BoardDAO dao=new BoardDAO();
		dao.boardInsert(dto);
		
		return "list.do";
	}

}
