<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Project Detail</title>
<link rel="stylesheet" href="../resource/css/project.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="../../resource/css/layout.css">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../side.jsp"></jsp:include>
	<h1>상세 보기</h1>
	<div id="allDetailMenu">
		<div id="rightDetailMenu">
			<div>
				<form action="/project/update" method="post" id="updateForm">
					<input type="hidden" id="projectId" name="projectId"
						value="${project.projectId}" />
					<p>코 드 : ${project.projectCode}</p>
					<p>프로젝트 명 : ${project.projectName}</p>
					<p>타 입 : ${project.projectType}</p>
					<p>내 용 : ${project.description}</p>
					<p>
						생성일 :
						<fmt:formatDate value='${project.createdAt}' pattern='yyyy-MM-dd' />
					</p>
					<p>
						진행상태 : <select name="status" id="status">
							<option value="계획중"
								<c:if test="${project.status == '계획중'}">selected</c:if>>계획중</option>
							<option value="진행중"
								<c:if test="${project.status == '진행중'}">selected</c:if>>진행중</option>
							<option value="완료"
								<c:if test="${project.status == '완료'}">selected</c:if>>완료</option>
						</select>
					</p>
					<p>담당자 : ${project.name}</p>
					<input type="hidden" name="userId"
						value="${project.userId != null ? project.userId : 0}">
					<p>
						시작일 : <input type="date" name="startDate" id="startDate"
							value="<fmt:formatDate value='${project.startDate}' pattern='yyyy-MM-dd' />" />
					</p>
					<p>
						종료일 : <input type="date" name="endDate" id="endDate"
							value="<fmt:formatDate value='${project.endDate}' pattern='yyyy-MM-dd' />" />
					</p>
					<p id="updateError"></p>
					<p>
						최종 수정일 :
						<fmt:formatDate value="${project.updatedAt}"
							pattern="yyyy년 MM월 dd일 HH:mm:ss" />
					</p>
					<button type="submit" id="projectUpdate">수정</button>
				</form>
				<button type="button" class="showDeleteModal showModal">삭제</button>
			</div>
		</div>

		<div id="leftDetailMenu">
		    <a href="#member" class="detailTab active" id="memberTab">member</a> 
		    <a href="#chemical" class="detailTab" id="chemicalTab">chemical</a> 
		    <a href="#document" class="detailTab" id="documentTab">document</a> 
		    <a href="#schedule" class="detailTab" id="scheduleTab">schedule</a>

			<div id="detailContent">
				<div id="memberContent">
					<jsp:include page="member.jsp"></jsp:include>
				</div>
				<div id="chemicalContent">
					<jsp:include page="chemical.jsp">
						<jsp:param name="projectId" value="${project.projectId}" />
					</jsp:include>
				</div>
				<div id="documentContent">
					<jsp:include page="document.jsp"></jsp:include>
				</div>
				<div id="scheduleContent">
					<jsp:include page="projectSchedule.jsp"></jsp:include>
				</div>
			</div>
		</div>
		

		<div class="openDeleteModal openModal">
			<div class="modalBody DeleteModalBody">
				<h1>삭제하시겠습니까?</h1>
				<button type="submit" id="projectDelete"
					data-id="${project.projectId}">삭제</button>
				<button class="closeDeleteModal closeModal">닫기</button>
			</div>
		</div>
	</div>
	<button type="button" id="listPage">목록으로 돌아가기</button>
	<script>

	$(".showDeleteModal").click(function() {
	    $(".openDeleteModal").css("display","flex");
	});
	
	$(".closeDeleteModal").click(function() {
	    $(".openDeleteModal").css("display","none");
	});
	$(".openDeleteModal").click(function(e){
	    if(e.target === this){
	        $(this).hide();
	    }
	});

	$(function() {
		  $("#updateForm").on("submit", function(e) {
		    let start = $("#startDate").val();
		    let end = $("#endDate").val();
		    let $updateError = $("#updateError");

		    if (start && end && new Date(start) > new Date(end)) {
		        e.preventDefault(); 
		        $updateError.text("종료일은 시작일 이후로 지정해주세요.").css("color", "red");
		    } else {
		        $updateError.text(""); // 날짜가 맞으면 메시지 지우기
		    }
		  });
		});
	
	$("#projectDelete").click(function(e) {

		const projectId = $(this).data("id");
		
		$.ajax({
			type : "get",
			url : "/project/delete",
			data : "projectId=" + projectId,
			success : function(result) {
				alert("삭제 성공")
				location.href = "/project/list";
			},
			error : function(xhr, status, error) {
				alert("오류로 인해 삭제에 실패했습니다.");
				$(".openModal").hide()
			}
		});
	});
	
	$("#listPage").click((e)=>{
		location.href = "/project/list"
	});
	
	
	
	function showTab(tabName){
	    $(".detailTab").removeClass("active");
	    $("#" + tabName + "Tab").addClass("active");
	    $("#detailContent > div").hide();
	    $("#" + tabName + "Content").show();
	}

	$(function(){
	    // 페이지 로드 시 hash 확인
	    let hash = location.hash.replace("#", "");
	    if(hash) showTab(hash);
	    else showTab("member"); // 기본 탭

	    // 탭 클릭
	    $(".detailTab").click(function(e){
	        e.preventDefault();
	        let tabName = $(this).attr("id").replace("Tab","");
	        showTab(tabName);
	        location.hash = tabName; // URL hash에 저장
	    });
	});
	
	$(function(){
	    function handleHash(){
	        let hash = location.hash.replace("#", "");
	        if(hash) showTab(hash);
	        else showTab("member");
	    }

	    // 페이지 로드 시
	    handleHash();

	    // 뒤로가기 / 앞으로가기 시
	    $(window).on("hashchange", handleHash);

	    // 탭 클릭
	    $(".detailTab").click(function(e){
	        e.preventDefault();
	        let tabName = $(this).attr("id").replace("Tab","");
	        showTab(tabName);
	        location.hash = tabName;
	    });
	});
	
	</script>
</body>
</html>