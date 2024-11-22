
<!-- 사용자 데이터를 설정하고 다른 페이지로 넘겨주는 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% 
    request.setCharacterEncoding("utf-8");
    request.setAttribute("id", "hong");
    request.setAttribute("pw", "1234");
    request.setAttribute("name", "홍길동");
    request.setAttribute("email", "hong@naver.com");
    request.setAttribute("address", "경기도 기흥구");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward4</title>
</head>
<body>
<!-- forward 태그를 사용해서 'member4.jsp'로 요청을 전달 -->
<jsp:forward page="member4.jsp"/>
</body>
</html>