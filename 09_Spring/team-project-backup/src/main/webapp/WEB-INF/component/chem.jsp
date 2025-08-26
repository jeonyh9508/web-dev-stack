<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>시약 관리</title>
    <link rel="stylesheet" href="../resources/css/reset.css" />
    <link rel="stylesheet" href="../resources/css/rnd.css" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link rel="stylesheet" href="../resources/css/chem.css" />
  </head>
  <body>
    <section class="project">
      <h1>시약 관리</h1>
      <div class="function">
        <p class="tab">검색</p>
        <form action="/search" method="get">
          <input type="text" name="keyword" />
          <select name="select">
            <option value="productName">제품명</option>
            <option value="casNo">CAS번호</option>
            <option value="hazardClass">분류</option>
          </select>
          <input type="submit" value="검색" />
        </form>
      </div>
	  <form id="manageChem">
      <table>
        <tr>
          <th>시약 ID</th>
          <th>제품명</th>
          <th>CAS 번호</th>
          <th>MSDS 링크</th>
          <th>위험물 분류</th>
          <th>현재 보유 수량</th>
		  <th>삭제 <input type="checkbox" id="deleteAll" /></th>
        </tr>
        <c:forEach items="${chemList}" var="chemical">
          <tr class="selectRow" id="row${chemical.chemicalId}">
            <td>${chemical.chemicalId}</td>
            <td>${chemical.productName}</td>
            <td>${chemical.casNo}</td>
            <td><a href="${chemical.msdsUrl}">${chemical.msdsUrl}</a></td>
            <td>${chemical.hazardClass}</td>
            <td>${chemical.stockQty}</td>
			<td><input type="checkbox" class="chemCheckBox" name="chemList" value="${chemical.chemicalId}" /></td>
          </tr>
        </c:forEach>
      </table>

      <input type="button" id="modifyChem" value="수정" />
	  <input type="button" id="deleteChem" value="삭제" />
	  </form>
	  
	<nav>
		<ul class="pagination">
			<li class="page-item ${paging.prev ? '' : 'disabled'}"><a class="page-link" href="/chem?page=${paging.startPage - 1}">Previous</a></li>
						
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
				<li class="page-item"><a class="page-link ${paging.page == page ? 'active' : ''}" href="/chem?page=${page}">${page}</a></li>
			</c:forEach>
						
			<li class="page-item ${paging.next ? '' : 'disabled'}"><a class="page-link" href="/chem?page=${paging.endPage + 1}">Next</a></li>
		</ul>
	</nav>
	  
    </section>
    <div class="modal-bg">
      <div class="modal">
        <button id="close">X</button>
        <h3>시약 수량 변경</h3>
        <form action="/chem" method="post">
          <input type="hidden" name="chemicalId" value="" /><br />
          <input type="text" name="stockQty" /><br />
          <input type="submit" value="변경" /><br />
        </form>
      </div>
    </div>
	
    <script>
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
		$("#modifyChem").click(() => {
			$.ajax({
				type: "post",
				url: "/modifyChem",
				data: $("#manageChem").serialize(),
				success: function(response) {
					
				},
			});
		});
		$("#deleteChem").click(() => {
			$.ajax({
				type: "post",
				url: "/deleteChem",
				data: $("#manageChem").serialize(),
				success: function(response) {
					
				},
			});
		});
	    $("#modifyChem").click(() => {
	        $(".modal-bg").css("display", "flex");
	    });
	    $("#close").click(() => {
	        $(".modal-bg").css("display", "none");
	    });
	    $(".modal-bg").click((e) => {
		    console.log(e.target);
		    console.log(e.currentTarget);
		    if (e.target === e.currentTarget) {
		    	$(".modal-bg").css("display", "none");
		    }
	    });
    </script>
  </body>
</html>
