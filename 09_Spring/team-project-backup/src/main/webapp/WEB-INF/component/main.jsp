<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.dashboard {
	display: flex;
	background: lightgrey;
	flex-wrap: wrap;
	padding-top: 25px;
	padding-bottom: 25px;
	gap: 25px;
	justify-content: center;
}
.dashboard div {
	border: 1px solid grey;
	height: 500px;
	width: 45%;
	padding: 15px;
	box-shadow: 2px 2px 5px #888888;
}

	
</style>

<section>
<!-- <img src="${pageContext.request.contextPath}/resources/static/signature.png" width="10px">  -->

<div class="dashboard">
	<div class="project-list">프로젝트<jsp:include page="${summary1}" /></div>
	<div class="sche-list">일정<jsp:include page="${summary2}" /></div>
	<div class="customer-list">고객<jsp:include page="${summary3}" /></div>
	<div class="graph">자료<jsp:include page="${summary4}" /></div>
</div>

</section>