<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	#EL ����
		1. ǥ����
			1) "$"�� "{}"�� ����Ͽ� ���� ǥ����
			2) {}�ȿ��� ������ ǥ���Ǵ� �͸� �;� ��
		
		2. �⺻ ��ü
			1) jsp/servlet�� ��ü�� �Ӽ� ���̳� �Ķ���� �� ���� ���� ǥ���ϱ� ���ؼ� �⺻ ��ü�� ������
				- requestScope : request ���� ����
				- sessionScope : session ���� ����
				- applicationScope : application ���� ����
				- param : ��û �Ķ������ ���� ����, request.getParameter�� ������ ���
				
		3. ����
			1) <%= %>, out.println() �̷� �ڵ带 ���̻� ������� �ʰ� �� �� �����ϰ� ����� �����ϱ� ���� ����
			2) �迭�̳� �÷��ǿ��� ���ǰ�,	JavaBean�� ������Ƽ������ ���
			
		4. ������
			��ȣ ������ 				�ܾ� ������
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
<title>EL �׽�Ʈ</title>
</head>
<body>
	<div align="center">
		<%--������� --%>
		\${10+1 }=${10+1 }<br/>
		<!--\${"10"+1 }=${"10"+1 }<br/> ������ �ּ� ó�� -->
		<!--\${null+5 }=${null+5 }<br/> ������ �ּ� ó�� -->
		\${5/2 }=${5/2 }<br/>
		<!-- \${5 div 2 }=${5 div 2 }<br/> ������ �ּ� ó�� -->
		\${5%2}=${5%2}<br/>
		\${5 mod 2 }=${5 mod 2 }<br/>
		<br/>
		<%--���迬��(�񱳿���) ==> true/false --%>
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
		<%--������ --%>
		\${5!=6 && 5>6 }=${5!=6 && 5>6 }<br/>
		\${5!=6 and 5>6 }=${5!=6 && 5>6 }<br/>
	</div>
</body>
</html>