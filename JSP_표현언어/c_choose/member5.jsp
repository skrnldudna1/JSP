<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<c:set var="id" value="Woo" scope="page" />
<c:set var="pwd" value="1234" scope="page" />

<!-- 이름을 입력 하지 않을 경우 !! -->
<c:set var="name" value="" scope="page" />
<c:set var="age" value="${22}" scope="page" />
<c:set var="height" value="${177}" scope="page" />
    
<!-- c:choose 태그를 이용한 실습 / -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조건문 실습</title>
</head>
<body>
  <table border ="1"  align = "center">
   <tr align = "center"  bgcolor= "#FFB6C1">
     <td width = "7%"><b>아이디</b></td>
     <td width = "7%"><b>비밀번호</b></td>
     <td width = "7%"><b>이름</b></td>
     <td width = "7%"><b>나이</b></td>
     <td width = "7%"><b>키</b></td>
  </tr>
  <c:choose>
      <%-- <c:when test="${name == ''}"> --%>
      <c:when test='${empty name}'>  empty
      <tr align = "center">
          <td colspan=5>이름을 입력하세요.</td> </tr>
          </c:when>
          <c:otherwise>
           <tr align = "center">
               <td>${id} </td>
               <td>${pwd} </td>
               <td>${name} </td>
               <td>${age} </td>
               <td>${height} </td>
           </tr>
          </c:otherwise>
      </c:choose>
  
 </table>

</body>
</html>