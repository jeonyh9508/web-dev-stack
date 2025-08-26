<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<h1>참여자 목록</h1>
	<button type="button" class="showMemberInsertModal showModal">참여자 등록</button>
	<form action="/project/memberDelete" method="post">
		<input type="hidden" name="projectId" value="${project.projectId}" />
		<c:forEach items="${projectMember}" var="projectMember"
			varStatus="status">
			<p>${projectMember.memberRole}:${projectMember.name}
				<input type="checkbox" class="idList" name="idList"
					value="${projectMember.memberId}">
			</p>
		</c:forEach>
		<button type="submit" id="memberDelete">참여자 제거</button>
	</form>
</div>

<div class="openMemberInsertModal openModal">
	<div class="memberInsertModalBody ModalBody">
		<form action="/project/memberInsert" method="post">
			<h1>참여자 등록</h1>
			<input type="hidden" name="projectId" value="${project.projectId}" />
			<label>참여자</label> 

			<c:set var="manager" value="${false}" />
			<c:forEach var="pm" items="${projectMember}">
				<c:if test="${not empty pm.memberRole and pm.memberRole eq '담당자'}">
					<c:set var="manager" value="${true}" />
				</c:if>
			</c:forEach>

			<select name="memberRole" required>
				<option value="" disabled selected>선택해라</option>
				<c:choose>
					<c:when test="${manager}">
						<option value="연구원">연구원</option>
					</c:when>
					<c:otherwise>
						<option value="담당자">담당자</option>
					</c:otherwise>
				</c:choose>
			</select>
			
			<select name="memberUserId" required>
			
				<option value="" disabled selected>선택해라</option>
				
				<c:forEach items="${projectUser}" var="user">
				
					<c:set var="sign" value="false" />
						<c:forEach items="${projectMember}" var="pm">
							<c:if test="${pm.memberUserId eq user.userUserId}">
								<c:set var="sign" value="true" />
							</c:if>
						</c:forEach>
					<c:if test="${!sign}">
						<option value="${user.userUserId}">${user.name}</option>
					</c:if>
					
				</c:forEach>
			</select>
			<button type="submit" id="checkmem">참여자 등록</button>
			<button class="closeMemberInsertModal closeModal">닫기</button>
		</form>
	</div>
</div>

<script>
	$("#chechmem").click(()=>{
		console.log
	})


	$(".showMemberInsertModal").click(function() {
	    $(".openMemberInsertModal").css("display","flex");
	});
	
	$(".closeMemberInsertModal").click(function() {
	    $(".openMemberInsertModal").css("display","none");
	});
	
	$(".openMemberInsertModal").click(function(e){
	    if(e.target === this){
	        $(this).hide();
	    }
	});
	
	$("#memberDelete").prop("disabled", $(".idList:checked").length === 0);
	
	$(".idList").change(()=>{
		let check = $(".idList:checked").length;
		$("#memberDelete").prop("disabled", check === 0);
	});
	
	function deleteManager() {
	    var researcher= false;
        $('.idList').each(function() {
        	if($(this).parent().text().includes('연구원')) researcher = true;
    	});
        $('.idList').each(function() {
	        if($(this).parent().text().includes('담당자')) $(this).prop('disabled', researcher);
	    });
	    }

		deleteManager(); // 초기 상태
	    $('.idList').change(deleteManager); // 체크박스 바뀔 때마다
</script>