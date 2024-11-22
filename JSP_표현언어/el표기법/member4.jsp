
<!-- forward4.jsp에서 전달된 사용자 정보를 시각적으로 출력 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.setAttribute("address", "수원시 팔달구");
 // 세션 객체에 "address" 속성을 설정
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border ="1"  align = "center">
   <tr align = "center"  bgcolor= "#FFB6C1">
     <td width = "7%"><b>아이디</b></td>
     <td width = "7%"><b>비밀번호</b></td>
     <td width = "5%"><b>이름</b></td>
     <td width = "5%"><b>이메일</b></td>
     <td width = "5%"><b>주소</b></td>
  </tr>
  <tr align = "center">
    <td>${id} </td>
    <td>${pw} </td>
    <td>${name} </td>
    <td>${email} </td>
    <td>${address} </td>
    </tr>
 </table>

</body>
</html>