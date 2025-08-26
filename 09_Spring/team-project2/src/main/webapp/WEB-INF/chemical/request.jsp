<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8" />
	    <title>Request</title>
	    <link rel="stylesheet" href="../../resource/css/layout.css">
		<link rel="stylesheet" href="../../resource/css/chemical.css">
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	</head>
	
	<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../side.jsp"></jsp:include>

	<h2>시약 승인</h2>
	<form id="approvalChemicalFrm">
		<table id="chemicalApprovalTable">
			<tr>
				<td><span>프로젝트 선택: </span></td>
				<td colspan="2">
					<select id="selectProject" name="projectId" style="min-width:150px;">
						<option value="" disabled selected>프로젝트 선택</option>
						<c:forEach items="${projectsOfUser}" var="project">
							<option value="${project.projectId}">${project.projectName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<span>시약 선택: </span>
				</td>
				<td id="selectedChemical"></td>
				<td><button type="button" id="searchChemical-open">검색</button></td>
			</tr>
			<tr>
				<td>
					<span>시약 재고 수량: </span>
				</td>
				<td id="stockOfChemical"></td>
				<td class="storageUnitOfChemical"></td>
			</tr>
			<tr>
				<td>
					<span>경고 기준 재고 수량: </span>
				</td>
				<td id="thresholdQtyOfChemical"></td>
				<td class="storageUnitOfChemical"></td>
			</tr>
			<tr>
				<td>
					<span>시약 사용량: </span>
				</td>
				<td colspan="2"><input type="number" id="AmountOfChemicalForUse" name="stockQty" /></td>
			</tr>
			<tr>
				<td>
					<span>사용 일자: </span>
				</td>
				<td colspan="2"><input type="date" value="<fmt:formatDate value='' />" /></td>
			</tr>
			<tr>
				<td>
					<span>비고: </span>
				</td>
				<td colspan="2"><textarea id="comment" name="comment" rows="4" cols="50">비고 사항을 입력하세요.</textarea></td>
			</tr>
		</table>

		<div class="searchChemical-modal-bg" >
			<div class="searchChemical-modal">
				<button id="searchChemical-close">X</button>
				<h3>시약 선택</h3>
				<select name="select">
					<option value="name">시약명</option>
					<option value="cas_no">CAS번호</option>
				</select>
				<input type="text" name="search" placeholder="아직 기능 안 들어감(08/21~)" />
				<input type="submit" value="검색"/>
				
				<div id="chemTableWindow"></div>
				<button id="selectChemical">선택</button>
			</div>
		</div>

		<button id="requestBtn">요청</button>
		<button type="reset">취소</button>
	</form>
	
	<script>
		$("#searchChemical-open").click((e) => {
			e.preventDefault();
			$(".searchChemical-modal-bg").css("display", "flex");
		});
		$("#searchChemical-close").click((e) => {
			e.preventDefault();
			$(".searchChemical-modal-bg").css("display", "none");
		});
		$(".searchChemical-modal-bg").click((e) => {
			if (e.target === e.currentTarget) {
				$(".searchChemical-modal-bg").css("display", "none");
			}
		});
	
		$("#selectProject").change(() => {
			const userId = ${userId};
			
			$.ajax({
				type: 'get',
				url: '/getChemicals',
				data: {
					projectId: $("#selectProject").val()
				},
				success: function(response) {
					let chemicals = [];
					
					for(const chemical of response) {
						chemicals.push({
							id: chemical.chemicalId,
							name: chemical.chemicalName, 
							casNo: chemical.casNo
						});
					}
					
					const chemTableWindow = document.querySelector("#chemTableWindow");
					
					const table = document.createElement('table'); // 테이블 만들기
					table.id = 'chemListTable';
					// table.border = '1'; // 테이블 css 수정 확인용
					
					chemicals.forEach(c => {
						const tr = document.createElement('tr'); // 테이블에 넣을 tr 생성
						
						const nameTd = document.createElement('td'); // name 넣을 td 생성
						nameTd.textContent = c.name;
						
						const casNoTd = document.createElement('td'); // casNo 넣을 td 생성
						casNoTd.textContent = c.casNo;

						const radioTd = document.createElement('td'); // radio 넣을 td 생성
						
						const radioInput = document.createElement('input'); // radio 생성
						radioInput.type = 'radio';
						radioInput.id = 'chemicalId';
						radioInput.name = 'chemicalId';
						radioInput.value = c.id;
						
						radioTd.appendChild(radioInput); // radioTd에 radio 넣기
						tr.appendChild(nameTd); // tr에 td들 넣기
						tr.appendChild(casNoTd);
						tr.appendChild(radioTd);
						
						table.appendChild(tr); // table에 tr 넣기
					});
					
					chemTableWindow.innerHTML = '';
					chemTableWindow.appendChild(table);
				}
			});
		});
		
		$("#selectChemical").click((e) => {
			e.preventDefault();
			$.ajax({
				type: 'get',
				url: '/getStockOfChemical',
				data: $("#approvalChemicalFrm").serialize(),
				success: function(response) {
					console.log(response.chemicalName);
					const chemical = document.querySelector("#selectedChemical");
					const stock = document.querySelector("#stockOfChemical");
					const thresholdQty = document.querySelector("#thresholdQtyOfChemical");
					const storageUnit = document.querySelectorAll(".storageUnitOfChemical");
					
					chemical.textContent = response.chemicalName;
					stock.textContent = response.stockQty;
					thresholdQty.textContent = response.thresholdQty;
					storageUnit[0].textContent = response.storageUnit;
					storageUnit[1].textContent = response.storageUnit;
				}
			});
			$(".searchChemical-modal-bg").css("display", "none");
		});
		
	</script>
  </body>
</html>
