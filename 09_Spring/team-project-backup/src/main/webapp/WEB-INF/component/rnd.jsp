<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../resources/css/rnd.css" />
  </head>
  <body>
<section class="project">
	<h1>임상/시험/연구개발</h1>
	<div class="function">
	<p class="tab">검색</p>
	<form action="/searchRnd" method="post">
	<input type="text" id="keyword" />
	<select>
		<option value="projectName">프로젝트명</option>
		<option value="docName">문서명</option>
		<option value="uploadedBy">업로더</option>
	</select>
	<input type="submit" id="searchRnd" value="검색">
	</form>
	<!-- <button id="insertRnd">데이터 추가</button> -->
	
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="업로드 (미구현)">
	</form>
	
	</div>
	<table class="rnd_table">
		<thead>
			<tr>
				<th rowspan="2">No</th>
				<th rowspan="2">프로젝트명</th>
				<th colspan="5">문서</th>
				<th colspan="3">LAB</th>
				<th>보관</th>
				<th rowspan="2">수정</th>
				<th rowspan="2">삭제</th>
			</tr>
			<tr>
				<th>문서명</th>
				<th>유형</th>
				<th>경로</th>
				<th>업로더</th>
				<th>업로드 날짜</th>
				<th>연구실명</th>
				<th>위치</th>
				<th>연락처</th>
				<th>방법</th>
			</tr>
		<thead>
		<tbody>
			<c:forEach items="${list}" var="item" varStatus="status">
				<tr>
					<td><c:out value="${status.count}" /></td>
					<td>${item.projectName}</td>
					<td>${item.docName}</td>
					<td>${item.docType}</td>
					<td>${item.filePath}</td>
					<td>${item.userName}</td>
					<td>${item.uploadedAt}</td>
					<td>${item.labName}</td>
					<td>${item.location}</td>
					<td>${item.contact}</td>
					<td>${item.type}</td>
					<td><button class="updateRnd" data-id="${item.projectId}">수정</button></td>
					<td><button class="deleteRnd" data-id="${item.projectId}">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>

<script>

/*
$(".updateRnd").click((e) => {
	const projectId = $(e.target).data("id");
	alert(projectId);
		$.ajax({
			type:"post"
			url:"/update"
			data:"projectId=" +
		})
});
*/

$(".deleteRnd").click((e) => {
	const projectId = $(e.target).data("id");
		$.ajax({
			type: "post",
			url: "/deleteRnd",
			data: "projectId=" + projectId,
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