<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../resource/css/layout.css">
<link rel="stylesheet" href="../../resource/css/user.css">
<meta charset="UTF-8">
<title>CSLog</title>
<style>
	
	.form-container {
		display: flex;
		align-items: center;
		gap: 10px; /* 입력창과 버튼 사이 간격 */
		margin-bottom: 20px;
	}
	.button-group {
		display: flex;
		gap: 5px; /* 버튼 사이의 간격 */
	}
	.form-container button {
		white-space: nowrap; /* 버튼 텍스트 줄 바꿈 방지 */
	}
	table {
		max-width: 70%; 
		border-collapse: separate;
		border-spacing: 0;
		border-radius: 5px; 
		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	}
	
	table td input[type="textarea"] {
		width: 450px;
	}
	
	.form-select, .form-control, .btn {
		font-size: 0.875rem; /* 글자 크기 줄이기 */
	}
	
	h1{
		color: lightgrey;
	}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../side.jsp"></jsp:include>
	
	<h1>클레임 리스트</h1>
	
	<form action="/customer/log" method="get" class="form-container">
		<select name="select" id="select" class="form-select w-auto">
			<option value="고객명">고객명</option>
			<option value="담당자명">담당자명</option>
			<option value="상담일자">상담일자</option>
		</select>
		<input type="text" id="searchName" name="search" placeholder="검색어를 입력해주세요." class="form-control">
		<div class="button-group">
			<button id="searchLog" class="btn btn-primary">검색</button>
			<a href="/" class="btn" style="background-color: #000; border-color: #000; color: #FFF;"><i class="bi bi-house-door-fill"></i></a>
		</div>
	</form>
	
	<table border="1">
	<tr>
		<th>번호</th>
		<th>고객명</th>
		<th>내용</th>
		<th>상담일자</th>
		<th>담당자명</th>
		<th>프로젝트명</th>
		<th>배분</th>
		<th>이동</th>
	</tr>
	<c:forEach items="${log}" var="cs">
		<tr>
			<td>${cs.logId}</td>
			<td>${cs.name}</td>
			<td><input type="textarea" class="cs-desc" value="${cs.clDescription}"></td>
			<td><fmt:formatDate value="${cs.logDate}" pattern="yyyy-MM-dd" /></td>
			<td>${cs.userName}</td>
			<td>
				<select class="form-select cs-projectId">
					<c:forEach items="${log}" var="project">
						<option value="${project.projectId}" ${cs.projectId == project.projectId ? 'selected' : ''}>${project.projectName}</option>
					</c:forEach>
				</select>
			</td>
			<td><button class="btn btn-primary updateLog" data-logid="${cs.logId}">!!</button></td>
			<td><a class="btn btn-secondary" href="/project/detail?projectId=${cs.projectId}">▶</a></td>
		</tr>
	</c:forEach>
	</table>
  	
	<nav>
		<ul class="pagination">
			<li class="page-item ${paging.prev ? '' : 'disabled'}"><a class="page-link" href="/customer/log?page=${paging.startPage - 1}">이전</a></li>
						
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
				<li class="page-item ${paging.page == page ? 'active' : ''}"><a class="page-link" href="/customer/log?page=${page}">${page}</a></li>
			</c:forEach>
						
			<li class="page-item ${paging.next ? '' : 'disabled'}"><a class="page-link" href="/customer/log?page=${paging.endPage + 1}">다음</a></li>
		</ul>
	</nav>
	
	<script>
	$("#select").change(()=>{
		if($("#select").val() === "상담일자"){
			$("#searchName").attr("type","date");
		} else {
			$("#searchName").attr("type","text");
		}
	});
	
	$('.updateLog').click(function(e) {
		e.preventDefault();
        const row = $(this).closest('tr');
        const updateLog = {
       		logId: $(this).data('logid'),
            projectId: row.find('.cs-projectId').val(),
            description: row.find('.cs-desc').val(),
        };
        
		$.ajax({
			type : "post",
			url : "/customer/updateLog",
			data : updateLog,
			success : function(result) {
				alert("수정이 완료되었습니다!");
				location.reload();
			},
			error : function(xhr, status, error) {
				alert("처리 중 오류가 발생하였습니다.");
			}
		});
	});
	</script>
</body>
</html>
