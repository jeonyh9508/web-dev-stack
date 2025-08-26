<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section>
	<h1>상세 보기</h1>
	<div id="detail">
		<div id="update-part">
		<form action="/update" method="post">
			<input type="text" id="projectId" name="projectId" value="${project.projectId}" />
			<select>
			<p> 코 드 : ${project.projectCode} </p>
			<p> 프로젝트 명 : ${project.projectName} </p>
			<p> 타 입 : ${project.projectType} </p>
			<p>	담당자 배정 : <input type="text" id="managerId" name="managerId"> </p>
			<p> 진행상태 : ${project.status} </p>
			<p> 종료일 : ${project.endDate} </p>
			<button id="updateProject" name="updateBtn">수정</button>
			<p> 최종 수정일 : <fmt:formatDate value="${project.updatedAt}" pattern="yyyy-MM-dd" /> </p>
			</select>
		</form>
		</div>
		<div class="task-part">
			project_task 들어갈 예정
		</div>
	</div>
	<button type="submit" id="deleteProject" data-id="${project.projectId}">삭제</button>
</section>	
<script>

$("#deleteProject").click(function(e) {

const projectId = $(this).data("id");

console.log(projectId);
 	$.ajax({
  		type: "get",
   		url: "/delete",
   		data: "projectId=" + projectId,
   		success: function(result){
   			alert("삭제 성공")
   			location.href="/project";
   		},
   		error: function(xhr, status, error) {
   			alert("오류");
   		}
	});
});

</script>