<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
schedule
<c:if test="${ ! empty schedule }">
schedule id:${schedule.schedule_id };<br/>
ID:${schedule.id }<br/>
schedule name:${schedule.schedule_name };<br/>
schedule date:${schedule.schedule_date};<br/>
schedule start${schedule.schedule_start};<br/>
schedule end:${schedule.schedule_end};<br/>
</c:if>

<form action="scheduleInput.do" method="post"><!-- 스케쥴 입력 폼 post방식으로 -->
Schedule名<input type="text" id="schedule_name" name="schedule_name"  required="required"/>
Schedule日付<input type="date" id="schedule_date" name="schedule_date"  required="required"/>
Schedule開始時間<input type="time" id="schedule_start" name="schedule_start" required="required"/>
Schedule終了時間<input type="time" id="schedule_end" name="schedule_end"  required="required"/>
<br/>
<input type="submit"/>
</form>

<a href="scheduleInput.do">new schedule</a>
</div>
</body>
</html>