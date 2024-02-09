<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>schcedule</title>
</head>
<body>
<div align="center">


<c:set value="${weeks }" var="weeks"/>
<!-- JSTL Core를 사용하여 파라미터에서 weeks를 받아와 변수로 지정 -->
<a href="schedule.do?weeks=${ weeks - 7}">&lt;&lt;</a>
<!-- weeks 에서 7 을 뺀 값을 기준으로 스케쥴을 불러냄 -->
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="schedule.do?weeks=${ weeks + 7}">&gt;&gt;</a><br/>
<!-- weeks 에서 7 을 더한 값을 기준으로 스케쥴을 불러냄 -->

<c:forEach items="${schedule }" var="schedule" >
<!--schedule이 존재하는 동안 반복  -->
----------------------------------<br/>
schedule id:${schedule.schedule_id }<br/>
ID : ${schedule.id }<br/>
schedule name : ${schedule.schedule_name }<br/>
schedule date : ${schedule.schedule_date}<br/>
schedule start : ${schedule.schedule_start}<br/>
schedule end : ${schedule.schedule_end}<br/>
<a href="scheduleModify.do?schedule_id=${schedule.schedule_id}">modify schedule</a>
<!-- 스케쥴을 변경하는 서블릿으로 이동 -->
<a href="scheduleDelete.do?schedule_id=${schedule.schedule_id}">delete schedule</a>
<!-- 스케쥴을 삭제하는 서블릿으로 이동 -->
<br/>
----------------------------------<br/>
</c:forEach>


<a href="scheduleInput.do">new schedule</a>
<!-- 스케쥴을 입력하는 서블릿으로 이동  -->

</div>
</body>
</html>