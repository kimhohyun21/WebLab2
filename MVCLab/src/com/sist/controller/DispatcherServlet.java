package com.sist.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/*
 * #MVC 흐름
 * 		    1)요청				2)비지니스 로직처리
 * 	사용자 ============> 컨트롤러 <===================> 모델 
 * 	 ^					 |
 * 	 | 					 | 3)뷰선택
 * 	 |      4)응답		 |	
 * 	 =================== 뷰
 * 
 * 			 HTTP 요청 
 *  클라이언트 ===========> 서블릿 	
 * 		^				 1) HTTP 요청 받음
 * 		|				 2) 클라이언트가 요구하는 기능 분석
 * 		|				 3) 요청한 비지니스 로직을 처리하는 모델 사용 <===========> 모델
 * 		|				 4) 결과를 request 또는 session에 저장
 * 		|				 5)	알맞은 뷰를 선택, 뷰로 포워딩(또는 리다이렉트)	
 *      |                        |
 *  	|   HTTP 응답  			 |
 *      ======================= JSP(view)
 *  
 * #DispacherServlet에서 사용하는 메서드
 * 	1. init() : 초기화 기능 (파일 읽기, 데이터 베이스 연결)
 * 	2. service() : 쓰레드 (클라이언트 요청을 처리하는 메소드)
 *  		1) doGet() : Get방식 요청
 *  		2) doPost()	: Post 방식 요청
 *  3. destroy() : 새로고침, 페이지 이동시에 메모리 해제
 *  
 * #파일별 코딩 내용 
 * 	1. Servlet : 자바코딩, 보안
 * 	2. JSP : 화면단 처리
 * 
 * #MVC 정리
 * 	1. Model : 비지니스 로직(일반 자바코딩)
 * 	2. View : 태그형의 프로그램 (JSTL, EL, HTML)
 * 	3. Controller : Model, View를 연결
 * 
 * #MVC패턴-UI 
 *  : 코드와 비지니스 코드를 분리  ==> 종속성은 줄이고, 재사용성을 높이고, 보다 쉬운 유지보수 가능
 * 
 * #user요청 ==> controller ==> model ==> controller ==> view
 * 
 * #주소 형식
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
			//요청 값 받기
			String cmd=request.getParameter("cmd");
			
			//요청 값 분석하여 적절한 model(클래스) 찾기
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
			//메소드 호출 ==> 결과 값은 request or session에 저장
			
			//JSP로 전송 ==> sendRedirect, forword
			RequestDispatcher rs=request.getRequestDispatcher(jsp);
			rs.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
