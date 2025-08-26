<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
<h1>일정</h1>
<button type="button" class="showScheAdd showModal">일정 등록</button>
<input type="hidden" id="projectId" name="projectId" value="${param.projectId}" />
<table border=1px>
	<thead>
		<tr>
			<th>일정명</th>
			<th>참여자</th>
			<th>내용</th>
			<th>시작</th>
			<th>종료</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${memberSchedule}" var="schedule" varStatus="status">
			<tr>
				<td>${schedule.title}</td>
				<td>${schedule.name}</td>
				<td><textarea name="description" class="description">${schedule.scheDescription}</textarea></td>
				<td>
				 	<input type="datetime-local"
				    value="<fmt:formatDate value='${schedule.scheStartDatetime}' pattern='yyyy-MM-dd\'T\'HH:mm' />"
				    class="startDatetime" name="startDatetime"
				    min="<fmt:formatDate value='${project.startDate}' pattern='yyyy-MM-dd\'T\'HH:mm' />"
				    max="<fmt:formatDate value='${project.endDate}' pattern='yyyy-MM-dd\'T\'HH:mm' />">
				</td>

				<td>
				    <input type="datetime-local"
				    value="<fmt:formatDate value='${schedule.scheEndDatetime}' pattern='yyyy-MM-dd\'T\'HH:mm' />"
				    class="endDatetime" name="endDatetime"
				    min="<fmt:formatDate value='${project.startDate}' pattern='yyyy-MM-dd\'T\'HH:mm' />"
				    max="<fmt:formatDate value='${project.endDate}' pattern='yyyy-MM-dd\'T\'HH:mm' />">
				</td>
				<td><button type="button" data-id="${schedule.scheduleId}" class="updateBtn">수정</button></td>
				<td><button type="button" data-id="${schedule.scheduleId}" data-project="${param.projectId}"class="deleteBtn">삭제</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

<div class="openScheAdd openModal">
	<div class="scheAddModal modalBody">
	<form action="/project/scheAdd" method="post">
		<h2>일정 등록</h2>
		<input type="hidden" id="projectId" name="projectId" value="${param.projectId}" />
		<input type="hidden" id="projectStart" value="${project.startDate.time}">
		<input type="hidden" id="projectEnd" value="${project.endDate.time}">
		<p>일정명 : <input type="text" name="title" id=title></p>
		<p>참여자 : 
			<select name="userId" id="scheUser">
				<c:forEach items="${projectUserList}" var="psUser">
					<option value="${psUser.userUserId}">${psUser.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>내용 : <textarea placeholder="내용을 입력해주세요" name="description" id="scheDesc"></textarea></p>
		<p>시작 : 
			<input type="datetime-local" id="startDatetime" name="startDatetime"
				min="<fmt:formatDate value='${project.startDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>"
				max="<fmt:formatDate value='${project.endDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>"
				value="<fmt:formatDate value='${project.startDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>">
		</p>
		<p>종료 : 
			<input type="datetime-local" id="endDatetime" name="endDatetime"
				min="<fmt:formatDate value='${project.startDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>"
				max="<fmt:formatDate value='${project.endDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>"
				value="<fmt:formatDate value='${project.startDate}' pattern='yyyy-MM-dd\'T\'HH:mm'/>">
		</p>
		<p id="checkDate">모든 값을 입력해주세요</p>
		<button type="submit" id="scheduleInsert">등록</button>
		<button type="button" class="closeScheAdd closeModal">닫기</button>
	</form>
	</div>
</div>
<script>
	
	$(".showScheAdd").click(function() {
		$(".openScheAdd").css("display", "flex");
	});

	$(".closeScheAdd").click(function() {
		$(".openScheAdd").css("display", "none");
	});

	$(".openScheAdd").click(function(e) {
		if (e.target === this) {
			$(this).hide();
		}
	});
	
	 $(".updateBtn").click(function() {
	        const row = $(this).closest("tr"); 
	        const scheduleId = $(this).data("id"); 

	        const description = row.find(".description").val();
	        const startDatetime = row.find(".startDatetime").val();
	        const endDatetime = row.find(".endDatetime").val();
	        
	        $.ajax({
	            url: "/project/proSche",
	            type: "post",
	            data: {
	                scheduleId: scheduleId,
	                description: description,
	                startDatetime: startDatetime,
	                endDatetime: endDatetime
	            },
	        });
	    });
	
	 $(".deleteBtn").click(function() {
		 const scheduleId = $(this).data("id"); 
		 const projectId = $(this).data("project");
		 
		 $.ajax({
	            url: "/schedule/proScheDel",  
	            type: "post",
	            data: {scheduleId : scheduleId,
					   projectId : projectId
	            },
	            success: function() {
	                location.reload();
	            }
	        });
	 })
	 
	function InsertSchdule() {
	    const projectStart = new Date(Number($("#projectStart").val()));
	    const projectEnd   = new Date(Number($("#projectEnd").val()));

	    const title = $("#title").val().trim();
	    const desc  = $("#scheDesc").val().trim();
	    const user  = $("#scheUser").val();

		const scheStart = new Date($("#startDatetime").val());
		const scheEnd   = new Date($("#endDatetime").val());
		
	    let valid = true;
	    let msg = "";

	    if (!title || !desc || !user || !scheStart || !scheEnd) {
	        valid = false;
	        msg = "모든 값을 입력해주세요";
	    } else if (scheStart < projectStart) {
	        valid = false;
	        msg = "일정 시작일은 프로젝트 시작일보다 이전일 수 없습니다.";
	    } else if (scheStart > projectEnd) { 
	        valid = false;
	        msg = "일정 시작일은 프로젝트 종료일보다 이후일 수 없습니다.";
	    } else if (scheEnd > projectEnd) {
	        valid = false;
	        msg = "일정 종료일은 프로젝트 종료일보다 이후일 수 없습니다.";
	    } else if (scheEnd < scheStart) {
	        valid = false;
	        msg = "일정 종료일은 일정 시작일보다 이전일 수 없습니다.";
	    }

	    $("#checkDate").text(msg);
	    $("#scheduleInsert").prop("disabled", !valid);

	}

	$("#title, #scheDesc, #scheUser, #startDatetime, #endDatetime").on("input change", InsertSchdule);

	$("#scheduleInsert").prop("disabled", true);
</script>