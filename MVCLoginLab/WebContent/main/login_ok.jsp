<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${result=='noid' }">
	<script type="text/javascript">
		alert('��ϵ� ������ �����ϴ�.');
		history.back();
	</script>
</c:if>
<c:if test="${result=='nopwd' }">
	<script type="text/javascript">
		alert('�н����尡 �߸� �Ǿ����ϴ�.');
		history.back();
	</script>
</c:if>
<c:if test="${result=='ok' }">
	<c:redirect url="list.do"/>
</c:if>
