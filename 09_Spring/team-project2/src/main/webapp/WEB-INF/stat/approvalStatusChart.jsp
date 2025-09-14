<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %> <%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ERP</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  </head>

  <body>
	<div style="width: 70%; margin: auto;">
	    <canvas id="approvalStatusChart"></canvas>
	</div>
    <style>
      .btn {
        display: inline-block;
        padding: 0.6rem 1.2rem;
        font-size: 1rem;
        font-weight: 600;
        text-align: center;
        text-decoration: none; /* a 태그일 경우 밑줄 제거 */
        vertical-align: middle;
        cursor: pointer;

        border: 1px solid transparent;
        border-radius: 0.25rem;

        transition: all 0.2s ease-in-out; /* 부드러운 전환 효과 */
      }

      /* 회색 버튼 스타일 */
      .btn-secondary {
        color: #555;
        background-color: transparent;
        border-color: lightgrey;
      }

      /* 마우스를 올렸을 때 */
      .btn-secondary:hover {
        background-color: #5a6268;
        border-color: #545b62;
      }
      .chart-pagination .btn {
        padding: 0.3rem 0.8rem; /* 버튼의 상하, 좌우 여백을 줄임 */
        font-size: 0.9rem; /* 폰트 크기를 살짝 줄임 */
        font-weight: normal; /* 폰트 굵기를 보통으로 */
      }
    </style>
    <script>
		$(function() {
		    $.ajax({
		        url: '/approval/chart-data', // API 주소는 확인 필요
		        type: 'get',
		        success: function(dataFromServer) {
		            
		            // 1. 전체 상태 목록과 기본값(0)을 미리 정의
		            const allStatuses = {
		                '전체': 0,
		                '대기': 0,
		                '승인': 0,
		                '반려': 0
		            };

		            // 2. 서버에서 받은 데이터로 값을 업데이트하고, '전체' 개수를 계산
		            let total = 0;
		            dataFromServer.forEach(item => {
		                if (allStatuses.hasOwnProperty(item.status)) {
		                    allStatuses[item.status] = item.count;
		                    total += item.count;
		                }
		            });
		            allStatuses['전체'] = total;

		            // 3. Chart.js에 사용할 데이터로 변환
		            const labels = Object.keys(allStatuses);
		            const counts = Object.values(allStatuses);

		            // 4. Chart.js로 가로 막대 그래프 생성
		            const ctx = document.getElementById('approvalStatusChart').getContext('2d');
		            new Chart(ctx, {
		                type: 'bar', // 차트 종류
		                data: {
		                    labels: labels,
		                    datasets: [{
		                        label: '승인 상태별 건수',
		                        data: counts,
		                        backgroundColor: [
		                            'rgba(108, 117, 125, 0.7)', // 전체
		                            'rgba(255, 206, 86, 0.7)', // 대기
		                            'rgba(54, 162, 235, 0.7)', // 승인
		                            'rgba(255, 99, 132, 0.7)'   // 반려
		                        ],
								borderColor: [
				                    'rgba(108, 117, 125, 1)',
				                    'rgba(54, 162, 235, 1)',
				                    'rgba(255, 99, 132, 1)',
				                    'rgba(255, 206, 86, 1)'
				                ],
				                borderWidth: 1
		                    }]
		                },
		                options: {
		                    indexAxis: 'y', // ⬅️ 이 옵션이 그래프를 가로로 눕힙니다.
		                    responsive: true,
		                    plugins: {
		                        legend: { display: false }
		                    },
		                    scales: {
		                        x: { // x축(가로)이 이제 값을 나타냅니다.
		                            beginAtZero: true,
		                            ticks: { stepSize: 1 }
		                        }
		                    }
		                }
		            });
		        },
		        error: function(error) {
		            console.error("차트 데이터를 불러오는 데 실패했습니다.", error);
		        }
		    });
		});
    </script>
  </body>
</html>
