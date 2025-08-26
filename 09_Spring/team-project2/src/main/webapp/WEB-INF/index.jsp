<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ERP</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.5.0/dist/chart.umd.min.js"></script>
    <link rel="stylesheet" href="../../resource/css/layout.css">
    <link rel="shortcut icon" href="../resource/favicon.ico">
    <style>
/*
        전체 페이지 레이아웃 (Flexbox)
        */
body {
	display: flex;
	height: 100vh;
	margin: 0;
	flex-direction: column; /* 기본 방향을 세로로 설정 */
	background-image: url(../resource/static/back1.jpg);
	background-size: cover;
	background-position: center;
	background-attachment: fixed;
	background-blend-mode: color;
	background-color: rgba(0, 0, 0, 0.6);
}

/*
        헤더 영역 (Flexbox)
        */
header {
	position: fixed; /* 헤더 고정 */
	top: 0;
	left: 0;
	width: 100%;
	height: 70px; /* 헤더 높이 고정 */
	z-index: 100;
}

/*
        사이드바 영역 (Flexbox)
        */
aside {
	position: fixed; /* 사이드바 고정 */
	top: 70px; /* 헤더 아래에 위치 */
	left: 0;
	width: 200px; /* 사이드바 너비 고정 */
	height: calc(100vh - 70px); /* 헤더를 제외한 높이 */
	z-index: 99;
}

/*
        메인 컨텐츠 영역 (Flexbox)
        */
.main-content {
	flex-grow: 1; /* 남은 공간을 모두 차지 */
	margin: 0px;
	padding: 20px;
	box-sizing: border-box;
	display: flex;
	flex-wrap: wrap; /* 자식 요소들을 다음 줄로 넘기기 */
	gap: 20px; /* 각 칸 사이의 간격 */
	background-image: url(../resource/static/back1.jpg);
	background-size: cover;
	background-position: center;
	background-attachment: fixed;
	background-blend-mode: color;
	background-color: rgba(0, 0, 0, 0.6);
}

/*
        4등분된 각 칸의 스타일 (Flexbox)
        */
.quadrant {
	width: calc(50% - 10px); /* (50% - gap/2)로 너비 계산 */
	height: calc(50% - 10px); /* (50% - gap/2)로 높이 계산 */
	border: 1px solid #ddd;
	border-radius: 8px;
	background-color: rgba(255, 255, 255, 0.65);
	padding: 20px;
	box-sizing: border-box;
	display: flex;
	flex-direction: column;
	justify-content: flex-start;
	align-items: flex-start;
	font-size: 1em;
	color: #555;
	text-align: left;
	overflow: auto;
}

/* 막대 그래프 컨테이너에 대한 추가 스타일 */
.chart-container {
	width: 90%;
	height: 90%;
	margin: 0 auto;
}

table {
	width: 700px;
	background-color: rgba(255, 255, 255, 0.1);
	border-collapse: collapse;
	margin: 20px 0;
	color: #333;
	table-layout: auto;
}

table th, table td {
	padding: 10px;
	border: 1px solid #ddd;
	font-size: 13px;
	text-align: center;
	max-width: 250px;
}

table td {
	font-size: 13px;
	text-align: left;
	vertical-align: top;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
  </head>
  <body>
    <header>
      <jsp:include page="header.jsp"></jsp:include>
    </header>
    <aside>
      <jsp:include page="side.jsp"></jsp:include>
    </aside>
    
    <main class="main-content">
      <div class="quadrant">
        <h3>공지사항</h3>
			<table id="notice">
				<thead>
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="board" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a href="/customer/view?boardNo=${board.boardNo}">${board.title}</a></td>
							<td>${board.content}</td>
							<td><fmt:formatDate value="${board.updatedAt}" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
      <div class="quadrant" style="align-items: center;">
        <h3 style="text-align: center;">프로젝트 현황</h3>
        <div class="chart-container">
            <canvas id="projectChart"></canvas>
        </div>
      </div>
      <div class="quadrant"><h3>/고객 클레임 리스트/</h3>
      - 프로젝트 멤버 연동하여 노출될 수 있게끔 (프로젝트에 할당된 로그 기준)
      </div>
      <div class="quadrant"><h3>/스케쥴표 삽입/</h3>
      - 로그인된 계정 기준 등록된 스케쥴 내용 노출 (= 오늘의 일정)
      </div>
    </main>
    
    <script>
    const countPlan = ${countPlan};
    const countIng = ${countIng};
    const countDone = ${countDone};
    const countSum = countPlan + countIng + countDone; // 총합

    // 페이지 로딩 후 차트를 생성합니다.
    window.onload = function() {
        createProjectChart();
    };

    function createProjectChart() {
        const ctx = document.getElementById('projectChart').getContext('2d');
        
     // JSTL로 계산된 동적 데이터 사용
        const data = {
            labels: ['전체', '계획', '진행', '완료'],
            datasets: [{
                label: '프로젝트 수',
                data: [countSum, countPlan, countIng, countDone],
                backgroundColor: [
                	'rgba(153, 102, 255, 0.7)', // 전체
                    'rgba(255, 59, 64, 0.7)', // 계획
                    'rgba(54, 162, 235, 0.7)', // 진행
                    'rgba(75, 192, 192, 0.7)'  // 완료
                ],
                borderColor: [
                	'rgba(153, 102, 255, 1)',
                    'rgba(255, 59, 64, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        };

        // 옵션
        const options = {
        	indexAxis: 'y', // 이 속성을 추가하여 가로 막대 그래프로 변경
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: '프로젝트 수'
                    },
                    ticks: {
                        stepSize: 1
                    }
                },
                 y: {
                    title: {
                        display: true,
                        text: '상태'
                    }
                }
            },
            plugins: {
                legend: {
                    display: false // 범례 숨기기
                },
                tooltip: {
                    callbacks: {
                        label: function(context) {
                            let label = context.dataset.label || '';
                            if (label) {
                                label += ': ';
                            }
                            if (context.parsed.y !== null) {
                                label += context.parsed.x + ' 건';
                            }
                            return label;
                        }
                    }
                }
            }
        };

        // 차트 생성
        const myChart = new Chart(ctx, {
            type: 'bar', // 막대 그래프
            data: data,
            options: options
        });
    }
</script>
  </body>
</html>
