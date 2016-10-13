package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.mgr.*;

@Controller
public class MainModel {
	
	@RequestMapping("main.do")
	public String main_page(HttpServletRequest request){
		
		MovieCGVManager mgr=new MovieCGVManager();
		List<MovieVO> list=mgr.getMovieData();
		request.setAttribute("list", list);
		
		return "main/main.jsp";
	}
}
