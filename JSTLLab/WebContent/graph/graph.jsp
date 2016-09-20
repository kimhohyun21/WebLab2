<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, com.sist.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="com.sist.dao.EmpDAO"></jsp:useBean>
<%
	String strNo=request.getParameter("fs");
	if(strNo==null){strNo="1";}
	int no=Integer.parseInt(strNo);
	
	List<EmpVO> list=dao.empAllData();
	String json="";
	
	switch(no){
	case 1:
		json=dao.empChart();
		break;
	case 2:
		json=dao.empChart1();
		break;
	case 3:
		json=dao.empChart2();
		break;
	case 4:
		json=dao.empChart3();
		break;
	}
	
	
%>
<c:set var="list" value="<%=list %>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>��� �׷��� �׸���</title>
	<link rel="stylesheet" type="text/css" href="table.css">
	<script type="text/javascript" src="https://www.amcharts.com/lib/3/amcharts.js"></script>
	<script type="text/javascript" src="https://www.amcharts.com/lib/3/pie.js"></script>
	<script type="text/javascript" src="https://www.amcharts.com/lib/3/themes/light.js"></script>
	<script type="text/javascript">
	var chart = AmCharts.makeChart("chartdiv", {
		  "type": "pie",
		  "theme": "light",
		  "valueField": "sal",
		  "titleField": "ename",
		  "dataProvider": <%=json %>,
		  "balloon": {
			  "fixedPosition": true
		  },
		  "export": {
			  "enable": true
		  }
		});	
	function change(){
		document.frm.submit();
	}
	</script>
</head>
<body>
	<div align="center">
		<h3>������</h3>
		<table border="0" width="1000">
			<tr>
				<td width="40%">
					<table id="select_table" align="left">
						<tr>
							<td>
								<form action="graph.jsp" method="post" name="frm">
								�˻�: <select onchange="change()" name="fs">
										<option selected>����</option>
										<option value="1">�����</option>
										<option value="2">������</option>
										<option value="3">�μ���</option>
										<option value="4">�Ի��Ϻ�</option>
									 </select>
								</form>
							</td>
						</tr>
					</table>
					<table id="content_table">
						<tr>
							<th>���</th>
							<th>�̸�</th>
							<th>����</th>
							<th>�Ի���</th>
							<th>�޿�</th>
							<th>�μ���ȣ</th>
						</tr>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td>${vo.empno }</td>
							<td>${vo.ename }</td>
							<td>${vo.job }</td>
							<td>${vo.hiredate }</td>
							<td>${vo.sal }</td>
							<td>${vo.deptno }</td>
						</tr>
					</c:forEach>
					</table>
				</td>
				<td>
					<div id="chartdiv"></div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>