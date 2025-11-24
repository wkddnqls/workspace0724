<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullCalendar JSP 예제</title>

<!-- ✅ FullCalendar CSS & JS CDN -->
<link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>

<style>
    body {
        font-family: "Noto Sans KR", sans-serif;
        margin: 40px auto;
        max-width: 900px;
        background: #f8f9fa;
    }
    #calendar {
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
</style>
</head>
<body>
    <h1 style="text-align:center;">📅 JSP + FullCalendar</h1>

    <div id="calendar"></div>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                locale: 'ko', // 한국어
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                events: [
                    { title: '회의', start: '2025-10-29' },
                    { title: '출근', start: '2025-10-30' },
                    { title: '야근 😭', start: '2025-10-31' }
                ],
                dateClick: function(info) {
                    alert(info.dateStr + ' 클릭!');
                }
            });

            calendar.render();
        });
    </script>
</body>
</html>
