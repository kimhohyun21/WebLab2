<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>글쓰기</title>
</head>
<body>
	<div align="center">
		<c:if test="${page==null }">
			<c:set var="page" value="1"></c:set>
		</c:if>
		<c:if test="${page!=null }">
			<c:set var="page" value="${page }"></c:set>
		</c:if>
		<form action="list.do?page=${page }" method="post">
			<input type="hidden" value="${page }">
			<input type="submit" value="back">
		</form>
	</div>
</body>
</html>