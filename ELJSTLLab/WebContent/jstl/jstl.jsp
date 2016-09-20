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
				- �Ϲ� ���α׷��ֿ��� �����ϴ� �Ͱ� ������ ���� ����
				- ���� �帧�� ���� ����� ����
				- ������ �̵� ��� ����
				- �ֿ� �±�
					= set, out, remove
					= if, otherwise, choose, when
					= import, redirect, url, param
				
			2) XML ���� ó��
				<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
				- XML ������ ó���� �� �ʿ��� ��� ����
				- �ֿ� �±�
					= out, parse, set
					= if, otherwise, when, choose
					= transform, param
			
			3) ����ǥ��ȭ ����(��¥, ȭ�� ��)
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				- formatting
				- ����, ��¥, �ð��� �������ϴ� ����� ����
				- ����ȭ, �ٱ��� ���� ����� ����	
				- �ֿ� �±�	
					= setLocale
					= requestEncoding
					= formatNumber, formateDate, timeZone
					
			4) �����ͺ��̽� ���� sql ó��
				<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
				- DB�� �����͸� �Է�/����/����/��ȸ�ϴ� ��� ����
				- �ֿ� �±�
					= setDataSource, query, update..
			
			5) �Լ� 
				<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
				- ���ڿ���  �����ϴ� ����� ���� �Լ� ����
				- �ֿ� �±�
					= length, split, trim
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
			<c:set> �±�
				- request.setAttribute("n", names)�� ����
				- ���� ���� �����ϰų�, ��ü�� ��� ���� ���� ������ �� ���
				- ��� ������ �Ӽ�
					= value �Ӽ� : ������ ���� ��
					= var �Ӽ� : ���� ����� ������ �̸�
					= target : ���� ����� ��ü�� �̸�
					= property : target ��ü�� ��� ���� �̸�
					= scope : ���� ����� ����(�⺻�� : page)
		 --%>
		</c:set>
		
		<c:forEach var="name" items="${n }">
			${name }<br/>
		</c:forEach>
		<%--
			<c:forEach> �±�
				- �ݺ����� ���õ� �±�, Java�� for���� ������
				- ���� �θ� ���Ǵ� �±� �� �ϳ�
				- ��� ������ �Ӽ�
					= var �Ӽ� : ���� �������� �ִ� ����
					= begin �Ӽ� : �ݺ� ���� ��ȣ (�⺻�� : 0)
					= end �Ӽ� : �ݺ� �� ��ȣ(�⺻�� : �ش� �÷����� ������ ��)
					= step �Ӽ� : �ݺ��� ������(�⺻�� : 1)
					= item �Ӽ� : �ݺ��� ���� �����͸� ���� �������� �÷���
					= varStatus : �ݺ� ���� ���� �ִ� ����			
		 --%>
		<br/><br/>
		
		<h3>JSTL if�� ¦�� ���</h3>
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
			
			==> �� ������ JSTL�� ǥ���� ���
		 --%>
		<c:choose>
			<c:when test="${a==1 }">red</c:when>
			<c:when test="${a==2 }">blue</c:when>
			<c:when test="${a==3 }">green</c:when>
			<c:otherwise>black</c:otherwise>
		</c:choose>
		<%--
			<c:choose>, <c:when>, <c:otherwise> �±�
				- �ڹ��� if ~ else if��, switch���� ����
				- ��밡���� �Ӽ�
					=test �Ӽ� : �˻��� ����, �ʼ� �Ӽ�
		 --%>
		 <br/><br/>
		 
		 <c:forTokens var="color" items="red, blue, green" delims=",">
		 	${color }
		 </c:forTokens>
		 <%--
		 	<c:forTokens> �±�
			 	- �⺻������ for���� ����
			 	- ���ڿ��� ��ū���� ������ ó���ϴ� ��� ����
			 	- Java�� StringTokenizer Ŭ������ ����
			 	- ��� ������ �Ӽ�
			 		= items �Ӽ� : �ݺ��� ���� �����͸� ���� �������� �÷���
			 		= delims �Ӽ� : �����ڷ� ����� ����, �ʼ� �Ӽ�
			 		= var �Ӽ� : ���� �������� �ִ� ����		 	
		  --%>
	</div>
</body>
</html>