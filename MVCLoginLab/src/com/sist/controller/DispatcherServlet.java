package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> clsList=new ArrayList<>();
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getInitParameter("contextConfigLocation");
		FileConfig fc=new FileConfig(path);
		clsList=fc.componentScan();
	}
	
	//login.do ¿äÃ»
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI();
		//==> http://localhost:8080/MVCLoginLab/login.do
		cmd=cmd.substring(request.getContextPath().length()+1);
		//==> /MVCLoginLab/login.do
		
		try{
			for(String strCls : clsList){
				Class clsName=Class.forName(strCls);
				if(clsName.isAnnotationPresent(controller.class)==false){
					continue;
				}
				Object obj=clsName.newInstance();
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m: methods){
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(cmd.equals(rm.value())){
						String jsp=(String) m.invoke(obj, request);
						
						RequestDispatcher rd=request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						return;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
