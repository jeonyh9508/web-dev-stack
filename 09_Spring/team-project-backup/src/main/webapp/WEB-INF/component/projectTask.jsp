<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<section class="projectTask">
<h1>Task</h1>
<div class="search">
<p class="tab"> 검색 : </p><input type="text" id="search"/>
<input type="submit" id="search" value="검색">
</div>
<table class="task_table">
	<thead>
		<tr>
			<th>코드</th>
			<th>업무명</th>
			<th>담당자</th>
			<th>마감일</th>
			<th>상태</th>
			<th>우선순위</th>
			<th>상세설명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	<thead>
	<tbody>
	<c:forEach items="${projectTask}" var="item">
		<tr>
			<td>${item.projectId}</td>
			<td>${item.taskName}</td>
			<td>${item.assigneeId}</td>
			<td>${item.dueDate}</td>
			<td>${item.status}</td>
			<td>${item.priority}</td>
			<td>${item.notes}</td>
			<td><button id="updateProject">수정</button></td>
			<td><button id="deleteProject">삭제</button></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</section>