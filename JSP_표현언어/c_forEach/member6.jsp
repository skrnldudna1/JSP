<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %> <!-- import="java.util.* 추가 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    List dataList = new ArrayList();
    dataList.add("Hello");
    dataList.add("World");
    dataList.add("안녕하세요!");
%>

    
<c:set var="List" value="<%= dataList %>" />

<!-- c:choose 태그를 이용한 실습 / -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문 실습</title>
</head>
<body>
    <c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
    i = ${i} &nbsp;&nbsp;&nbsp; 반복 횟수 : ${loop.count} <br>
    </c:forEach>
    
     <c:forEach var="i" begin="1" end="10" step="2">
    i = ${i} = ${5*i}<br> 
    </c:forEach>
    
     <c:forEach var="data" items="${list}">
     ${data} <br>
    </c:forEach>
    
    <br>
     <c:set var="fruits" value="사과,파인애플,바나나,망고,귤" />
<c:forTokens var="token" items="${fruits}" delims=",">
    ${token} <br>
</c:forTokens>
    
 

</body>
</html>


