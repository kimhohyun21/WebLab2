package com.sist.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/*
 * #MVC �帧
 * 		    1)��û				2)�����Ͻ� ����ó��
 * 	����� ============> ��Ʈ�ѷ� <===================> �� 
 * 	 ^					 |
 * 	 | 					 | 3)�伱��
 * 	 |      4)����		 |	
 * 	 =================== ��
 * 
 * 			 HTTP ��û 
 *  Ŭ���̾�Ʈ ===========> ���� 	
 * 		^				 1) HTTP ��û ����
 * 		|				 2) Ŭ���̾�Ʈ�� �䱸�ϴ� ��� �м�
 * 		|				 3) ��û�� �����Ͻ� ������ ó���ϴ� �� ��� <===========> ��
 * 		|				 4) ����� request �Ǵ� session�� ����
 * 		|				 5)	�˸��� �並 ����, ��� ������(�Ǵ� �����̷�Ʈ)	
 *      |                        |
 *  	|   HTTP ����  			 |
 *      ======================= JSP(view)
 *  
 * #DispacherServlet���� ����ϴ� �޼���
 * 	1. init() : �ʱ�ȭ ��� (���� �б�, ������ ���̽� ����)
 * 	2. service() : ������ (Ŭ���̾�Ʈ ��û�� ó���ϴ� �޼ҵ�)
 *  		1) doGet() : Get��� ��û
 *  		2) doPost()	: Post ��� ��û
 *  3. destroy() : ���ΰ�ħ, ������ �̵��ÿ� �޸� ����
 *  
 * #���Ϻ� �ڵ� ���� 
 * 	1. Servlet : �ڹ��ڵ�, ����
 * 	2. JSP : ȭ��� ó��
 * 
 * #MVC ����
 * 	1. Model : �����Ͻ� ����(�Ϲ� �ڹ��ڵ�)
 * 	2. View : �±����� ���α׷� (JSTL, EL, HTML)
 * 	3. Controller : Model, View�� ����
 * 
 * #MVC����-UI 
 *  : �ڵ�� �����Ͻ� �ڵ带 �и�  ==> ���Ӽ��� ���̰�, ���뼺�� ���̰�, ���� ���� �������� ����
 * 
 * #user��û ==> controller ==> model ==> controller ==> view
 * 
 * #�ּ� ����
 *  /DispacherServlet?cmd=list
 *  
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.*;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//��û �� �ޱ�
			String cmd=request.getParameter("cmd");
			
			//��û �� �м��Ͽ� ������ model(Ŭ����) ã��
			String jsp="";
			if(cmd.equals("list")){
				ListModel list=new ListModel();
				jsp=list.handlerRequest(request);
			}else if(cmd.equals("update")){
				UpdateModel update=new UpdateModel();
				jsp=update.handlerRequest(request);
			}else if(cmd.equals("delete")){
				DeleteModel delete=new DeleteModel();
				jsp=delete.handlerRequest(request);
			}else if(cmd.equals("insert")){
				InsertModel insert=new InsertModel();
				jsp=insert.handlerRequest(request);
			}
			//�޼ҵ� ȣ�� ==> ��� ���� request or session�� ����
			
			//JSP�� ���� ==> sendRedirect, forword
			RequestDispatcher rs=request.getRequestDispatcher(jsp);
			rs.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
