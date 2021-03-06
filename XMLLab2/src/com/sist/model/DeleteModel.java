package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sis.xml.SawonXML;

public class DeleteModel implements Model{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sa=request.getParameter("sabun");
		int sabun=Integer.parseInt(sa);
		
		//XML.java 생성
		SawonXML xml=SawonXML.newInstance(); //static이라서 newInstance로 생성
		xml.sawonDelete(sabun);
		
		return "list.do";
	}

}
