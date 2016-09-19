<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	#JSTL
		1. 정의
		   JSTL은 자신만의 태그를 추가할 수 있는 기능 제공
		   <jsp:include>나 <jsp:useBean>과 같은 커스텀 태그처럼
		      연산이나 조건문이나 반복문인 if문, for문, DB를 편리하기 처리할 수 있는 태그 라이브러리
		
		2. 종류
			1) 변수, 제어문 등의 자바코드를 대처
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			2) XML 연동 처리
				<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
			3) 국제표준화 형식(날짜, 화폐 등)
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			4) 데이터베이스 연동 sql 처리
				<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
			5) 함수 
				<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSTL</title>
</head>
<body>
	<div align="center">
		<h3>구구단</h3>
		<%
			for(int i=1;i<=9;i++){
		%>	
			<%=5+"*"+i+"="+5*i %><br/>
		<%	
			}
		%>
		<br/><br/>
		<h3>JSTL을 이용한 구구단</h3>
		<c:forEach var="i" begin="1" end="9" step="1">
			5*${i }=${5*i }<br/>
		</c:forEach>
		<br/><br/>
		
		<h3>forEach문 출력</h3>
		<%
			String[] names={"정도전", "이인임", "이성계", "이방원", "이도"};
			for(String n : names){
		%>
			<%=n %><br/>
		<% 		
			}
		%>
		<br/><br/>
		
		<h3>JSTL을 이용한 forEach문 출력</h3>
		<c:set var="n" value="<%=names %>">
		<%--
			request.setAttribute("n", names)와 동일
		 --%>
		</c:set>
		
		<c:forEach var="name" items="${n }">
			${name }<br/>
		</c:forEach>
		<br/><br/>
		
		<h3>JSTL if문 짝수 출력</h3>
		<c:forEach var="i" begin="1" end="10">
			<c:if test="${i%2==0 }">
				${i }<br/>
			</c:if>
		</c:forEach>

		
	</div>
</body>
</html>