package com.sist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * 1. 구분자
 * 	1) class ==> ElementType.TYPE
 * 	2) method ==> ElementType.METHOD
 * 	3) 멤버변수 ==> ElementType.FIELD
 *  4) 매개변수 ==> ElementType.PARAMETER
 *  
 * 2. 적용 방식
 * 	: 적용하려는 구분자의 앞에 @으로 선언
 * 	 
 * 	Ex)
 * 		@어노테이션
 * 		Class A{
 *    
 *    		@어노테이션	
 *    		B b;
 *    
 *    		@어노테이션
 *    		public void dis(@어노테이션 String c){
 *    
 *    		}
 *  	}
 * 
 * 	Ex2)
 * 		@RequestMapping("a.do")
 * 		public String aaa(MemberVO vo){
 * 			dao.insert(vo);
 * 			return "redirect:list.jsp";
 * 		}
 */

//1. 어노테이션 정의
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //어노테이션을 class로 적용
public @interface Controller {
	public String value();
}
