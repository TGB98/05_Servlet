<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${todo.title} 상세 조회</title>
<link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>
	<h1>${todo.title}</h1> <%-- 할 일 제목 --%>

	<div class="content">${todo.detail}</div> <%-- 상세 내용 --%>
	
	<div class="btn-container">
		<div>
			<button id="goToList">목록으로</button>
		</div>
	</div>
	
	<%-- session에 message가 있다면 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>
		
		<c:remove var="message" scope="session" />
	</c:if>
	
<script src="/resources/js/detail.js"></script>
</body>
</html>