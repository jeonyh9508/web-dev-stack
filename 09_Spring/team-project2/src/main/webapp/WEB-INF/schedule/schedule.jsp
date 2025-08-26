<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="../../resource/css/layout.css">
<script src="../resource/js/index.global.js"></script>

<style>
  body {
    margin: 40px 10px;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    max-height: 82vh;
    margin: 0 auto;
  }
</style>

<title>Schedule Calendar</title>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../side.jsp"></jsp:include>

<div id='calendar'></div>

<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialView: 'dayGridMonth',
        navLinks: true,
        selectable: true,
        selectMirror: true,
        editable: true,
        dayMaxEvents: true,

        events: function(fetchInfo, successCallback, failureCallback) {
            $.ajax({
                url: '/schedule/event', // 서버에서 JSON 반환
                type: 'GET',
                dataType: 'json',
                success: function(data) {
                    var events = data.map(function(item){
                        return {
                            title: item.title,
                            start: item.start,
                            end: item.end,
                            color: item.color,
                            extendedProps: {
                                type: item.type,
                                projectId: item.projectId || null
                            }
                        };
                    });
                    successCallback(events);
                },
                error: function() {
                    alert("캘린더 데이터 불러오기 실패!");
                    failureCallback();
                }
            });
        },

        eventDidMount: function(info) {
            info.el.title = info.event.title;
        },

        eventClick: function(info) {
            var projectId = info.event.extendedProps.projectId;

            if(projectId) {
                window.location.href = '/project/detail?projectId=' + projectId;
            } else {
                alert("이 이벤트는 프로젝트와 연결되어 있지 않습니다.");
            }
        }
    });

    calendar.render();
});
</script>

</body>
</html>