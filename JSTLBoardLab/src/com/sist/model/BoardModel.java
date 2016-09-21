package com.sist.model;
/*
 * #MVC ����
 * 	1. ��1 
 * 		1) ����
 * 			- JSP�� �̿��� �ܼ��� ��
 * 			- JSP���� ��û ó�� �� �� ���� ó��
 * 		2) ���� 
 * 			- �ڵ尡 �ڼ��� �־� ������
 * 
 * 	2. �� 2 : MVC ����
 * 		1) ���� 
 * 			- ������ ��û�ϰ� JSP�� �並 ����
 * 			- ��� ��û�� ���� �������� ó��
 * 			- ��û ó�� �� ����� ������ JSP�� �̵�
 * 	
 *  3. Model-View-Controller
 * 		1) �� : �����Ͻ� ������ ���� ������ ó����
 * 		2) �� : �����Ͻ� ������ ���� ���������̼� ��(����ڰ� ���Ե� ȭ�� )�� ���
 * 		3) ��Ʈ�ѷ� : ������� �Է� �� �帧 ����
 * 		4) �� 2 ������ ���� : ��Ʈ�ѷ�-����, ��-JSP		
 */
import com.sist.dao.*;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class BoardModel {
	public void handlerRequest(HttpServletRequest request){
		BoardDAO dao=new BoardDAO();
		
		//page �Ķ���� �� ����
		String strPage=request.getParameter("page");
		if(strPage==null){strPage="1";}
		int curPage=Integer.parseInt(strPage);
		
		//dao �޼ҵ� ��� : ����Ʈ �޾ƿ���
		List<BoardVO> list=dao.boardListData(curPage);
		
		//dao �޼ҵ� ��� : ��ü������ �޾ƿ��� 
		int totalPage=dao.boardTotalpage();
				
		//���� ��¥ ���� : ���� DB ��¥�� ��
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		//������ �Խù��� ���� �˸����� ����� ���ڿ�
		String msg="�����ڿ� ���� ������ �Խù� �Դϴ�.";
		
		//page�� ���� ��ȣ ������ ���� ����
		int rowCount=dao.rowCount();
		int rownum=rowCount-((curPage-1)*10)+1;
		System.out.println(rownum);
		
		//�ٸ� ���������� ����ϱ� ���� ���� ����
		request.setAttribute("curPage", curPage);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("today", today);
		request.setAttribute("msg", msg);
		request.setAttribute("rownum", rownum);
		/*
		 * #���� : jsp �� �ۼ��� ��� ����
		 * 	<c:set var="list" value=<%=list %> />
		 */
	}
}
