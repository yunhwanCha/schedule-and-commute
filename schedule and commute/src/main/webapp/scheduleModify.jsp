<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>schedule modify</title>
</head>
<body>
<div align="center">
<form action="scheduleModify.do" method="post">
Schedule名<input type="text" value="${schedule.schedule_name }" id="schedule_name" name="schedule_name"  required="required"/>
Schedule日付<input type="date" value="${schedule.schedule_date }" id="schedule_date" name="schedule_date"  required="required"/>
Schedule開始時間<input type="time" value="${schedule.schedule_start }" id="schedule_start" name="schedule_start" required="required"/>
Schedule終了時間<input type="time" value="${schedule.schedule_end }" id="schedule_end" name="schedule_end"  required="required"/>
<input type="hidden" value="${schedule.schedule_id }" id="schedule_id" name="schedule_id">
<br/>
<input type="submit" value="修正"/>
<input type="button" value="削除" onclick="location.href='scheduleDelete.do?schedule_id=${schedule.schedule_id}'"/>
</form>
</div>
</body> 
</html>