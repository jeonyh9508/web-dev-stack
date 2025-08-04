<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- a링크를 통해 해당 정보만 나올 수 있도록 상세보기 -->
	<div class="container">
		<h1>게시물 정보</h1>
		<form action="/update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="no" value="${select.no}" /> <input
				type="hidden" name="url" value="${select.url}" />
			<div class="form-group">
				<label>Title</label> <input class="form-control" name="title" value="${select.title}">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" name="content">${select.content}</textarea>
			</div>
			<!-- 
				수정 시 file이 있다면 기존 파일은 삭제 하고 새로 추가된 파일로 업로드하고 DB 수정
				(파일 삭제 : File 객체의 delete() 메서드 사용)
			 -->
			<img src="http://192.168.0.35:8081/${select.url}" width="200px"/>
			<div class="form-group">
				<label>Update File</label>
				<input class="form-control" name="file" type="file" accept="image/*" />
			</div>
			<button type="submit" class="btn btn-outline-warning">수정</button>
			<a class="btn btn-outline-danger" href="/delete?no=${select.no}">삭제</a>
		</form>
	</div>
</body>
</html>