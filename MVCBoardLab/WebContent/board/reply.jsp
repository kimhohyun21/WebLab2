<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�亯 �ϱ�</title>
	<link rel="stylesheet" type="text/css" href="board/table.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#sendBtn').click(function(){
				var name=$('#name').val();
				if(name.trim()==""){
					$('#name').focus();
					alert('�̸��� �Է��ϼ���.');
					$('#name').val("");
					return;
				}
				var subject=$('#subject').val();
				if(subject.trim()==""){
					$('#subject').focus();
					alert('������ �Է��ϼ���.');
					$('#subject').val("");
					return;
				}
				var content=$('#content').val();
				if(content.trim()==""){
					$('#content').focus();
					alert('������ �Է��ϼ���.');
					$('#content').val("");
					return;
				}
				var pwd=$('#pwd').val();
				if(pwd.trim()==""){
					$('#pwd').focus();
					alert('��й�ȣ�� �Է��ϼ���.');
					$('#pwd').val("");
					return;
				}
				$('#frm').submit();
			});
		});
	</script>
</head>
<body>
	<div align="center">
		<h3>�亯 �ϱ�</h3>
		<form action="reply_ok.do?page=${page }&no=${no }" method="post" name="frm" id="frm">
			<table id="insert_table">
				<tr>
					<th width="20%">�̸�</th>
					<td>
						<input type="text" size="15" name="name" id="name">
					</td>
				</tr>
				<tr>
					<th width="20%">����</th>
					<td>
						<input type="text" size="50" name="subject" id="subject">
					</td>
				</tr>
				<tr>
					<th width="20%">����</th>
					<td>
						<textArea cols="52" rows="10" name="content" id="content"></textArea>
					</td>
				</tr>
				<tr>
					<th width="20%">��й�ȣ</th>
					<td>
						<input type="password" size="15" name="pwd" id="pwd">
					</td>
				</tr>
			</table>
			<table id="button_table">
				<tr>
					<td>
						<input type="button" value="�亯�ϱ�" id="sendBtn">
						<input type="reset" value="���" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>