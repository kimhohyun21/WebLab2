<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, com.sist.controller.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>리스트 출력</title>
</head>
<body>
	<div align="center">
		<h3>이름 리스트</h3>
		<table>
			<tr>
				<td>
					<ul>
						<c:forEach var="name" items="${list }">
							<li>${name }</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>