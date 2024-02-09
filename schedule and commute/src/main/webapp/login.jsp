<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTL Core태그를 사용 -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<div align="center">
<h2>Login</h2>
<form action="login.do" method="post">
ID : <input type="text" id="id" name="id" required="required"/><br/>
PASSWORD : <input type="password" id="pw" name="pw" required="required"/>
<input type="submit" value="login">
</form>
<c:choose>
<c:when test="${param.R != null }">
ID or PW
</c:when>
</c:choose>
</div>
</body>
</html>