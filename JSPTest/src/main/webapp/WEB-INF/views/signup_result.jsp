<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예제(EL / JSTL)</title>
</head>
<body>
	<h1>회원 가입 결과 페이지입니다</h1>

	<h3>입력되어 전달된 값들</h3>

	<ul>
	<li>ID : ${param.inputId}</li>
	<li>PW : ${param.inputPw}</li>
	<li>확인 : ${param.inputPwCheck}</li>
	<li>이름 : ${param.inputName}</li>
	<li>나이 : ${param.inputAge}</li>
	</ul>

	<h1 style = "color : red;">
		<c:if test="${param.inputPw != param.inputPwCheck }">비밀번호 불일치</c:if>
	</h1>
	
	<h1 style = "color : blue;">
		<c:if test="${param.inputPw == param.inputPwCheck}">비밀번호 일치</c:if>
	</h1>
	
</body>
</html>