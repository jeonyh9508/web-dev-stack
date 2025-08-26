<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Board</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin-srigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<link rel="stylesheet" href="../../resource/css/layout.css">
	<link rel="stylesheet" href="../../resource/css/user.css">

	<style>
		.main-content {
			background-color: transparent;
		}
		
		table.table thead th {
			background-color: #f2f2f2;
		}
		
		table.table tbody td {
			max-width: 400px;
			background-color: transparent;
			overflow: hidden;
    		white-space: nowrap;
    		text-overflow: ellipsis;
		}
		
		.table {
			min-width: 1200px;
			max-width: 1200px;
			border-collapse: separate;
			border-spacing: 0;
			border-radius: 5px;
			box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
			background-color: rgba(255, 255, 255, 0.6);
			margin: 20px auto;
		}
        
		.table th:first-child, .table th:last-child, .table td:first-child, .table td:last-child {
			width: 80px;
		}

        .form-select, .form-control, .btn {
		font-size: 0.875rem;
		}
		
		h1{
			color: lightgrey;
			font-size: 30px;
		}
		
		a{
			color: #e91e63;
			text-decoration: underline;
		}
		
		#inputTitle{
			width: 300px;
		}
		
		.modal-back {
			position: fixed;
			top: 0; left: 0; right: 0; bottom: 0;
			background: #3337;
			z-index: 1000;
			display: none;
			justify-content: center;
			align-items: center;
		}
		.write-modal{
			border: 1px solid grey;
			border-radius: 10px;
			background: white;
			position: relative;
			width: 400px;
			padding: 30px;
		}
		
		.write-modal #modal-close {
			position: absolute;
			top: 15px; right: 15px;
			cursor: pointer;
			font-size: 30px;
			border: none;
			background: none;
		}
		
		.modal-body label{
			margin-top: 15px;
		}

	</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../side.jsp"></jsp:include>
<div class="main-content">
		<h1><게시판 작성><br>상세 페이지 내 자료 확인 업/다운로드 기능 추가</h1>
		
		<form action="/customer/board" method="get" class="form-container">
			<select>
				<option value="title">제목</option>
				<option value="uploadedBy">작성자</option>
			</select>
			<span class="search-flex-container">
				<input id="inputTitle" type="text" class="form-control" name="keyword" value="${param.keyword}" placeholder="검색어를 입력하세요.">
				<i class="bi bi-eraser-fill clear-icon"></i>
			</span>
			<div class="button-group">
				<button type="submit" class="btn btn-danger search-btn">검색</button>
				<button type="button" id="modal-open" class="btn btn-primary">등록</button>
				<a href="/" class="btn" style="background-color: #000; border-color: #000; color: #FFF;"><i class="bi bi-house-door-fill"></i></a>
			</div>
		</form>
		
		
	<table class="table" id="boardTable">
		<thead>
			<tr>
				<th>번호</th>
				<th>유형</th>
				<th>제목</th>
				<th>내용</th>		
				<th>작성자</th>		
				<th>최종수정시간</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.boardNo}</td>
						<td>${board.type}</td>
						<td><a href="/customer/view?boardNo=${board.boardNo}">${board.title}</a></td>
						<td>${board.content}</td>
						<td>${board.uploaderName}</td>
						<td><fmt:formatDate value="${board.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<a class="btn btn-outline-danger" href="/customer/delete?boardNo=${board.boardNo}"><i class="bi bi-trash"></i></a>
						</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>

	<div class="modal-back">
		<div class="write-modal">
			<button id="modal-close"><i class="bi bi-x"></i></button>
			<form action="/write" method="post" enctype="multipart/form-data">
				<div class="modal-body">
					<h3>리포트 작성하기</h3>
						<label class="form-label">유형</label>
							<select class="form-control" name="type" id="typeSelect">
								<option value="claim">클레임</option>
								<option value="notice">공지사항</option>
							</select>
							
						<!-- <label class="form-label">누구</label>
							<select class="form-control" name="uploaderType" id="upTypeSelect">
								<option value="customer">고객</option>
								<option value="user">매니저</option>
							</select>
						 -->	
							
						<label class="form-label">작성자</label>
							<select class="form-control" name="uploadedBy" id="uploadedBySelect">
							<option value="" selected disabled>--- 이름을 선택해주세요 ---</option>
							<optgroup label="고객명" id="customerOptions">
								<c:forEach items="${customer}" var="cs">
								<option value="${cs.customerId}">${cs.name}</option>
								</c:forEach>
							</optgroup>
							<optgroup label="관리자명" id="managerOptions" style="display: none;">
								<c:forEach items="${manager}" var="manager">
								<option value="${manager.userId}">${manager.name}</option>
							</c:forEach>
						</optgroup>
						</select>
						
						<label class="form-label">제목</label>
						<input type="text" class="form-control" name="title">
						<label class="form-label">내용</label>
						<textarea class="form-control" rows="3" name="content"></textarea>
						<label class="form-label">파일 첨부</label>
						<input class="form-control" name="file" type="file" accept="image/*">
					</div>
						<button type="submit" class="btn btn-warning mt-2">등록하기</button>
			</form>
		</div>
	</div>
	
	<nav>
		<ul class="pagination">
			<li class="page-item ${paging.prev ? '' : 'disabled'}"><a
				class="page-link" href="/customer/board?page=${paging.startPage - 1}&keyword=${param.keyword}">이전</a></li>

			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
				<li class="page-item"><a
					class="page-link ${paging.page == page ? 'active' : ''}"
					href="/customer/board?page=${page}&keyword=${param.keyword}">${page}</a></li>
			</c:forEach>

			<li class="page-item ${paging.next ? '' : 'disabled'}"><a
				class="page-link" href="/customer/board?page=${paging.endPage + 1}&keyword=${param.keyword}">다음</a></li>
		</ul>
	</nav>
</div>

	<script>
	
		// 게시물 등록 Modal
		$("#modal-open").click(() => {
	        $(".modal-back").css("display", "flex");       
	     });
		
		$("#modal-close").click(() => {
	       $(".modal-back").css("display", "none");       
	    });
		
		/*
		$(".modal-back").click((e) => {
	       if(e.target === e.currentTarget) {
				$(".modal-back").css("display", "none");
	       }
	    });
		*/

		// 검색 입력 필드와 초기화 아이콘 관련 스크립트
		const searchInput = $('input[name="keyword"]');
		const clearIcon = $('.clear-icon');

		if (searchInput.val().length > 0) {
			clearIcon.show();
		}

		searchInput.on('input', function() {
			if ($(this).val().length > 0) {
				clearIcon.show();
			} else {
				clearIcon.hide();
			}
		});

		clearIcon.on('click', function() {
			searchInput.val('');
			$(this).hide();
			searchInput.focus();
		});
		
		// 게시물 작성 모달의 유형 및 작성자 드롭다운 제어
	    $(document).ready(function() {
	        const typeSelect = $('#typeSelect');
	        const upTypeSelect = $('#upTypeSelect');
	        const deptOptions = $('#deptOptions');
	        const managerOptions = $('#managerOptions');
	        const customerOptions = $('#customerOptions');
	        
	        typeSelect.on('change', function() {
	            const selectedType = $(this).val();

	            if (selectedType === 'claim') {
	            	customerOptions.show();
	                managerOptions.hide();
	            } else if (selectedType === 'notice') {
	            	customerOptions.hide();
	                managerOptions.show();
	            }
	        });
	    });

	</script>
</head>

</body>
</html>