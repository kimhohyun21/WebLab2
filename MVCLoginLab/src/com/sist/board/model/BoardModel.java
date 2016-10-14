package com.sist.board.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
import com.sist.controller.controller;

@controller
public class BoardModel {
	
	@RequestMapping("list.do")
	public String boardList(HttpServletRequest request){
		
		return "main/list.jsp";
	}
}
