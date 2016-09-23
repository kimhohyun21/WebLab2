package com.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.model.*;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		//초기화 할 일이 없으면 작성하지 않아도 됨
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			/*
			 * 첫번째 mapping 방법
			 * http://localhost/DispatcherServlet?cmd=list or find or insert
			 *  		||
			 *		    \/ 
			 *  String cmd=request.getParameter("cmd");
			 */
			String cmd=request.getRequestURI();
			/* 
			 * 	http://localhost/MVCLab2/list.do
			 *	==> cmd=MVCLab2/list.do
			 */
			cmd=cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf("."));	
				
			String jsp="";
			if(cmd.equals("list")){
				ListModel model=new ListModel();
				List<MemberDTO> list=model.handlerRequest();
				request.setAttribute("list", list);
				jsp="view/list.jsp";
			}else if(cmd.equals("content")){
				ContentModel model=new ContentModel();
				MemberDTO dto=model.handlerRequest();
				request.setAttribute("dto", dto);
				jsp="view/content.jsp";
			}else if(cmd.equals("find")){
				FindModel model=new FindModel();
				String find=model.handlerRequest();
				request.setAttribute("find", find);
				jsp="view/find.jsp";
			}
			
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
