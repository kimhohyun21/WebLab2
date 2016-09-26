package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;

import java.text.*;
import java.util.*;

public class ListModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		
		String strPage=request.getParameter("page");
		if(strPage==null){strPage="1"; }
		int curPage=Integer.parseInt(strPage);
		
		List<BoardDTO> list=dao.boardListData(curPage);
		int totalPage=dao.boardTotal();
		int count=dao.boardCount();
		count=count-((curPage*5)-5);
		
		String msg="관리자에 의해서 삭제된 게시물입니다.";
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		//[1][2][3][4][5][6]....==> 블록나누기
		//fp		  tp 	  					
		int block=5;
		int fromPage=((curPage-1)/block*block)+1;
		int toPage=((curPage-1)/block*block)+block;
		
		if(toPage>totalPage)toPage=totalPage;
				
		request.setAttribute("list", list);
		request.setAttribute("curPage", curPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("count", count);
		request.setAttribute("msg", msg);
		request.setAttribute("today", today);
		request.setAttribute("block", block);
		request.setAttribute("fromPage", fromPage);
		request.setAttribute("toPage", toPage);
		
		return "board/list.jsp";
	}

}
