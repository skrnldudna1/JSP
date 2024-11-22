<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8" isELIgnored="false" %> <!-- isELIgnored="false 추가 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인창에서 입력값에 따른 화면 출력 c:if 태그 이용</title>
</head>
<body>

<!--empty 연산자를 이용해 ID 값이 비었는지 체크합니다. -->
  <c:if test="${empty param.userID }">
   아이디를 입력하세요. <br>
   </c:if>
<!--ID를 정상적으로 입력한 경우 로그인 메세지를 출력합니다. -->
   <c:if test="${not empty param.userID }">
   <h1>환영합니다 !<c:out value="${param.userID }"/> 님♡ </h1>
   </c:if>
</body>
</html>