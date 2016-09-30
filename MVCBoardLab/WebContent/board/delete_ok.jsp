<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${bCheck==false }">
	<script type="text/javascript">
		alert('패스워드가 잘 못되었습니다.');
		history.back();	
	</script>	
</c:if>
<c:if test="${bCheck==true }">
	<script type="text/javascript">
		alert('삭제 되었습니다.');
		location.href="list.do?page="+${page };	
	</script>	
</c:if>
