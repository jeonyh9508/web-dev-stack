<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
    <meta charset="UTF-8" />
    <title>Chemical</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="../../resource/css/layout.css">
	<link rel="stylesheet" href="../../resource/css/chemical.css">
	<meta charset="UTF-8">
	</head>
	<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../side.jsp"></jsp:include>
  	<h2>시약/보관소 관리</h2>
	<div class="header">
		<div class="left">
			<form action="/chemical/list" method="get">
				<select name="select">
					<option value="name">시약명</option>
					<option value="cas_no">CAS번호</option>
				</select>
				<input type="text" name="search" />
				<input type="submit" value="검색" />
				<input type="hidden" name="storageId" value="${param.storageId}"/>
			</form>
			<button id ="filter-open">필터링</button>
			<a href="/chemical/list"><button>초기화</button></a>
			<a href="/chemical/stock"><button>시약 재고 현황</button></a>
			<a href="/chemical/request?userId=${sessionScope.userId == null ? 7 : sessionScope.userId}"><button>시약 승인 요청</button></a>
			<a href="/chemical/request"><button>시약 승인 현황</button></a>
		</div>
		<!--
		<div class="right">
			<select name="offset">
				<option value="10">10개씩 보기</option>
				<option value="20">20개씩 보기</option>
				<option value="50">50개씩 보기</option>
				<option value="100">100개씩 보기</option>
			</select>
		</div>
		-->
	</div>
	<form id="tableForm">
		<table border="1">
		<tr>
			<th>
				시약 ID
				<button id="sortId">
				  <span id="arrowIcon" class="up-arrow">▲<span>
				</button>
			</th>
			<th>시약명</th>
			<th>CAS 번호</th>
			<th>보관 단위</th>
			<th>보관소</th>
			<th>현재 재고 수량</th>
			<th colspan="2">경고 기준 재고 수량</th>
			<th>등록일</th>
			<th>수정</th>
			<th>삭제 <input type="checkbox" id="deleteAll" /></th>
		</tr>
		<c:forEach items="${list}" var="chemical">
			<tr>
				<td>${chemical.chemicalId}</td>
				<td>${chemical.chemicalName}</td>
				<td>${chemical.casNo}</td>
				<td>${chemical.storageUnit}</td>
				<td>${chemical.storageName}</td>
				<td class="stockQtyValue">${chemical.stockQty}</td>
				<td class="thresholdQtyValue">${chemical.thresholdQty}</td>
				<td class="stockStatus"></td>
				<td>${chemical.createdAt}</td>
				<td><button class="modifyChem" 
					 data-id="${chemical.chemicalId}" 
					 data-name="${chemical.chemicalName}" 
					 data-stock="${chemical.stockQty}"
					 data-casno="${chemical.casNo}">수정</button></td>
				<td><input type="checkbox" class="chemCheckBox" name="chemList" value="${chemical.chemicalId}" /></td>
			</tr>
		</c:forEach>
		</table>
	</form>
	<div class="footer-button">
		<button id ="add-open">추가</button>
		<button id ="deleteChem">삭제</button>
	</div>
	
	<div class="filter-modal-bg" >
		<div class="filter-modal">
			<button id="filter-close">X</button>
			<h3>필터링</h3>
			<form action="/chemical/add" method="post">
				<table>
					<td><input type="checkbox" id="all" name="all" /> 전체선택</td>
					<td><input type="checkbox" id="all" name="all" /> 전체선택</td>
					<input type="submit" value="필터" />
					<input type="reset" value="취소" />
				</table>
			</form>
		</div>
	</div>
	
	<div class="add-modal-bg" >
		<div class="add-modal">
			<button id="add-close">X</button>
			<h3>시약 추가</h3>
			<form action="/chemical/manage" method="post">
				<input type="hidden" name="type" value="add" />
				시약명: <input type="text" name="chemicalName" /><br />
				CAS 번호: <input type="text" name="CasNo" /><br />
				보관 단위: <input type="text" name="storageUnit" /><br />
				보관 위치: 
				<select name="storageName">
					<c:forEach items="${StorageNameList}" var="storage">
						<option value="${storage}">${storage}</option>
					</c:forEach>
				</select><br />
				재고 수량: <input type="text" name="stockQty" /><br />
				경고 기준 재고 수량: <input type="text" name="thresholdQty" /><br />
				<input type="submit" value="추가" />
				<input type="reset" value="취소" />
			</form>
		</div>
	</div>
	
	<div class="modify-modal-bg">
	  <div class="modify-modal">
	    <button id="modify-close">X</button>
	    <h3>시약 수량 변경</h3>
	    <form action="/chemical/manage" method="post">
			<input type="hidden" id="chemicalId" name="chemicalId" />
			<input type="hidden" name="type" value="modify" />
	        제품명: <span id="chemicalName"></span><br />
	        현재 보유 수량: <span id="stockQty"></span> > 변경: <input type="number" id="modifyStock" name="stockQty" /><br />
	        <input type="submit" value="변경" /><br />
	    </form>
	  </div>
	</div>
	
	<c:choose>
		<c:when test="${not empty param.storageId}">
			<nav>
				<ul class="pagination">
					<li class="page-item ${paging.prev ? '' : 'disabled'}"><a class="page-link" href="/chemical/list?page=${paging.startPage - 1}&search=${param.search}&select=${param.select}&storageId=${param.storageId}">이전</a></li>
								
					<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
						<li class="page-item"><a class="page-link ${paging.page == page ? 'active' : ''}" href="/chemical/list?page=${page}&search=${param.search}&select=${param.select}&storageId=${param.storageId}">${page}</a></li>
					</c:forEach>
								
					<li class="page-item ${paging.next ? '' : 'disabled'}"><a class="page-link" href="/chemical/list?page=${paging.endPage + 1}&search=${param.search}&select=${param.select}&storageId=${param.storageId}">다음</a></li>
				</ul>
			</nav>
		</c:when>
		
		<c:otherwise>
			<nav>
				<ul class="pagination">
					<li class="page-item ${paging.prev ? '' : 'disabled'}"><a class="page-link" href="/chemical/list?page=${paging.startPage - 1}&search=${param.search}&select=${param.select}">이전</a></li>
								
					<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
						<li class="page-item"><a class="page-link ${paging.page == page ? 'active' : ''}" href="/chemical/list?page=${page}&search=${param.search}&select=${param.select}">${page}</a></li>
					</c:forEach>
								
					<li class="page-item ${paging.next ? '' : 'disabled'}"><a class="page-link" href="/chemical/list?page=${paging.endPage + 1}&search=${param.search}&select=${param.select}">다음</a></li>
				</ul>
			</nav>
		</c:otherwise>
	</c:choose>
	
	<script>
		$(window).on('load', () => {
			const stockQtyValue = document.querySelectorAll(".stockQtyValue");
			const thresholdQtyValue = document.querySelectorAll(".thresholdQtyValue");
			const stockStatus = document.querySelectorAll(".stockStatus");
			
			for(let i=0; i<stockQtyValue.length; i++) {
				for(let j=0; j<thresholdQtyValue.length; j++) {
					if(i==j && parseInt(stockQtyValue[i].textContent) > parseInt(thresholdQtyValue[j].textContent)) {
						$(thresholdQtyValue[j]).css("backgroundColor", "rgba(144, 238, 144, 0.5)");
						stockStatus[j].textContent = '정상';
					} else if(i==j && parseInt(stockQtyValue[i].textContent) < parseInt(thresholdQtyValue[j].textContent)) {
						$(thresholdQtyValue[j]).css("backgroundColor", "rgba(255, 0, 0, 0.3)");
						stockStatus[j].textContent = '부족';
					} else if(i==j && parseInt(stockQtyValue[i].textContent) == parseInt(thresholdQtyValue[j].textContent)) {
						$(thresholdQtyValue[j]).css("backgroundColor", "rgba(255, 255, 153, 0.3)");
						stockStatus[j].textContent = '임박';
					}
				}
			}
		});
		
		const chemCheckBox = document.querySelectorAll(".chemCheckBox");
		const chemDeleteAll = document.querySelector("#deleteAll");
		chemDeleteAll.addEventListener("click", () => {
			if(chemDeleteAll.checked) {
				for(const checkBox of chemCheckBox) {
					checkBox.checked = true;
				}
			} else {
				for(const checkBox of chemCheckBox) {
					checkBox.checked = false;
				}
			}
		});
		
		$("#add-open").click((e) => {
			e.preventDefault();
			$(".add-modal-bg").css("display", "flex");
		});
		$("#add-close").click(() => {
			$(".add-modal-bg").css("display", "none");
		});
		$(".add-modal-bg").click((e) => {
			if (e.target === e.currentTarget) {
				$(".add-modal-bg").css("display", "none");
			}
		});

		$(".modifyChem").click((e) => {
			e.preventDefault();
			const id = $(e.currentTarget).data("id");
			const name = $(e.currentTarget).data("name");
			const stock = $(e.currentTarget).data("stock");
			const casNo = $(e.currentTarget).data("casno");
			$("#chemicalId").val(id);
			$("#chemicalName").text(name);
			$("#casNo").text(casNo);
			$(".modify-modal-bg").css("display", "flex");
		});
		$("#modify-close").click(() => {
			$(".modify-modal-bg").css("display", "none");
		});
		$(".modify-modal-bg").click((e) => {
			if (e.target === e.currentTarget) {
				$(".modify-modal-bg").css("display", "none");
			}
		});

		$("#deleteChem").click((e) => {
			e.preventDefault();
			if (confirm("선택한 항목을 삭제하시겠습니까?")) {
				$.ajax({
					type: "post",
					url: "/chemical/delete",
					data: $("#tableForm").serialize()
				});
			};
		});
		
		$("#filter-open").click(() => {
			$(".filter-modal-bg").css("display", "flex");
		});
		$("#filter-close").click(() => {
			$(".filter-modal-bg").css("display", "none");
		});
		$(".filter-modal-bg").click((e) => {
			if (e.target === e.currentTarget) {
				$(".filter-modal-bg").css("display", "none");
			}
		});
		
	</script>
  </body>
</html>
