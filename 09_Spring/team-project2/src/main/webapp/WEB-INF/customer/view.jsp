<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Content</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin-srigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="../../resource/css/layout.css">
<link rel="stylesheet" href="../../resource/css/user.css">

<style>
	body {
		padding-top: 100px;
	}
</style>
</head>

<body>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../side.jsp"></jsp:include>

	<div class="container">
		<h2>게시물 정보</h2>
	
		<form action="/customer/update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			<input type="hidden" name="url" value="${board.url}">
		<div class="form-group">
			<label>제목</label>
			<input class="form-control" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" name="content">${board.content}</textarea>
		</div>
		<!-- 
			수정 시 file이 있다면 기존 파일은 삭제하고 새로 추가된 파일로 업로드하고 DB 수정
			(파일 삭제 : File 객체의 delete() 메서드 사용) 
		 -->
		<img src="http://192.168.0.20:8081/${board.url}" width="500px"/>
		<div class="form-group">
			<label>파일을 첨부해주세요</label>
			<input class="form-control" name="file" type="file">
		</div>
		
		<button id="updateBoard" type="submit" class="btn btn-warning mt-3">수정</button>
		<a href="/download?url=${board.url}" class="btn btn-danger mt-3">다운로드</a>
		<button class="btn btn-secondary mt-3"><a href="/customer/board">리스트로</a></button>
		
		</form>
	</div>
	
</body>
</html>