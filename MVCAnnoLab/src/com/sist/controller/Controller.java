package com.sist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * 1. ������
 * 	1) class ==> ElementType.TYPE
 * 	2) method ==> ElementType.METHOD
 * 	3) ������� ==> ElementType.FIELD
 *  4) �Ű����� ==> ElementType.PARAMETER
 *  
 * 2. ���� ���
 * 	: �����Ϸ��� �������� �տ� @���� ����
 * 	 
 * 	Ex)
 * 		@������̼�
 * 		Class A{
 *    
 *    		@������̼�	
 *    		B b;
 *    
 *    		@������̼�
 *    		public void dis(@������̼� String c){
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

//1. ������̼� ����
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //������̼��� class�� ����
public @interface Controller {
	public String value();
}
