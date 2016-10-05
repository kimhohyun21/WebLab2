package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Model;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * DispatcherServlet�� ��û�� ó���ϰ� �並 ǥ���ϱ� ���� ��(bean)���� ���.
	 * WebApplicationContext-������ ���ǵ� ��� ���� ����
	 */
	private WebApplicationContext wc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("xmlPath");
		wc=new WebApplicationContext(path);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			/*
			 * URL         : http://localhost:8080/MVCSiteLab/main.do		
			 * URI         : /MVCSiteLab/main.do		
			 * ContextPath : /MVCSiteLab				
			 * 				 main.do
			 */
			String cmd=request.getRequestURI();
			cmd=cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf('.'));
			Model model=(Model) wc.getBean(cmd);
			String jsp=model.handlerRequest(request);
			
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response); //==>main.jsp ����
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}




































