package com.sist.controller;

import javax.servlet.http.HttpServlet;
import java.util.*;

/*
 * #MVC 흐름
 * 	1. Client 요청
 * 	2. Server 실행 : web.xml 읽기
 * 		: XML ==> 특정 package 등록
 * 	3. DispatcherServlet 호출 : @Controller
 * 		: pakage에 등록된 파일  ==> DispatcherServlet.java 
 * 	4. @RequestMapping() ==> 요청한 파일을 찾아서 호출
 * 
 */

//3. 어노테이션 사용
public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){
		try{
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
