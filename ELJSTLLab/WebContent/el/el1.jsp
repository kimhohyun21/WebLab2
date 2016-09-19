<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
	#EL(Expression Language): ǥ�����
		1. ���� ���
			1) �ñ� : JSTL(JSP Standard Tag Library)�� ������ ��, EL�� �Ұ���
			2) ���� : MVC ���Ͽ� ���� ��(view)������ �����ϴ� JSP�� ���� ȿ�������� ������� �������� ���ߵ�
			3) �Ѹ� : SPEL(Simplest Possible EL)���� �Ļ� ��ȵ� �����
		
		2. ����
			1) ���� : ${��¹�(���굵 ����)}
				- Ex) ���� : request.getParameter("id");
						==> ${param.id}
					    ���� : request.getAttribute("id");	
					    ==> ${requestScope.id}
					    ==> ${id}
					    ���� : session.getAttribute("id");
					    ==> ${sessionScop.id   
					    
			2) EL���� ��밡���� ���尴ü 
				- EL������ ��ü�� �����Ǿ� ���� �ȴٴ� ���� �����ϰ� ����
				- ���������� ��ü�� ������ �ʿ䰡 ����
			
			3) EL���� ��밡���� ������
				- ��������� : + / - * %
					${10+10} ==> 20
					${"10"+1} ==> Integer.parseInt("10")+1 ==> 11
						: EL���� ��������ڴ� ���ڿ� ���� ���� X, ������길 ����
					${null+1} ==> null�� 0���� ��ȯ ==> 1
					${5/2} ==> 2.5 EL������ �Ǽ� ��
					${5%2} ==> 1
					
				- �� / ���� ������ ==> true/false
					== Ȥ�� eq
					!= Ȥ�� en
					 < Ȥ�� lt
					 > Ȥ�� gt
					<= Ȥ�� le
					>= Ȥ�� ge
					a ? b : c
				
				- �� ������ ==> true/false
					&& Ȥ�� and
					|| Ȥ�� or
					!  Ȥ�� not
					
				- empty
 --%>
 <%
 	String name="������";
 	//request�� ����
 	request.setAttribute("name", name);
 	//session�� ����
 	session.setAttribute("id", "admin");
 	//${sessionScope.id} ==> ���� �� ���
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL�׽�Ʈ</title>
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