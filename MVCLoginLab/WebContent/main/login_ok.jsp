<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${result=='noid' }">
	<script type="text/javascript">
		alert('등록된 계정이 없습니다.');
		history.back();
	</script>
</c:if>
<c:if test="${result=='nopwd' }">
	<script type="text/javascript">
		alert('패스워드가 잘못 되었습니다.');
		history.back();
	</script>
</c:if>
<c:if test="${result=='ok' }">
	<c:redirect url="list.do"/>
</c:if>
