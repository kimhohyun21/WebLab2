<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�۾���</title>
	<link rel="stylesheet" type="text/css" href="board/table.css">
	<script type="text/javascript">
		function enter(){
			if(event.keyCode==13){
				send();	
			}
		};
	
		function send(){			
			//�������� : window ==> document ==> form ==> input
			var f=document.frm;
			if(f.name.value==""){
				alert('�̸��� �Է����ּ���.');
				f.name.focus();
				return;
			}
			if(f.subject.value==""){
				alert('������ �Է����ּ���.');
				f.subject.focus();
				return;
			}
			if(f.content.value==""){
				alert('������ �Է����ּ���.');
				f.content.focus();
				return;
			}
			if(f.pwd.value==""){
				alert('��й�ȣ�� �Է����ּ���.');
				f.pwd.focus();
				return;
			}
			f.submit();
		}; 
	</script>
</head>
<body>
	<h3 id="title">�۾���</h3>
	<div align="center">
		<form action="insert_ok.do" method="post" name="frm">
			<table id="insert_table">
				<tr>
					<th width="20%">�̸�</th>
					<td>
						<input type="text" size="15" name="name" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">�̸���</th>
					<td>
						<input type="text" size="50px" name="email" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">����</th>
					<td>
						<input type="text" size="50" name="subject" onkeydown="enter()">
					</td>
				</tr>
				<tr>
					<th width="20%">����</th>
					<td>
						<textArea cols="52" rows="10" name="content"></textArea>
					</td>
				</tr>
				<tr>
					<th width="20%">��й�ȣ</th>
					<td>
						<input type="password" size="15px" name="pwd" onkeydown="enter()">
					</td>
				</tr>
			</table>
			<table class="button_table">
				<tr>
					<td align="center">
						<input type="button" value="�۾���" onclick="send()">
						<input type="reset" value="���" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>	
		</form>
	</div>
</body>
</html>