<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, com.sist.dao.*, com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="model" class="com.sist.model.BoardModel"></jsp:useBean>
<%
	model.handlerRequest(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>게시판 리스트</title>
	<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<div align="center">
		<h3>목록 보기</h3>
		<table class="button_table">
			<tr>
				<td>
					<img alt="write button" src="img/bt_write.jpg">
				</td>
			</tr>
		</table>
		<table id="content_table">
			<tr>
				<th width="10%">번호</th>
				<th width="45%">제목</th>
				<th width="15%">이름</th>
				<th width="20%">작성일</th>
				<th width="10%">조회수</th>
			</tr>
			
			<c:forEach var="vo" items="${list }">
			<tr>
				<td width="10%">${rownum=rownum-1 }</td>
				<td width="45%" id="left_td">
				<c:if test="${vo.group_tab!=0 }">
					<c:forEach begin="0" end="${vo.group_tab }" step="1">
						&nbsp;			
					</c:forEach>
					<img alt="reply icon" src="img/icon_reply.gif">
				</c:if>
				<c:if test="${msg eq vo.subject }">			
					<span style="color: gray;">${vo.subject }</span>
				</c:if>
				<c:if test="${msg ne vo.subject }">			
					${vo.subject }
				</c:if>	
				<c:if test="${today eq vo.dbday }">
					<sup><img alt="new icon" src="img/new.gif"></sup>
				</c:if>						
				</td>
				<td width="15%">${vo.name }</td>
				<td width="20%">${vo.regdate }</td>
				<td width="10%">${vo.hit }</td>
			</tr>
			</c:forEach>
		</table>
		<table class="button_table">
			<tr>
				<td>
					
				</td>
				<td align="right">
					<a href="list.jsp?page=1">
						<img alt="First button" src="img/btn_pageFirst.gif">
					</a>
					<a href="list.jsp?page=${curPage>1 ? curPage-1 : curPage }">
						<img alt="Prev button" src="img/btn_pagePrev.gif">
					</a>
					<c:forEach var="curPage" begin="1" end="${totalPage }" step="1">
						<a href="list.jsp?page=${curPage }">[${curPage }]</a>			
					</c:forEach>
					<a href="list.jsp?page=${curPage<totalPage ? curPage+1 : totalPage }">
						<img alt="Next button" src="img/btn_pageNext.gif">
					</a>
					<a href="list.jsp?page=${totalPage }">
						<img alt="Last button" src="img/btn_pageLast.gif">
					</a>
					&nbsp;&nbsp;
					${curPage }page / ${totalPage }page
				</td>
			</tr>
		</table>
	</div>
</body>
</html>