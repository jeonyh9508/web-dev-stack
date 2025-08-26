<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ERP</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="../../resource/css/layout.css">
  <meta charset="UTF-8">
  </head>
  <body>
  	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../side.jsp"></jsp:include>
  <h1>프로젝트 추가</h1>
	<form action="/project/insert" method="post">
		<p>	코드 : <input type="text" name="projectCode" id="projectCode"> </p>
		<p id ="checkCode"></p>
		<p> 프로젝트명 : <input type="text" name="projectName" id="projectName"> </p>
		<p id = "checkName"></p>
		<p>	타입 : <input type="text" name="projectType" id="projectType"> </p>
		<p>	진행상태 : 
			<select name="status" id="status">
				<option value="계획중">계획중</option>
				<option value="진행중">진행중</option>
				<option value="완료">완료</option>
			</select>
        </p>
		<p>	시작일 : <input type="date" name="startDate" id="startDate">	</p>
		<p>	종료일 : <input type="date" name="endDate" id="endDate"> </p>
		<p id="checkDate"></p>
		<p>	내 용 : <textarea name="description" id="description" placeholder="선택 입력 사항입니다."></textarea></p>
		<button type="submit" id="projectInsert">추가</button>
		<button type="button" id="reload">초기화</button>
		<button type="button" id="listPage">목록으로 돌아가기</button>	
	</form>
	<script>
		
		let checkCode = true;
		let checkName = true;
		let checkDate = true;
		
		 $("#projectInsert").prop("disabled", true);
		 
		function checkAll() {
			if(checkCode === false && checkName === false && checkDate === false){
				$("#projectInsert").prop("disabled", false);
			} else {
				$("#projectInsert").prop("disabled", true);
			};
		};
		
		$("#reload").click(()=>{
			location.reload();
		})

		
		$("#projectCode").keyup(function() {
			const projectCode = $(this).val();
			
		   if (projectCode === undefined || projectCode.trim() === "") {
		        $("#checkCode").text("필수 입력 값입니다.").css("color","black");
		        checkCode = true;
		        return; 
		    }
			
		    $.ajax({
		        url: "/project/checkCode", // 중복 체크를 위한 요청 URL
		        type: "get",
		        data: { projectCode: projectCode },
		        success: function(result) {
		            if (result === "fail") {
		                $("#checkCode").text("중복된 코드입니다.").css("color", "red");
		                checkCode = true;
		            } else if (result === "success") {
		                $("#checkCode").text("사용 가능한 코드입니다.").css("color", "green");
		                checkCode = false;
		            }
		        },
		    });
		    checkAll();
		});
		
	
		$("#projectName").keyup(function() {
		    const projectName = $(this).val().trim(); // 공백 제거
				
		    if (projectName === "" || projectName == undefined ) {
		        $("#checkName").text("필수 입력 값입니다.").css("color", "black");
		        checkName = true;
		    } else {
				$("#checkName").text("");
				checkName = false;
		    }
		    checkAll();
		});
		
		
		
		$(document).ready(function() {
		    // 오늘 날짜 구해서 min 설정
		    const todayStr = new Date().toISOString().split('T')[0];
		    $("#startDate").attr("min", todayStr);
		    $("#endDate").attr("min", todayStr);
		    // 시작일, 종료일 체크
		    $("#startDate, #endDate").change(function() {
		        const start = $("#startDate").val();
		        const end = $("#endDate").val();

		        if (!start) {
		            checkDate = true;
		            $("#checkDate").text("");
		        } else if (start < todayStr) {
		            $("#checkDate").text("금일 기준 이후로 입력해주세요.").css("color", "red");
		            checkDate = true;
		        } else if (!end) {
		            // 종료일 미입력 → 버튼 비활성
		            checkDate = true;
		            $("#checkDate").text("");
		        } else if (start >= end) {
		            // 종료일보다 시작일이 이후
		            $("#checkDate").text("종료일은 시작일 이후로 지정해주세요.").css("color", "red");
		            checkDate = true;
		        } else {
		            $("#checkDate").text("");
		            checkDate = false;
		        }
		        checkAll();
		    });
		});
		
		$("#listPage").click((e)=>{
			location.href = "/project/list"
		})
		
	</script>
  </body>
</html>
