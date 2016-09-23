package com.sist.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.sist.model.*;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map clsMap=new HashMap(); //hashmap은 key, value 구조
	
	private String[] strCls={
		"com.sist.model.ListModel",
		"com.sist.model.InsertModel",
		"com.sist.model.UpdateModel",
		"com.sist.model.DeleteModel"
	};
	
	private String[] strCmd={
		"list", "insert", "update", "delete"	
	};

	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
		 * hashmap을 생성하고 거기에 값을 지정
		 * clsMap.put("list", new ListModel());
		 * clsMap.put("insert", new InsertModel());
		 * clsMap.put("update", new UpdateModel());
		 * clsMap.put("delete", new DeleteModel());
		 */
		try{
			for(int i=0;i<strCmd.length;i++){
				Class clsName=Class.forName(strCls[i]);
				Object obj=clsName.newInstance(); //객체 생성
				System.out.println(strCmd[i]+"=="+obj);
				
				clsMap.put(strCmd[i], obj);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			/*
			 * http://localhost:8090/MVCLab2/list.do
			 *						===============
			 *							uri
			 */
			String cmd=request.getRequestURI();
			System.out.println("1. cmd="+cmd);
			
			cmd=cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf("."));
			//						  ===============
			//							  MVCLab2
			//==> cmd="list" ==> hashmap의 호출할 키 값으로 사용
			System.out.println("2. cmd="+cmd);
			
			Model model=(Model) clsMap.get(cmd); // "new ListModel"이 할달되어 있음 ==> ListModel객체 생성
			String jsp=model.handlerRequest(request); // "view/list.jsp"가 할당되어 있음
			
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
