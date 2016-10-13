<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>영화 상세</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div align="center">
		<div id="header">
			<h3>영화 상세</h3>
		</div>
		<div id="article">
			<table class="container">
				<tr>
					<td colspan="2" align="right">
						<a href="main.do">무비 차트</a>
					</td>
				</tr>
				<tr>
					<td class="poster" rowspan="5" width="30%">
						<img src="${vo.poster }">
					</td>
					<td class="title">
						${vo.title }
					</td>
				</tr>
				<tr>
					<td class="regdate">
						개봉 : ${vo.regdate }
					</td>
				</tr>
				<tr>
					<td class="grade">
						등급 : ${vo.grade }
					</td>
				</tr>
				<tr>
					<td class="reserve">
						예매율 : ${vo.reserve }
					</td>
				</tr>
				<tr>
					<td class="like">
						좋아요 : ${vo.regdate }
					</td>
				</tr>
			</table>
		</div>
		<div id="footer">
			&copy;sist Cinema
		</div>
	</div>
</body>
</html>