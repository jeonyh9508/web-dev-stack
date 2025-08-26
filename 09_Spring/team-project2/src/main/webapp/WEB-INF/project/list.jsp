<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ERP</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="../../resource/css/layout.css">
    <link rel="stylesheet" href="../resource/css/project.css">
  <meta charset="UTF-8">
  </head>
  <body>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../side.jsp"></jsp:include>
  	<h1>프로젝트</h1>
  	<p>계획 : ${count1} 건</p>
  	<p>진행 : ${count2} 건 </p>
  	<p>완료 : ${count3} 건 </p>
  	
  		<button id="insertPage">추가페이지로 이동</button>
  		
  		<form action="/project/list" method="get">
			<select name = "select" id="select">
				<option value="status">상태</option>
				<option value="code">프로젝트 코드</option>
				<option value="name">프로젝트 명</option>
				<option value="date">진행일정</option>
				<option value="manager">담당자</option>
			</select>  
			<input type="text" name="search" id="projectSearch"/>
			<input type="submit" value="검색" />		
  		</form>
  		
  		<form action="/project/selectDelete" method="post" class="selectDelete">
  		<table border=1px>
		<thead>
			<tr>
				<th>No</th>
				<th>코드</th>
				<th>프로젝트명</th>
				<th>담당자</th>
				<th>타입</th>
				<th>진행상태</th>
				<th>시작일</th>
				<th>종료일</th>
				<th>상세</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list" varStatus="status">
				<tr>
					<td>${status.count} (${list.projectId})</td>
					<td>${list.projectCode}</td>
					<td>${list.projectName}</td>	
					<td>
					<c:choose>
						<c:when test="${list.userId != 0 && list.memberRole=='담당자'}">			
							${list.name}
						</c:when>
						<c:when test="${list.userId == 0}">
							미배정
						</c:when>
					</c:choose>
					</td>
					<td>${list.projectType}</td>
					<td>${list.status}</td>
					<td><fmt:formatDate value="${list.startDate}" pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${list.endDate}" pattern="yyyy-MM-dd" /></td>
					<td><button type="button" class="projectDetail" data-id="${list.projectId}"> details</button></td>
					<td>
						<input type="checkbox" class="idList" name="idList" value="${list.projectId}" data-code="${list.projectCode}" 
    					data-name="${list.projectName}">
    				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
	
	<button type="button" class="showModal">삭제</button>
	<div class="openModal">
		<div class="modalBody">
			<h2>경고</h2>
			<div id="modalList"></div>
			<p>삭제하시겠습니까?</p>
			<button type="button" id="projectSelectDelete">삭제</button>
			<button class="closeModal">닫기</button>
		</div>
	</div>
	
	<nav>
		<ul class="pagination">
			<li class="page-item ${paging.prev ? '' : 'disabled'}"><a class="page-link" href="/project/list?page=${paging.startPage - 1}&search=${param.search}&select=${param.select}">이전</a></li>
						
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
				<li class="page-item"><a class="page-link ${paging.page == page ? 'active' : ''}" href="/project/list?page=${page}&search=${param.search}&select=${param.select}">${page}</a></li>
			</c:forEach>
						
			<li class="page-item ${paging.next ? '' : 'disabled'}"><a class="page-link" href="/project/list?page=${paging.endPage + 1}&search=${param.search}&select=${param.select}">다음</a></li>
		</ul>
	</nav>
	
	<script>
	$("#select").change(()=>{

		if($("#select").val() === "date"){
			$("#projectSearch").attr("type","date");
		} else {
			$("#projectSearch").attr("type","text");
		}
	});
	
	$(".projectDetail").click((e)=>{
		const projectId = $(e.target).data("id");
		//console.log(projectId);
		location.href = "/project/detail?projectId=" + projectId;
	});
	
	$(".showModal").prop("disabled", true);
	
	$(".idList").change(()=>{
		let check = $(".idList:checked").length;
		$(".showModal").prop("disabled", check === 0);
	})
	
	$(".showModal").click(function() {
		let checkList = $(".idList:checked").map(function() {
		   let code = $(this).data("code");
		   let name = $(this).data("name");
		   return code + " : " + name;
		}).get();
		 $("#modalList").html(checkList.join("<br>"));
		   
		   $(".openModal").css("display","flex");
	});
	
	$(".closeModal").click(function() {
	    $(".openModal").css("display","none");
	});
	
	$(".openModal").click(function(e){
	    if(e.target === this){
	        $(this).hide();
	    }
	});
	
	$("#projectSelectDelete").click(function() {
	    $(".selectDelete").submit();
	});
	
	
	$("#insertPage").click((e)=>{
		location.href ="/project/insert";
	})
	</script>
  </body>
</html>
