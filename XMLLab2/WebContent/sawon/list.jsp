<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>사원 리스트</title>
	<link rel="stylesheet" type="text/css" href="sawon/table.css">
</head>
<body>
	<div align="center">
		<h3>사원 리스트</h3>	
		<table id="content_table">
			<tr>
				<th width="10%">사번</th>
				<th width="15%">이름</th>
				<th width="15%">부서</th>
				<th width="20%">지역</th>
				<th width="20%">입사일</th>
				<th width="20%">비고</th>
			</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td width="10%">${vo.sabun }</td>
				<td width="15%">${vo.name }</td>
				<td width="15%">${vo.dept }</td> 
				<td width="20%">${vo.loc }</td>
				<td width="20%">${vo.hiredate }</td>
				<td width="20%" align="center">
					<a href="#">수정</a> |
					<a href="delete.do?sabun=${vo.sabun }">삭제</a>
				</td>
			</tr>
		</c:forEach>	
		</table>
	</div>
</body>
</html>