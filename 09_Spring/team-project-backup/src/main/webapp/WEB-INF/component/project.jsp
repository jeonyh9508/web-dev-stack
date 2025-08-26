<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<section class="project">
	<h1>프로젝트</h1>
	<div class="function">
		<form action="/project" method="post">
			<select name="select">
				<option value="projectCode">코드</option>
				<option value="projectName">프로젝트명</option>
				<option value="manager">담당자</option>
				<option value="status">진행상태</option>
				<option value="projectType">타입</option>
				<option value="unknown">미배정</option>
			</select> <input type="text" name="search" />
			<button type="submit" id="search" name="searchBtn">검색</button>
		</form>

		<button class="insertOpenModal">추가</button>

		<div class="insertModal">
			<div class="insert-modal">
				<h1>프로젝트 추가</h1>
				<form action="/insert" method="post">
					<p>	코드 : <input type="text" name="projectCode">	</p>
					<p> 프로젝트명 : <input type="text" name="projectName"> </p>
					<p>	타입 : <input type="text" name="projectType"> </p>
					<p>	진행상태 : <input type="text" name="status"> </p>
					<p>	진행일 : <input type="date" name="startDate">	</p>
					<button type="submit" id="insertProject" name="insertBtn">추가</button>
					<button type="button" class="insertCloseModal">닫기</button>
				</form>
			</div>
		</div>

	</div>
	<table class="project-table">
		<thead>
			<tr>
				<th>No</th>
				<th>코드</th>
				<th>프로젝트명</th>
				<th>담당자</th>
				<th>타입</th>
				<th>진행상태</th>
				<th>시작일</th>
				<th>상세보기</th>
			</tr>
		<thead>
		<tbody>
			<c:forEach items="${project}" var="item" varStatus="status">
				<tr>
					<td>${item.projectId}</td>
					<td>${item.projectCode}</td>
					<td>${item.projectName}</td>					
					<td>${item.userName}</td>
					<td>${item.projectType}</td>
					<td>${item.status}</td>
					<td><fmt:formatDate value="${item.startDate}" pattern="yyyy-MM-dd" /></td>
					<td>
					<button type="submit" class="projectDetail" name="projectId" data-id="${item.projectId}">
					          Details
					</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>

<script>

const insertModal = document.querySelector('.insertModal');
const insertOpenModal = document.querySelector('.insertOpenModal');
const insertCloseModal = document.querySelector('.insertCloseModal');

insertOpenModal.addEventListener("click", ()=>{
    insertModal.style.display="flex";
});

insertCloseModal.addEventListener("click",()=>{
	insertModal.style.display="none";
});

/*
$.each($('#projectDetails'),(index, button)=>{
	$(button).click(()=>{
    const projectId = $(this).data("id");
    const projectCode = $(this).data("code");
    const projectType = $(this).data("type");
  	const status = $(this).data("status");
	const projectName = $(this).data("name");  	
  	const updatedAt =$(this).data("updatedat");
	
	$("#projectCode").text(projectCode)
	$("#projectName").text(projectName)
	$("#projectType").text(projectType)
  	$("#update").text(updatedAt);
  	
    $('#projectId').val(projectId);
    $('#projectCode').val(projectCode);
    $('#projectName').val(projectName);
    $('#projectType').val(projectType);
    $('#managerId').val();
    $('#status').val(status);
    $('#endDate').val();
    $('#updatedAt').val(updatedAt);
    
   
    })
});
});
 */
$(".projectDetail").click((e)=>{
	const projectId = $(e.target).data("id");
	console.log(projectId);
	location.href = "/detail?projectId=" + projectId;
});
 
 
</script>