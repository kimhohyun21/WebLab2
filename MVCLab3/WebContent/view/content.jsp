<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Content</title>
	<style type="text/css">
		table, th, td{
			border: 1px solid white;
			width: 200px;
			border-collapse: collapse;
			text-align: center;
		}
		th{
			background-color: #eeefff;
		}
	</style>
</head>
<body>
	<div align="center">
		<h3>�󼼺���</h3>
		<table>
			<tr>
				<th>�̸�</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<th>����</th>
				<td>${dto.gender }</td>
			</tr>
			<tr>
				<th>�ּ�</th>
				<td>${dto.addr }</td>
			</tr>
		</table>
	</div>
</body>
</html>