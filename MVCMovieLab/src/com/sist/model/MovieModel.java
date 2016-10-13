package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.*;
import com.sist.mgr.*;

@Controller
public class MovieModel {
	
	@RequestMapping("movie_detail.do")
	public String movie_detail(HttpServletRequest request){
		String no=request.getParameter("no");
		
		MovieCGVManager mgr=new MovieCGVManager();
		MovieVO vo=mgr.getMovieData().get(Integer.parseInt(no)-1);
		
		request.setAttribute("vo", vo);
		
		return "movie/detail.jsp";
	}
}
