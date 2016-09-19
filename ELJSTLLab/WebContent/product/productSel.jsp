<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	#내장 객체 param 
		1. 정의 : 웹브라우저에서 <FORM> 입력된 데이터를 가져올 때 사용하는 내장 객체
		2. 사용방법(2가지)
			1) param.데이터이름 
				- Ex) ${param.NUM}
			2) param.["데이터이름"]
				- Ex) ${param["NUM"]}
			
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL 상품선택</title>
</head>
<body>
	<div align="center">
		<h3>EL - 상품선택</h3>
		<hr/>
		1. 선택한 상품 : ${param.sel }<br/>
		2. num1+num2 = ${product.num1+product.num2 }<br/> <!-- useBean의 scope을 session으로 설정하여 그대로 사용가능 -->
		<input type="button" value="돌아가기" onclick="javascript:history.back()">
	</div>
</body>
</html>