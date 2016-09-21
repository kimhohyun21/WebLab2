package com.sist.model;
/*
 * #MVC 패턴
 * 	1. 모델1 
 * 		1) 구조
 * 			- JSP를 이용한 단순한 모델
 * 			- JSP에서 요청 처리 및 뷰 생성 처리
 * 		2) 단점 
 * 			- 코드가 뒤섞여 있어 복잡함
 * 
 * 	2. 모델 2 : MVC 패턴
 * 		1) 구조 
 * 			- 서블릿이 요청하고 JSP가 뷰를 생성
 * 			- 모든 요청을 단일 서블릿에서 처리
 * 			- 요청 처리 후 경과를 보여줄 JSP로 이동
 * 	
 *  3. Model-View-Controller
 * 		1) 모델 : 비지니스 영역의 상태 정보를 처리함
 * 		2) 뷰 : 비지니스 영역에 대한 프리젠테이션 뷰(사용자가 보게될 화면 )를 담당
 * 		3) 컨트롤러 : 사용자의 입력 및 흐름 제어
 * 		4) 모델 2 구조와 매핑 : 컨트롤러-서블릿, 뷰-JSP		
 */
import com.sist.dao.*;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class BoardModel {
	public void handlerRequest(HttpServletRequest request){
		BoardDAO dao=new BoardDAO();
		
		//page 파라미터 값 설정
		String strPage=request.getParameter("page");
		if(strPage==null){strPage="1";}
		int curPage=Integer.parseInt(strPage);
		
		//dao 메소드 사용 : 리스트 받아오기
		List<BoardVO> list=dao.boardListData(curPage);
		
		//dao 메소드 사용 : 전체페이지 받아오기 
		int totalPage=dao.boardTotalpage();
				
		//현재 날짜 설정 : 추후 DB 날짜와 비교
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		//삭제된 게시물에 대한 알림으로 사용할 문자열
		String msg="관리자에 의해 삭제된 게시물 입니다.";
		
		//page별 연속 번호 지정을 위한 설정
		int rowCount=dao.rowCount();
		int rownum=rowCount-((curPage-1)*10)+1;
		System.out.println(rownum);
		
		//다른 페이지에서 사용하기 위해 값을 셋팅
		request.setAttribute("curPage", curPage);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("today", today);
		request.setAttribute("msg", msg);
		request.setAttribute("rownum", rownum);
		/*
		 * #참고 : jsp 로 작성할 경우 예시
		 * 	<c:set var="list" value=<%=list %> />
		 */
	}
}
