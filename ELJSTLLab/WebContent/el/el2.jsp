<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL 테스트</title>
</head>
<body>
	<div align="center">
		<%--산술연산 --%>
		\${10+1 }=${10+1 }<br/>
		\${"10"+1 }=${"10"+1 }<br/>
		\${null+5 }=${null+5 }<br/>
		\${5/2 }=${5/2 }<br/>
		\${5 div 2 }=${5 div 2 }<br/>
		\${5%2}=${5%2}<br/>
		\${5 mod 2 }=${5 mod 2 }<br/>
		<br/>
		<%--관계연산(비교연산) ==> true/false --%>
		\${5==2 }=${5==2 }<br/>
		\${5 eq 2 }=${5 eq 2 }<br/>
		\${5!=2 }=${5!=2 }<br/>
		\${5 ne 2 }=${5 ne 2 }<br/>
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