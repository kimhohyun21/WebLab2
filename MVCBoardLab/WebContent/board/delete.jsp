<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�����ϱ�</title>
	<link rel="stylesheet" type="text/css" href="board/table.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div align="center">
		<h3>�����ϱ�</h3>
		<form action="delete_ok.do" method="post" name="frm">
			<table id="content_table" >
				<tr>
					<th width="20%">��й�ȣ</th>
				</tr>
				<tr>
					<td>
						<input type="password" size="15" name="pwd">
						<input type="hidden" name="page" value="${page }">
						<input type="hidden" name="no" value="${no }">
					</td>
				</tr>
			</table>
			<table class="button_table">
				<tr>
					<td align="center">
						<input type="submit" value="����">
						<input type="reset" value="���" onclick="javascript:history.back();">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>