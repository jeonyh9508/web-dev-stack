<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h2>사용 시약</h2>
	<button type=button class="showPcAdd showModal">시약 추가</button>
	<table border=1px>
		<thead>
			<tr>
				<th>시약명</th>
				<th>사용자</th>
				<th>사용량</th>
				<th>사용일</th>
				<th>승인여부</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projectChemical}" var="projectChemical" varStatus="status">
				<tr>
					<td>${projectChemical.chemicalName}</td>
					<td>${projectChemical.name}</td>
					<td>${projectChemical.usedQty}${projectChemical.storageUnit}</td>	
					<td><fmt:formatDate value="${projectChemical.usedAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${projectChemical.approvalStatus}</td>
					<td><button type="button" class="pcUpdate" data-id="${projectChemical.projectChemicalId}">수정</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="openPcAdd openModal">
	<div class="pcAddModal modalBody">
		<form action="/project/pcAdd" method="post">
		<h2>시약 추가</h2>
		<input type="hidden" id="projectId" name="projectId" value="${param.projectId}" />
		<div>
		<label>시약명</label>
		<select name="pcChemicalId">
			<c:forEach items="${chemicalList}" var="chemical">
				<option value="${chemical.chemicalId}">${chemical.chemicalName}</option>
			</c:forEach>
		</select>
		</div>
		<div>
		<label>사용자</label>
		<select name="userId">
			<c:forEach items="${projectUserList}" var="pcUser">
				<option value="${pcUser.userUserId}">${pcUser.name}</option>
			</c:forEach>
		</select>
		</div>
		<div>사용량 : <input type="number" name="usedQty" value="1" required></div>
			<button type=submit>시약 추가</button>
			<button type="button" class="closePcAdd closeModal">닫기</button>
		</form>
	</div>
</div>
<script>
	$(".pcUpdate").click(function() {
		const pcId = $(this).data("id")
		console.log(pcId)
	})
	
	$(".showPcAdd").click(function() {
		$(".openPcAdd").css("display", "flex");
	});

	$(".closePcAdd").click(function() {
		$(".openPcAdd").css("display", "none");
	});

	$(".openPcAdd").click(function(e) {
		if (e.target === this) {
			$(this).hide();
		}
	});
</script>