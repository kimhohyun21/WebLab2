package com.sist.member.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.controller.controller;
import com.sist.dao.*;

@controller
public class MemberModel {
	
	@RequestMapping("login.do")
	public String loginForm(HttpServletRequest request){
		
		return "main/login.jsp";
	}
	
	@RequestMapping("login_ok.do")
	public String isLogin(HttpServletRequest request){
				
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		MemberDAO dao=new MemberDAO();
		int count=dao.memeberIdCheck(id);
		String result=null;
		
		if(count==0){
			result="noid";
		}else{
			MemberVO vo=dao.memberGetPwd(id);
			if(pwd.equals(vo.getPwd())){
				HttpSession session=request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("name", vo.getName());
				session.setAttribute("gender", vo.getGender());
				result="ok";
			}else{
				result="nopwd";
			}
		}
		
		request.setAttribute("result", result);
		return "main/login_ok.jsp";
	}
}
