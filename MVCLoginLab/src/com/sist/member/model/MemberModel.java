package com.sist.member.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
import com.sist.controller.controller;

@controller
public class MemberModel {
	
	@RequestMapping("login.do")
	public String loginForm(HttpServletRequest request){
		
		return "main/login.jsp";
	}
}
