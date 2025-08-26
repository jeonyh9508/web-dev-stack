<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>예산 관리</title>

<link rel="stylesheet" href="../resources/css/rnd.css" />

<style>
table {
	width: 100%;
	border-collapse: collapse;
	table-layout: fixed; /* 고정 레이아웃 */
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: center;
	white-space: nowrap; /* 내용이 줄바꿈되지 않도록 */
	overflow: hidden; /* 내용이 넘치면 숨김 */
}

th {
	background-color: #d7d7d7;
	position: relative; /* 리사이즈 핸들 위치 지정을 위해 */
}

.resize-handle {
	position: absolute;
	right: 0;
	top: 0;
	bottom: 0;
	width: 3px; /* 드래그할 영역 */
	height: 100%;
	cursor: ew-resize; /* 가로 리사이즈 커서 */
	background-color: transparent; /* 기본적으로 투명 */
	z-index: 1; /* 핸들이 컬럼 위에 오도록 */
}

/* 마우스 오버 시 핸들 보이게 */
th:hover .resize-handle {
	background-color: rgba(0, 0, 0, 0.1); /* 호버 시 약간 보이게 */
}

.selectRow:hover {
	background: lightgrey;
	color: white;
}

#myTable thead th:last-child {
	width:50px;
}
</style>
</head>
<body>

	<section class="project">
		<h1>예산 관리</h1>
		<div class="function">

			<form action="/budget" method="post">
				<select name="select">
					<option value="projectName">프로젝트명</option>
					<option value="approvedBy">승인자</option>
					<option value="status">승인 상태</option>
				</select>
				<input type="text" id="search" />
				<button type="submit" id="search" name="검색">검색</button>
				<button type="submit" id="update" name="수정" disabled>수정</button>
				<button type="submit" id="delete" name="삭제" disabled>삭제</button>
			</form>
		</div>

		<form id="deleteBudget" action="/deleteBudget" method="post">
		<table id="myTable">
			<thead>
				<tr>
					<th rowspan="2">프로젝트명</th>
					<th rowspan="2">예산 항목</th>
					<th rowspan="2">금액</th>
					<th rowspan="2">사용량</th>
					<th rowspan="2">승인자</th>
					<th rowspan="2">승인 상태</th>
					<th rowspan="2">승인 일자</th>
					<th><input type="submit" value="삭제"></th>
				</tr>
				<tr>
					<th>(all<input type="checkbox" id="deleteAll" />)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="bud">
					<tr class="selectRow">
						<td>${bud.projectName}</td>
						<td>${bud.item}</td>
						<td>${bud.amount}</td>
						<td>${bud.usedAmount}</td>
						<td>${bud.userName}</td>
						<td>${bud.status}</td>
						<td>${bud.approvedAt}</td>
						<td><input type="checkbox" class="budCheckbox" name="idList" value="${bud.projectId}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>

		<nav>
			<ul class="pagination">
				<li class="page-item ${paging.prev ? '' : 'disabled'}"><a
					class="page-link" href="/budget?page=${paging.startPage - 1}">이전</a></li>

				<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
					var="page">
					<li class="page-item"><a
						class="page-link ${paging.page == page ? 'active' : ''}"
						href="/budget?page=${page}">${page}</a></li>
				</c:forEach>

				<li class="page-item ${paging.next ? '' : 'disabled'}"><a
					class="page-link" href="/budget?page=${paging.endPage + 1}">다음</a></li>
			</ul>
		</nav>

	</section>

<script>
		const budCheckbox = document.querySelectorAll(".budCheckbox");
		const budDeleteAll = document.querySelector("#deleteAll");
		budDeleteAll.addEventListener("click", () => {
			if(budDeleteAll.checked) {
				for(const checkBox of budCheckbox) {
					checkBox.checked = true;
				}
			} else {
				for(const checkBox of budCheckbox) {
					checkBox.checked = false;
				}
			}
		});

        document.addEventListener('DOMContentLoaded', function() {
            const table = document.getElementById('myTable');
            const headers = table.querySelectorAll('th');

            let currentResizableTh = null;
            let startX = 0;
            let startWidth = 0;
            let currentColIndex = -1;

            headers.forEach((th, index) => {
                const handle = document.createElement('div');
                handle.classList.add('resize-handle');
                th.appendChild(handle);

                handle.addEventListener('mousedown', function(e) {
                    currentResizableTh = th;
                    startX = e.clientX;
                    startWidth = th.offsetWidth;
                    currentColIndex = index;

                    document.addEventListener('mousemove', doResize);
                    document.addEventListener('mouseup', stopResize);

                    e.preventDefault();
                });
            });

            function doResize(e) {
                if (!currentResizableTh) return;

                let newWidth = startWidth + (e.clientX - startX);
                const minWidth = 50;
                if (newWidth < minWidth) {
                    newWidth = minWidth;
                }

                currentResizableTh.style.width = newWidth + 'px';

                const rows = table.querySelectorAll('tr');
                rows.forEach(row => {
                    const cell = row.children[currentColIndex];
                    if (cell) {
                        cell.style.width = newWidth + 'px';
                    }
                });
            }

            function stopResize() {
                currentResizableTh = null;
                currentColIndex = -1;

                document.removeEventListener('mousemove', doResize);
                document.removeEventListener('mouseup', stopResize);
            }
        });
        
        $(".deleteBudget").click(() => {
        		$.ajax({
        			type: "post",
        			url: "/deleteBudget",
        			data: $("#deleteBudget").serialize(),
        			success: function(result){
        				alert("삭제 성공")
        				location.reload();
        			},
        			error: function(xhr, status, error) {
        				console.error("삭제 실패:", error);
        				alert("삭제 중 오류 발생");
        			}
        		})
        });
    </script>
</body>
</html>