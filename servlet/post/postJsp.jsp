<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Servlet</title>
</head>
<body>
<h1>Post Servlet 방식</h1>
 <form method="Post" action="PostServlet">
<table>
<tr>
 <td>id:</td><td><input name="id"> <br/></td>
 <tr/>
 <td>pwd:</td><td><input type="password" name="pwd"> <br/></td>
 <tr/>
 <td>email: </td><td><input name="email"> <br/><td>  
 </table>
 <input type="submit" value="가입">
 </form>

</body>
</html>