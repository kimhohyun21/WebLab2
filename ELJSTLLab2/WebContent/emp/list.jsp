<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	List<EmpDTO> list=EmpDAO.empAllData();
%>

<c:set var="list" value="<%=list %>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원 리스트</title>
</head>
<body>
	<div align="center">
		<h3>사원 목록</h3>
		<table>
			<tr>
				<td>
					<ul>
						<c:forEach var="dto" items="${list }"> 
							<li>${dto.empno }-${dto.ename }-${dto.job }</li>
						</c:forEach>
					</ul>
				</td>
			</tr>			
		</table>
	</div>
</body>
</html>