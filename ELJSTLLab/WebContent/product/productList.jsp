<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="product" class="com.sist.el.Product" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL ��ǰ���</title>
</head>
<body>
	<div align="center">
		<form action="productSel.jsp" method="post">
			<h3>EL - ��ǰ���</h3>
			<hr/>
			<select name="sel">
		<%--
			for(String item : product.getProductList()){
				out.println("<option>"+item+"</option>");
			}
		--%>
			<c:forEach items="${product.productList }" var="item">
				<option>${item }</option>
			</c:forEach>				
			</select>
			<input type="submit" value="����">
		</form>
	</div>
</body>
</html>