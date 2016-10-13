<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>영화 예매</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div align="center">
		<div id="header">
			<h3>CGV 무비 차트 </h3>
		</div>
		<div id="article">
			<table class="container">
				<tr valign="top">
				<c:forEach var="vo" items="${list }">
					<td width="50px" onclick="location.href='movie_detail.do?no=${vo.rank }'">
						<table>
							<tr height="10%">
								<td class="rank" align="center" colspan="2">
									No.${vo.rank }
								</td>
							</tr>
							<tr height="40%">
								<td class="poster" colspan="2">
									<img src="${vo.poster }">
								</td>
							</tr>
							<tr height="20%">	
								<td class="title" colspan="2">
									<a href="movie_detail.do?no=${vo.rank }">
										${vo.title }
									</a>	
								</td>
							</tr>
							<tr height="10%">	
								<td class="regdate">
									${vo.regdate }
								</td>
								<td class="grade">
									${vo.grade }
								</td>
							</tr>
							<tr height="10%">	
								<td class="reserve">
									예매율 ${vo.reserve }%
								</td>
								<td class="like">
									좋아요 ${vo.like }
								</td>
							</tr>
						</table>
					</td>
				</c:forEach>	
				</tr>
			</table>
		</div>
		<div id="footer">
			&copy;sist Cinema
		</div>
	</div>
</body>
</html>