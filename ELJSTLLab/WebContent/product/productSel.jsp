<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	#���� ��ü param 
		1. ���� : ������������ <FORM> �Էµ� �����͸� ������ �� ����ϴ� ���� ��ü
		2. �����(2����)
			1) param.�������̸� 
				- Ex) ${param.NUM}
			2) param.["�������̸�"]
				- Ex) ${param.["NUM"]}
			
 --%>
<jsp:useBean id="product" class="com.sist.el.Product"></jsp:useBean>
<%
	pageContext.setAttribute("num1", product.getNum1());
	pageContext.setAttribute("num2", product.getNum2());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL ��ǰ����</title>
</head>
<body>
	<div align="center">
		<h3>EL - ��ǰ����</h3>
		<hr/>
		1. ������ ��ǰ : ${param.sel }<br/>
		2. num1+num2 = ${num1+num2 }<br/>
		<input type="button" value="���ư���" onclick="javascript:history.back()">
	</div>
</body>
</html>