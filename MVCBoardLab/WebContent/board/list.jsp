<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>게시판 리스트</title>
	<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
	<div align="center">
		<h3>목록보기</h3>
		<table class="button_table">
			<tr>
				<td>
					<a href="insert.do">
						<img alt="write button" src="board/img/btn_write.gif">
					</a>
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
		<c:forEach var="dto" items="${list }">
			<tr>
				<td width="10%">${dto.no }</td>
				<td width="45%" id="left_td">
					${dto.subject }
				</td>
				<td width="15%">${dto.name }</td>
				<td width="20%">${dto.regdate }</td>
				<td width="10%">${dto.hit }</td>		
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>