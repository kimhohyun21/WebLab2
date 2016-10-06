package com.sist.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;

public class BoardModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) throws Exception {
		
		String no=request.getParameter("page");
		if(no==null){no="1";};
		int curPage=Integer.parseInt(no);
		
		//������ �������� ����
		int rowSize=10;
		int start=(curPage*rowSize)-(rowSize-1);
		int end=curPage*rowSize;
		
		//list������ ����� ���� hashmap�� ����
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		//static���� ������ dao �޼ҵ�� list �ҷ�����
		List<BoardVO> list=BoardDAO.boardListData(map);
		
		//totalpage �ҷ�����
		int totalPage=BoardDAO.boardTotalPage();
		
		request.setAttribute("list", list);
		request.setAttribute("curPage", curPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("jsp", "board.jsp");
		
		return "main/main.jsp";
	}

}
