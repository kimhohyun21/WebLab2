<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>글쓰기</title>
	<link rel="stylesheet" type="text/css" href="board/table.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#sendBtn').click(function(){
				var name=$('#name').val();
				if(name.trim()==""){
					$('#name').focus();
					alert("이름을 입력해주세요.");
					$('#name').val("");
					return;
				}
				var subject=$('#subject').val();
				if(subject.trim()==""){
					$('#subject').focus();
					alert("제목을 입력해주세요.");
					$('#subject').val("");
					return;
				}
				var content=$('#content').val();
				if(content.trim()==""){
					$('#content').focus();
					alert("내용을 입력해주세요.");
					$('#content').val("");
					return;
				}
				var pwd=$('#pwd').val();
				if(pwd.trim()==""){
					$('#pwd').focus();
					alert("비밀번호를 입력해주세요.");
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
		<h3>글쓰기</h3>
		<form action="insert_ok.do" method="post" name="frm" id="frm">
			<table id="insert_table">
				<tr>
					<th width="20%">이름</th>
					<td>
						<input type="text" size="15" name="name" id="name">
					</td>
				</tr>
				<tr>
					<th width="20">제목</th>
					<td>
						<input type="text" size="50" name="subject" id="subject">
					</td>
				</tr>
				<tr>
					<th width="20">내용</th>
					<td>
						<textArea cols="52" rows="10" name="content" id="content"></textArea>
					</td>
				</tr>
				<tr>
					<th width="20">비밀번호</th>
					<td>
						<input type="text" size="15" name="pwd" id="pwd">
					</td>
				</tr>							
			</table>
			<table id="button_table">
				<tr>
					<td>
						<input type="button" value="글쓰기" id="sendBtn">
						<input type="reset" value="취소" onclick="javascript:history.back()">
					</td>
				</tr>	
			</table>
		</form>
	</div>
</body>
</html>