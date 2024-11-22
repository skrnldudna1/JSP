<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
    
    <% request.setCharacterEncoding("utf-8"); %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 창</title>
</head>
<body>
  <form action = "result2.jsp" method="post">
  아이디 : <input type="text"  name="userID"> <br>
  비밀번호 : <input type="password"  name="userPw"> <br>
  <input type="submit" value="로그인">
  </form>
</body>
</html>