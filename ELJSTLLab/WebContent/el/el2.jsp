<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	#EL 정리
		1. 표현식
			1) "$"와 "{}"를 사용하여 값을 표현함
			2) {}안에는 값으로 표현되는 것만 와야 함
		
		2. 기본 객체
			1) jsp/servlet의 객체의 속성 값이나 파라미터 값 등을 쉽게 표현하기 위해서 기본 객체를 제공함
				- requestScope : request 영역 참조
				- sessionScope : session 영역 참조
				- applicationScope : application 영역 참조
				- param : 요청 파라미터의 값을 참조, request.getParameter와 동일한 기능
				
		3. 목적
			1) <%= %>, out.println() 이런 코드를 더이상 사용하지 않고 좀 더 간편하게 출력을 지원하기 위한 도구
			2) 배열이나 컬렉션에서 사용되고,	JavaBean의 프로퍼티에서도 사용
			
		4. 연산자
			기호 연산자 				단어 연산자
				/					div
				%					mod
				&&					and
				||					or
				!					not
				>					lt(less than)
				<					gt(greater than)
				>=					le(less or equal)
				<=					ge(greater or equal)
				==					eq(equal)
				!=					ne(not equal)
			
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL 테스트</title>
</head>
<body>
	<div align="center">
		<%--산술연산 --%>
		\${10+1 }=${10+1 }<br/>
		<!--\${"10"+1 }=${"10"+1 }<br/> 에러로 주석 처리 -->
		<!--\${null+5 }=${null+5 }<br/> 에러로 주석 처리 -->
		\${5/2 }=${5/2 }<br/>
		<!-- \${5 div 2 }=${5 div 2 }<br/> 에러로 주석 처리 -->
		\${5%2}=${5%2}<br/>
		\${5 mod 2 }=${5 mod 2 }<br/>
		<br/>
		<%--관계연산(비교연산) ==> true/false --%>
		\${5==2 }=${5==2 }<br/>
		\${5 eq 2 }=${5 eq 2 }<br/>
		\${5!=2 }=${5!=2 }<br/>
		<!-- \${5 ne 2 }=${5 ne 2 }<br/> -->
		\${5<2 }=${5<2 }<br/>
		\${5 lt 2 }=${5 lt 2 }<br/>
		\${5>2 }=${5>2 }<br/>
		\${5 gt 2 }=${5 gt 2 }<br/>
		\${5<=2 }=${5<=2 }<br/>
		\${5 le 2 }=${5 le 2 }<br/>
		<br/>
		<%--논리연산 --%>
		\${5!=6 && 5>6 }=${5!=6 && 5>6 }<br/>
		\${5!=6 and 5>6 }=${5!=6 && 5>6 }<br/>
	</div>
</body>
</html>