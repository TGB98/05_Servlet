<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록 조회</title>

<link rel="stylesheet" href="/resources/CSS/book.css">
</head>
<body>
<h1>책 목록 조회</h1>
<hr>
<h3>전체 책 수량 : ${fn:length(bookList)}권</h3>
<hr>

<table border="1">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격(원)</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="book" items="${bookList}" varStatus="vs">

            <tr>
                <th>${vs.count}</th>
                <td>${book.title}</td>
                <td>${book.writer}</td>
                <td>${book.price}</td>
            </tr>

			<%-- 3배수 번째 반복 시 --%>
			<c:if test="${vs.count % 3 == 0}">
				<tr>
					<td class="blank" colspan="4">&nbsp;</td>
				</tr>
			
			</c:if>

        </c:forEach> 

    </tbody>

</table>

<button type="button" id="btn">js 테스트</button>



<script src="/resources/JS/book.js"></script>
<%-- webapp 폴더를 기준으로 js 파일 경로 작성. --%>
</body>
</html>