<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="main/style.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('.button').click(function(){
				var $id=$('#id').val();
				if($id.trim()==""){
					alert('아이디를 입력해주세요.');
					$('#id').focus();
					return;
				}
				var $pwd=$('#pwd').val();
				if($pwd.trim()==""){
					alert('패스워드를 입력해주세요.');
					$('#pwd').focus();
					return;
				}
				$('#frm').submit();
			});
		});
	</script>
</head>
<body>
	<div align="center">
		<div id="mainPan">
			<div id="leftPan">
				<form action="login_ok.do" method="post" id="frm">
					<h2>Members Login</h2>
					<label>ID</label>
					<input type="text" name="id" id="id"><br/>
					<label>PW</label>
					<input type="password" name="pwd" id="pwd">	
					<input type="button" value="Login" class="button">
				</form>			
			</div>		
		</div>
	</div>
</body>
</html>