<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="product" class="com.sist.el.Product" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL 상품목록</title>
</head>
<body>
	<div align="center">
		<form action="productSel.jsp" method="post">
			<h3>EL - 상품목록</h3>
			<hr/>
			<select name="sel">
		<%
			for(String item : product.getProductList()){
				out.println("<option>"+item+"</option>");
			}
		%>
			</select>
			<input type="submit" value="선택">
		</form>
	</div>
</body>
</html>