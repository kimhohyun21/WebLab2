<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>사이트 제작 연습</title>
	<link rel="stylesheet" type="text/css" href="main/js/nivo-slider.css">
	<link rel="stylesheet" type="text/css" href="main/style.css">
	<script type="text/javascript" src="main/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="main/js/jquery.nivo.slider.pack.js"></script>
	<script type="text/javascript">
		$(window).load(function(){
			$('#slider').nivoSlider();
		});
	</script>
</head>
<body>
	<div id="container">
		<div id="inner">
			<div id="header">
				<h1><a href="main.do">SIST Restaurant</a></h1>
				<h2>sist 쌍용교육센터</h2>
				<div class="clear"></div>
			</div>
			
			<div id="nav">
				<ul>
					<li><a href="main.do">홈</a></li>
					<li><a href="board.do">자유게시판</a></li>
					<li><a href="reserve.do">예약</a></li>
					<li><a href="mypage.do">마이페이지</a></li>
				</ul>
			</div>
			<div id="article">
				<!-- include -->
				<jsp:include page="${jsp }"></jsp:include>
			</div>
			<div id="footer">
				<p>&copy;SIST<a href="http://www.sist.co.kr">쌍용교육센터</a></p>
			</div>
		</div>
	</div>
</body>
</html>






























