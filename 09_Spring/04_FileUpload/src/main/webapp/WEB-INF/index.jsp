<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>

	<!-- list.jsp -->
	<a href="/list">게시판 글 목록</a>

	<h2>File Upload Test</h2>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="submit" value="파일 업로드">
	</form>
	
	<h2>Multi File Upload Test</h2>
	<form action="multiUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple accept="image/*"><br>
		<input type="submit" value="파일 업로드">
	</form>
	
	<button id="open">모달 열기</button>
	<div class="modal-bg">
		<div class="modal">
			<button id="close">X</button>
			<h3>파일 업로드</h3>
			<form action="/upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file"><br>
		<input type="submit" value="파일 업로드">
		</div>
	</div>
	
	<style>
		.modal-bg{
			position: fixed;
			top :0; 
			left:0; 
			right:0; 
			bottom:0;
			background: rgba(0,0,0,0.3);
			z-index: 1000;
			justify-content: center;
			align-items: center;
			display : none;
		}
		.modal{
			background: white;
			position: relative;
			width: 350px;
			padding: 20px
		}
		.modal #close {
			position: absolute;	
			top: 10px; right : 10px;
			cursor: pointer;
			font-size: 10px;
			border: none;
			background: none;
		}
	</style>
	<script>
		$('#open').click(()=>{
			$('.modal-bg').css('display','flex');
		});
		
		$('#close').click(()=>{
			$('.modal-bg').css('display','none');
		});

		$('.modal-bg').click((e)=>{
			/*
			console.log(e.target);
			console.log(e.currentTarget);
			*/
			if(e.target === e.currentTarget){
			$('.modal-bg').css('display','none');
			}
		})
	
	</script>
</body>
</html>
