<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>구구단 출력</title>
</head>
<body>
    <c:set var="dan" value="${param.dan}"/>
    <table border="1" width="800" align="center">
    <tr align="center" bgcolor="pink">
      <td colspan  = "2">
      <c:out value="${dan}" /> 단 출력  </td>
    </tr>
    
    <!-- c:forEach 태그를 이용해 구구단 출력 -->
    <c:forEach var="i" begin="1" end="9" step="1">
    
     <!-- c:forEach 태그의 반복 변수 i가 홀수인지 짝수인지 체크하여 행의 배경색 교대로 출력 -->
    <c:if test="${i % 2 == 0}">
  <tr align="center" bgcolor="#CCFF66">
</c:if>

<c:if test="${i % 2 == 1}">
  <tr align="center" bgcolor="#CCCCFF">
</c:if>


   <td width="400">
          <c:out value="${dan }" /> *
          <c:out value="${i}" />
    </td>
    <td width="400">
          <c:out value="${i*dan }" /> 
    </td>
   </tr>
   </c:forEach>
    </table>
</body>
</html>