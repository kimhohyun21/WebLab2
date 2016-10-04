package com.sist.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.Model;

public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map clsMap=new HashMap();
	
	String[] strCls={"com.sist.model.ListModel", "com.sist.model.DeleteModel"};
	String[] strCmd={"list", "delete"};
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try {
			for(int i=0; i<strCmd.length;i++){
				Class clsName=Class.forName(strCls[i]);
				
				//리플렉션
				Object obj=clsName.newInstance();
				clsMap.put(strCmd[i], obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String cmd=request.getRequestURI(); //==> XMLLab2/list.do
			cmd=cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf(".")); //==> list
			
			Model model= (Model) clsMap.get(cmd); //ListModel
			
			String jsp=model.execute(request, response); //sawon/list.jsp
			System.out.println(jsp);
			String ext=jsp.substring(jsp.lastIndexOf(".")+1); //jsp
			System.out.println(ext);
			
			if(ext.equals("do")){
				response.sendRedirect(jsp);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher(jsp);
				rd.forward(request, response);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
