<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>리스트</title>
	<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
	<h3 id="title">목록보기</h3>
	<div align="center">
		<table class="button_table">
			<tr>
				<td>
					<a href="insert.do">
						<img alt="write button" src="board/image/bt_write.jpg">
					</a>
				</td>
			</tr>
		</table>
		<table id="content_table">
			<tr>
				<th width="10%">번호</th>
				<th width="40%">제목</th>
				<th width="20%">이름</th>
				<th width="20%">작성일</th>
				<th width="10%">조회수</th>
			</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td width="10%">${vo.no }</td>
				<td width="40%" id="left_td">	
					<c:if test="${vo.group_tab!=0 }">
						<c:forEach var="i" begin="1" end="${vo.group_tab }" step="1">
							&nbsp;&nbsp;
						</c:forEach>
						<img src="board/image/icon_reply.gif" alt="reply icon">	
					</c:if>
					<c:if test="${msg == vo.subject }">
						<font color="red" style="text-decoration: overline;">${vo.subject }</font>
					</c:if>
					<a href="content.do?page=${curPage }&no=${vo.no }">${vo.subject }</a>
					<fmt:formatDate var="regdate" value="${vo.regdate }" pattern="yyyy-MM-dd"/>						
					<c:if test="${regdate==today }">
						<sup><img src="board/image/new.gif" alt="new icon"></sup>
					</c:if>
				</td>
				<td width="20%">${vo.name }</td>
				<td width="20%">${regdate }</td>
				<td width="10%">${vo.hit }</td>
			</tr>
		</c:forEach>	
		</table>
		<table class="button_table">
			<tr>
				<td align="right">
					<a href="board.do?page=${curPage>1 ? curPage-1 : 1  }">
						<img src="board/image/btn_pagePrev.gif">
					</a>
					<c:forEach var="page" begin="1" end="${totalPage }" step="1">
						<a href="board.do?page=${page }">[${page }]</a>
					</c:forEach>
					<a href="board.do?page=${curPage<totalPage ? curPage+1 : totalPage  }">
						<img src="board/image/btn_pagePrev.gif">
					</a>&nbsp;
					${curPage }page / ${totalPage }page
				</td>
			</tr>	
		</table>
	</div>
</body>
</html>