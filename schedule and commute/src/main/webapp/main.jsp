<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<div align="center">
<c:choose>
	<c:when test="${sessionScope.USER != null }">
		<h3>ログイン完了</h3>
		<h3>${sessionScope.USER }</h3>
		<a href="logout.do">Logout</a>
		<a href="schedule.do">schedule</a>
	</c:when>
	<c:otherwise>
	<a href="login.do">Login</a>
	<a href="schedule.do">schedule</a>
	</c:otherwise>
</c:choose>

<h3>welcome to xxx company</h3>

</div>

</body>
</html>
