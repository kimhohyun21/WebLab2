package com.sist.controller;

import javax.servlet.http.HttpServlet;

import java.lang.reflect.Method;
import java.util.*;

/*
 * #MVC �帧
 * 	1. Client ��û
 * 	2. Server ���� : web.xml �б�
 * 		: XML ==> Ư�� package ���
 * 	3. DispatcherServlet ȣ�� : @Controller
 * 		: pakage�� ��ϵ� ����  ==> DispatcherServlet.java 
 * 	4. @RequestMapping() ==> ��û�� ������ ã�Ƽ� ȣ��
 * 
 */

//3. ������̼� ���
public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){
		try{
			
			List<String> list=FileConfig.componentScan("com.sist.model"); 
			/*
			 * list.add("com.sist.model.A");
			 * list.add("com.sist.model.B");
			 * list.add("com.sist.model.C");
			 * list.add("com.sist.model.D");
			 */
			
			Scanner scan=new Scanner(System.in);
			System.out.print("A-class:a.do / B-class:b.do / C-class:c.do : ");
			String cmd=scan.next();
			
			for(String strCls : list){
				//Class ��ü ���, Ŭ���� ������ ������ => getClass(), forName()
				Class clsName=Class.forName(strCls);
				
				if(clsName.isAnnotationPresent(Controller.class)==false){
					continue; // ������̼��� ���� ���� ����
				}
				
				Object obj=clsName.newInstance(); //�޸𸮿� �Ҵ�
				Controller ct=(Controller) clsName.getAnnotation(Controller.class);
				
				//���÷��� : Ŭ���� �ȿ� �ִ� ������, �ʵ�, �޼ҵ� ������ �˾Ƴ��� ��
				if(cmd.equals(ct.value())){
					Method[] method=clsName.getDeclaredMethods();
					String s=(String) method[0].invoke(obj);
					
					System.out.println(s);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
