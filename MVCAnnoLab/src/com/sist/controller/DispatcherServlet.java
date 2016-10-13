package com.sist.controller;

import javax.servlet.http.HttpServlet;

import java.lang.reflect.Method;
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
				//Class 객체 얻기, 클래스 정보를 가져옴 => getClass(), forName()
				Class clsName=Class.forName(strCls);
				
				if(clsName.isAnnotationPresent(Controller.class)==false){
					continue; // 어노테이션이 없는 경우는 제외
				}
				
				Object obj=clsName.newInstance(); //메모리에 할당
				Controller ct=(Controller) clsName.getAnnotation(Controller.class);
				
				//리플렉션 : 클래스 안에 있는 생성자, 필드, 메소드 정보를 알아내는 것
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
