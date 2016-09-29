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
	
	//HashMap ����
	private Map clsMap=new HashMap();

	//�ʱ�ȭ
	@Override
	public void init(ServletConfig config) throws ServletException {
		try{
			String path=config.getInitParameter("contextConfigLocation"); 
			//beans.xml�� �ϱ� ���� web.xml ������ path�о����
			System.out.println(path);
			
			//Dom�� �����ϱ� ���� factory�� builder ����
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			
			//beans.xml�� ����Ǿ� �ִ� class �ҷ��������� �о� �� ���� ����
			Document doc=db.parse(new File(path));
			
			//����� Ŭ�������� root�� ����
			Element root=doc.getDocumentElement();
			
			//root���� bean(class)�� �о list�� ����
			NodeList list=root.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++){
				//list�� ����� bean�� Element�� �޾� ���� 
				Element elem=(Element) list.item(i);
				
				//�޾ƿ� bean�� �Ӽ��� ���� String���� ����
				String id=elem.getAttribute("id");
				String cls=elem.getAttribute("class");
				
				//bean�� Ŭ���� �̸����κ��� Ŭ������ ������ �о�� 
				//==> �޼ҵ�, ������� ���� ����
				Class clsName=Class.forName(cls);
				
				//�о�� Ŭ���� ������ �޸𸮿� �Ҵ�
				Object obj=clsName.newInstance();
				System.out.println(obj);
				//==> ���������� �Ҵ�Ǹ� �ؽð��� ���
				
				//������ �ؽøʿ� Ŭ������ id�� key�� Ŭ������ �ؽð���  value�� ����
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
			 * 			  ==> service ����
			 * 			  ==> <uri-param>*.do</uri-param>
			 */
			
			//����� ��û ==> URL ==> URL���� uri ����
			String cmd=request.getRequestURI();
			     //==> "MVCBoardLab/list.do" ����� 
			
			//uri���� key���� Ȱ���� list�� ����
			cmd=cmd.substring(request.getContextPath().length()+1, cmd.lastIndexOf("."));
			
			//key������ Model�� �����Ͽ� ������� �ѱ� 
			Model model=(Model) clsMap.get(cmd);
			
			//hadlerRequest �޼��� ��� ==> ��û�� ���� view(jsp)�� �޾ƿ���
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
