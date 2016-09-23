<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>List</title>
	<style type="text/css">
		table, th, td{
			border: 1px solid black;
			width: 300px;
			border-collapse: collapse;
			text-align: center;
		}
		th{
			background-color: #eeefff;
		}
	</style>
</head>
<body>
	<div align="center">
		<h3>주소 리스트</h3>
		<table>
			<tr>
				<th width="35%">이름</th>
				<th width="30%">성별</th>
				<th width="35%">주소</th>
			</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td width="35%">${vo.name }</td>
				<td width="30%">${vo.gender }</td>
				<td width="35%">${vo.addr }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>