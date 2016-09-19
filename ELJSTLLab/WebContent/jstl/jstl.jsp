<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	#JSTL
		1. ����
		   JSTL�� �ڽŸ��� �±׸� �߰��� �� �ִ� ��� ����
		   <jsp:include>�� <jsp:useBean>�� ���� Ŀ���� �±�ó��
		      �����̳� ���ǹ��̳� �ݺ����� if��, for��, DB�� ���ϱ� ó���� �� �ִ� �±� ���̺귯��
		
		2. ����
			1) ����, ��� ���� �ڹ��ڵ带 ��ó
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			2) XML ���� ó��
				<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
			3) ����ǥ��ȭ ����(��¥, ȭ�� ��)
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			4) �����ͺ��̽� ���� sql ó��
				<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
			5) �Լ� 
				<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSTL</title>
</head>
<body>
	<div align="center">
		<h3>������</h3>
		<%
			for(int i=1;i<=9;i++){
		%>	
			<%=5+"*"+i+"="+5*i %><br/>
		<%	
			}
		%>
		<br/><br/>
		<h3>JSTL�� �̿��� ������</h3>
		<c:forEach var="i" begin="1" end="9" step="1">
			5*${i }=${5*i }<br/>
		</c:forEach>
		<br/><br/>
		
		<h3>forEach�� ���</h3>
		<%
			String[] names={"������", "������", "�̼���", "�̹��", "�̵�"};
			for(String n : names){
		%>
			<%=n %><br/>
		<% 		
			}
		%>
		<br/><br/>
		
		<h3>JSTL�� �̿��� forEach�� ���</h3>
		<c:set var="n" value="<%=names %>">
		<%--
			request.setAttribute("n", names)�� ����
		 --%>
		</c:set>
		
		<c:forEach var="name" items="${n }">
			${name }<br/>
		</c:forEach>
		<br/><br/>
		
		<h3>JSTL if�� ¦�� ���</h3>
		<c:forEach var="i" begin="1" end="10">
			<c:if test="${i%2==0 }">
				${i }<br/>
			</c:if>
		</c:forEach>

		
	</div>
</body>
</html>