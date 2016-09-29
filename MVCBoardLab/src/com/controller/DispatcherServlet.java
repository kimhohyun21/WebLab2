package com.controller;

import java.io.*;
import java.util.*;
import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//HashMap 생성
	private Map clsMap=new HashMap();

	//초기화
	@Override
	public void init(ServletConfig config) throws ServletException {
		try{
			String path=config.getInitParameter("contextConfigLocation"); 
			//beans.xml을 일기 위해 web.xml 파일의 path읽어오기
			System.out.println(path);
			
			//Dom을 생성하기 위한 factory와 builder 생성
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			
			//beans.xml에 저장되어 있는 class 불러오기위해 읽어 올 파일 지정
			Document doc=db.parse(new File(path));
			
			//저장된 클래스에서 root를 생성
			Element root=doc.getDocumentElement();
			
			//root에서 bean(class)를 읽어서 list로 저장
			NodeList list=root.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++){
				//list에 저장된 bean을 Element로 받아 오기 
				Element elem=(Element) list.item(i);
				
				//받아온 bean의 속성을 각각 String으로 저장
				String id=elem.getAttribute("id");
				String cls=elem.getAttribute("class");
				
				//bean의 클래스 이름으로부터 클래스의 정보를 읽어옴 
				//==> 메소드, 멤버변수 제어 가능
				Class clsName=Class.forName(cls);
				
				//읽어온 클래스 정보를 메모리에 할당
				Object obj=clsName.newInstance();
				System.out.println(obj);
				//==> 정상적으로 할당되면 해시값이 출력
				
				//생성한 해시맵에 클래스의 id를 key로 클래스의 해시값을  value로 저장
				clsMap.put(id, obj);
			}
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			/*
			 * list.do
			 * content.do ==> dispatcherServlet 
			 * 			  ==> service 수행
			 * 			  ==> <uri-param>*.do</uri-param>
			 */
			
			//사용자 요청 ==> URL ==> URL에서 uri 저장
			String cmd=request.getRequestURI();
			     //==> "MVCBoardLab/list.do" 저장됨 
			
			//uri에서 key값을 활용할 list만 추출
			cmd=cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf("."));
			
			//key값으로 Model을 생성하여 제어권을 넘김 
			Model model=(Model) clsMap.get(cmd);
			
			//hadlerRequest 메서드 사용 ==> 요청에 따른 view(jsp)를 받아오기
			String jsp=model.handlerRequest(request, response);
			
			
			String temp=jsp.substring(jsp.lastIndexOf(".")+1);
			
			if(!temp.equals("do") && !temp.equals("jsp")){
				temp=temp.substring(0, temp.lastIndexOf("?"));
			}
			
			System.out.println(temp);
			if(temp.equals("do")){
				response.sendRedirect(jsp);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher(jsp);
				rd.forward(request, response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
