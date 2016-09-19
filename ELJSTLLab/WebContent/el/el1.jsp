<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
	#EL(Expression Language): 표현언어
		1. 등장 배경
			1) 시기 : JSTL(JSP Standard Tag Library)이 나왔을 때, EL도 소개됨
			2) 목적 : MVC 패턴에 따라 뷰(view)역할을 수행하는 JSP를 더욱 효과적으로 만들려는 목적으로 개발됨
			3) 뿌리 : SPEL(Simplest Possible EL)에서 파생 고안된 언어임
		
		2. 사용법
			1) 형식 : ${출력문(연산도 가능)}
				- Ex) 기존 : request.getParameter("id");
						==> ${param.id}
					    기존 : request.getAttribute("id");	
					    ==> ${requestScope.id}
					    ==> ${id}
					    기존 : session.getAttribute("id");
					    ==> ${sessionScop.id   
					    
			2) EL에서 사용가능한 내장객체 
				- EL에서는 객체가 생성되어 전달 된다는 것을 가정하고 있음
				- 사용시점에서 객체를 선언할 필요가 없음
			
			3) EL에서 사용가능한 연산자
				- 산술연산자 : + / - * %
					${10+10} ==> 20
					${"10"+1} ==> Integer.parseInt("10")+1 ==> 11
						: EL에서 산술연산자는 문자열 결합 역할 X, 산술연산만 실행
					${null+1} ==> null은 0으로 변환 ==> 1
					${5/2} ==> 2.5 EL에서는 실수 값
					${5%2} ==> 1
					
				- 비교 / 조건 연산자 ==> true/false
					== 혹은 eq
					!= 혹은 en
					 < 혹은 lt
					 > 혹은 gt
					<= 혹은 le
					>= 혹은 ge
					a ? b : c
				
				- 논리 연산자 ==> true/false
					&& 혹은 and
					|| 혹은 or
					!  혹은 not
					
				- empty
 --%>
 <%
 	String name="정도전";
 	//request에 저장
 	request.setAttribute("name", name);
 	//session에 저장
 	session.setAttribute("id", "admin");
 	//${sessionScope.id} ==> 세션 값 출력
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL테스트</title>
</head>
<body>
	<div align="center">
		<b>${name }</b><br/>
		${requestScope.name }<br/>
		<%=request.getAttribute("name") %>
		<br/>
		<b>${sessionScope.id }</b><br/>
		<%=session.getAttribute("id") %><br/>
	</div>
</body>
</html>