<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <style>
    	
        .container mt-5 {
            font-family: Arial, sans-serif;
            margin-top: 100px;
            max-width: 100vw;
        }
        #calendar {
        	padding: 80px 20px 0px 20px;
            margin: 0 auto;
            color: black;
            
        }
        .fc .fc-scrollgrid-liquid {
        	max-height: 80vh;
        }
        
    </style>
    <div class="container mt-5">
        <h1 class="mb-4 text-center">FullCalendar Sample</h1>
        <div id="calendar"></div>
    </div>

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.13/index.global.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.13/locales-all.min.js"></script>
    
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                // 캘린더 헤더 설정
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
                },
                // 초기 날짜 (선택 사항)
                // initialDate: '2025-07-29',
                // 초기 뷰
                initialView: 'dayGridMonth',
                // 날짜 클릭 또는 드래그로 일정 선택 가능 여부
                selectable: true,
                // 일정 드래그 및 크기 조절 가능 여부
                editable: true,
                // 이벤트가 없을 때 표시할 메시지
                noEventsText: '표시할 일정이 없습니다.',
                // 시간 형식 (예: 오전/오후 10:30)
                eventTimeFormat: {
                    hour: 'numeric',
                    minute: '2-digit',
                    meridiem: 'short'
                },
                // 언어 설정 (한국어)
                locale: 'ko',

                // 캘린더에 표시할 이벤트 데이터 (배열 또는 URL)
                events: [
                    {
                        id: '1',
                        title: '팀 회의',
                        start: '2025-07-29T10:00:00',
                        end: '2025-07-29T11:00:00',
                        color: '#28a745' // Bootstrap 'success' color
                    },
                    {
                        id: '2',
                        title: '점심 식사',
                        start: '2025-07-29T12:00:00',
                        end: '2025-07-29T13:00:00',
                        color: '#ffc107' // Bootstrap 'warning' color
                    },
                    {
                        id: '3',
                        title: '프리젠테이션 준비',
                        start: '2025-07-30T09:00:00',
                        end: '2025-07-30T17:00:00',
                        allDay: true, // 하루 종일 일정
                        color: '#007bff' // Bootstrap 'primary' color
                    },
                    {
                        id: '4',
                        title: '고객 미팅',
                        start: '2025-08-01T14:00:00',
                        color: '#dc3545' // Bootstrap 'danger' color
                    }
                ],

                // 날짜/시간 선택 시 (빈 공간 클릭/드래그) 이벤트
                select: function(info) {
                    let title = prompt('새로운 일정 이름을 입력하세요:');
                    if (title) {
                        calendar.addEvent({
                            title: title,
                            start: info.startStr,
                            end: info.endStr,
                            allDay: info.allDay,
                            color: '#6f42c1' // 새로운 일정 색상 (Bootstrap 'purple')
                        });
                    }
                    calendar.unselect(); // 선택 영역 해제
                },

                // 기존 이벤트 클릭 시 이벤트
                eventClick: function(info) {
                    if (confirm("'" + info.event.title + "' 일정을 삭제하시겠습니까?")) {
                        info.event.remove(); // 캘린더에서 일정 제거
                        // TODO: 서버에 삭제 요청 보내는 AJAX 코드 추가
                        console.log('삭제될 일정 ID:', info.event.id);
                    }
                },

                // 이벤트 드래그 완료 시 (이동 시) 이벤트
                eventDrop: function(info) {
                    // TODO: 서버에 변경된 일정 정보 (시작/종료 날짜 등) 보내는 AJAX 코드 추가
                    console.log('일정 이동됨:', info.event.title, info.event.startStr, info.event.endStr);
                },

                // 이벤트 크기 조절 완료 시 (resize 시) 이벤트
                eventResize: function(info) {
                    // TODO: 서버에 변경된 일정 정보 (시작/종료 날짜 등) 보내는 AJAX 코드 추가
                    console.log('일정 크기 조절됨:', info.event.title, info.event.startStr, info.event.endStr);
                }
            });

            calendar.render(); // 캘린더 렌더링
        });
    </script>