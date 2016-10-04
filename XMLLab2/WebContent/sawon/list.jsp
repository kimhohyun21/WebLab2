<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>��� ����Ʈ</title>
	<link rel="stylesheet" type="text/css" href="sawon/table.css">
</head>
<body>
	<div align="center">
		<h3>��� ����Ʈ</h3>	
		<table id="content_table">
			<tr>
				<th width="10%">���</th>
				<th width="15%">�̸�</th>
				<th width="15%">�μ�</th>
				<th width="20%">����</th>
				<th width="20%">�Ի���</th>
				<th width="20%">���</th>
			</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td width="10%">${vo.sabun }</td>
				<td width="15%">${vo.name }</td>
				<td width="15%">${vo.dept }</td> 
				<td width="20%">${vo.loc }</td>
				<td width="20%">${vo.hiredate }</td>
				<td width="20%" align="center">
					<a href="#">����</a> |
					<a href="delete.do?sabun=${vo.sabun }">����</a>
				</td>
			</tr>
		</c:forEach>	
		</table>
	</div>
</body>
</html>