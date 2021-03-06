package com.sist.model;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;

public class BoardModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		
		String no=request.getParameter("page");
		if(no==null){no="1";};
		int curPage=Integer.parseInt(no);
		
		//페이지 구분인자 설정
		int rowSize=10;
		int start=(curPage*rowSize)-(rowSize-1);
		int end=curPage*rowSize;
		
		//list생성에 사용할 값을 hashmap에 저장
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		//static으로 정의한 dao 메소드로 list 불러오기
		List<BoardVO> list=BoardDAO.boardListData(map);
		
		//totalpage 불러오기
		int totalPage=BoardDAO.boardTotalPage();
		
		request.setAttribute("list", list);
		request.setAttribute("curPage", curPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("today", today);
		request.setAttribute("jsp", "board.jsp");
		request.setAttribute("board_jsp", "../board/list.jsp");

		return "main/main.jsp";
	}

}
