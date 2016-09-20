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
				- 일반 프로그래밍에서 제공하는 것과 유사한 변수 선언
				- 실행 흐름의 제어 기능을 제공
				- 페이지 이동 기술 제공
				- 주요 태그
					= set, out, remove
					= if, otherwise, choose, when
					= import, redirect, url, param
				
			2) XML 연동 처리
				<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
				- XML 문서를 처리할 때 필요한 기능 제공
				- 주요 태그
					= out, parse, set
					= if, otherwise, when, choose
					= transform, param
			
			3) 국제표준화 형식(날짜, 화폐 등)
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				- formatting
				- 숫자, 날짜, 시간을 포메팅하는 기능을 제공
				- 국제화, 다국어 지원 기능을 제공	
				- 주요 태그	
					= setLocale
					= requestEncoding
					= formatNumber, formateDate, timeZone
					
			4) 데이터베이스 연동 sql 처리
				<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
				- DB의 데이터를 입력/수정/삭제/조회하는 기능 제공
				- 주요 태그
					= setDataSource, query, update..
			
			5) 함수 
				<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
				- 문자열을  제어하는 기능을 가진 함수 제공
				- 주요 태그
					= length, split, trim
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
			<c:set> 태그
				- request.setAttribute("n", names)와 동일
				- 변수 값을 설정하거나, 객체의 멤버 변수 값을 설정할 때 사용
				- 사용 가능한 속성
					= value 속성 : 저장할 변수 값
					= var 속성 : 값이 저장될 변수의 이름
					= target : 값이 저장될 객체의 이름
					= property : target 객체의 멤버 변수 이름
					= scope : 값이 저장될 범위(기본값 : page)
		 --%>
		</c:set>
		
		<c:forEach var="name" items="${n }">
			${name }<br/>
		</c:forEach>
		<%--
			<c:forEach> 태그
				- 반복문과 관련된 태그, Java의 for문과 유사함
				- 가장 널리 사용되는 태그 중 하나
				- 사용 가능한 속성
					= var 속성 : 현재 아이템이 있는 변수
					= begin 속성 : 반복 시작 번호 (기본값 : 0)
					= end 속성 : 반복 끝 번호(기본값 : 해당 컬렉션의 마지막 값)
					= step 속성 : 반복의 증가문(기본값 : 1)
					= item 속성 : 반복을 위한 데이터를 가진 아이템의 컬렉션
					= varStatus : 반복 상태 값이 있는 변수			
		 --%>
		<br/><br/>
		
		<h3>JSTL if문 짝수 출력</h3>
		<c:forEach var="i" begin="1" end="10">
			<c:if test="${i%2==0 }">
				${i }<br/>
			</c:if>
		</c:forEach>
		<br/>
		 
		<%--
			if(a==1)red
			else if(a==2)blue
			else if(a==3)green
			else black
			
			==> 이 구문을 JSTL로 표기할 경우
		 --%>
		<c:choose>
			<c:when test="${a==1 }">red</c:when>
			<c:when test="${a==2 }">blue</c:when>
			<c:when test="${a==3 }">green</c:when>
			<c:otherwise>black</c:otherwise>
		</c:choose>
		<%--
			<c:choose>, <c:when>, <c:otherwise> 태그
				- 자바의 if ~ else if문, switch문과 유사
				- 사용가능한 속성
					=test 속성 : 검사할 조건, 필수 속성
		 --%>
		 <br/><br/>
		 
		 <c:forTokens var="color" items="red, blue, green" delims=",">
		 	${color }
		 </c:forTokens>
		 <%--
		 	<c:forTokens> 태그
			 	- 기본적으로 for문과 유사
			 	- 문자열을 토큰으로 구분해 처리하는 기능 제공
			 	- Java의 StringTokenizer 클래스와 유사
			 	- 사용 가능한 속성
			 		= items 속성 : 반복을 위한 데이터를 가진 아이템의 컬렉션
			 		= delims 속성 : 구분자로 사용할 문자, 필수 속성
			 		= var 속성 : 현재 아이템이 있는 변수		 	
		  --%>
	</div>
</body>
</html>