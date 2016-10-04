package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sis.xml.*;
import java.util.*;

public class ListModel implements Model{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SawonXML xml=SawonXML.newInstance();
		List<SawonVO> list=xml.sawonAllData();
		
		request.setAttribute("list", list);
		
		return "sawon/list.jsp";
	}
	
}
