package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sis.xml.SawonXML;

public class DeleteModel implements Model{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sa=request.getParameter("sabun");
		int sabun=Integer.parseInt(sa);
		
		//XML.java 积己
		SawonXML xml=SawonXML.newInstance(); //static捞扼辑 newInstance肺 积己
		xml.sawonDelete(sabun);
		
		return "list.do";
	}

}
