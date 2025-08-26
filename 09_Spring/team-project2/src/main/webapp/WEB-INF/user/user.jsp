<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../resource/css/layout.css">
	<link rel="stylesheet" href="../../resource/css/user.css">
	
<style>
	/* 정렬 기능이 있는 컬럼 헤더의 배경색 변경 */
	table th:nth-child(2), /* 이름 */
	table th:nth-child(4), /* 가입일 */
	table th:nth-child(6), /* 부서 */
	table th:nth-child(7)  /* 직급(권한) */
	{
	    background-color: rgba(255, 255, 255, 0.6);
	}
	
	table td input {
		background: transparent;
	}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../side.jsp"></jsp:include>

    <h1>UserInfo Page</h1>

    <sec:authorize access="isAnonymous()">
        <div class="auth-links">
            <a href="/register">계정등록</a>
            <a href="/login">로그인</a>
            <a href="/">홈으로</a>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div class="auth-links">
            <a href="/logout">로그아웃</a>
            <a href="/mypage">마이 페이지</a>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
            <a href="/admin">관리자 페이지</a>
        </div>
    </sec:authorize>

    <form action="/user" method="get" class="search-form">
        <select name="select">
            <option value="name" ${param.select eq 'name' ? 'selected' : ''}>이름</option>
            <option value="email" ${param.select eq 'email' ? 'selected' : ''}>아이디(이메일)</option>
            <option value="gradeName" ${param.select eq 'gradeName' ? 'selected' : ''}>직급명</option>
            <option value="deptName" ${param.select eq 'deptName' ? 'selected' : ''}>부서명</option>
        </select>
        <input type="text" name="search" value="${param.search}">
        <input type="submit" value="검색">
    </form>

    <h3>[회원목록]</h3>
    <p id="count">
        <a href="/admin">
            (관리자 전용) 등록된 사원: ${count1} 명 / 등록된 관리자: ${count2} 명
        </a>
    </p>
    
    <form>
        <table>
            <thead>
    <tr>
        <th>번호</th>
        <th>
            <a href="?page=1&select=${param.select}&search=${param.search}&orderBy=name&orderDirection=${param.orderBy eq 'name' and param.orderDirection eq 'ASC' ? 'DESC' : 'ASC'}">
                이름
                <c:if test="${param.orderBy eq 'name' and param.orderDirection eq 'ASC'}"><span class="upArrow">▲</span></c:if>
                <c:if test="${param.orderBy eq 'name' and param.orderDirection eq 'DESC'}"><span class="downArrow">▼</span></c:if>
            </a>
        </th>
        <th>아이디</th>
        <th>
            <a href="?page=1&select=${param.select}&search=${param.search}&orderBy=createdAt&orderDirection=${param.orderBy eq 'createdAt' and param.orderDirection eq 'ASC' ? 'DESC' : 'ASC'}">
                가입일
                <c:if test="${param.orderBy eq 'createdAt' and param.orderDirection eq 'ASC'}"><span class="upArrow">▲</span></c:if>
                <c:if test="${param.orderBy eq 'createdAt' and param.orderDirection eq 'DESC'}"><span class="downArrow">▼</span></c:if>
            </a>
        </th>
        <th>비밀번호</th>
        <th>
            <a href="?page=1&select=${param.select}&search=${param.search}&orderBy=deptId&orderDirection=${param.orderBy eq 'deptId' and param.orderDirection eq 'ASC' ? 'DESC' : 'ASC'}">
                부서
                <c:if test="${param.orderBy eq 'deptId' and param.orderDirection eq 'ASC'}"><span class="upArrow">▲</span></c:if>
                <c:if test="${param.orderBy eq 'deptId' and param.orderDirection eq 'DESC'}"><span class="downArrow">▼</span></c:if>
            </a>
        </th>
        <th>
            <a href="?page=1&select=${param.select}&search=${param.search}&orderBy=gradeId&orderDirection=${param.orderBy eq 'gradeId' and param.orderDirection eq 'ASC' ? 'DESC' : 'ASC'}">
                직급(권한)
                <c:if test="${param.orderBy eq 'gradeId' and param.orderDirection eq 'ASC'}"><span class="upArrow">▲</span></c:if>
                <c:if test="${param.orderBy eq 'gradeId' and param.orderDirection eq 'DESC'}"><span class="downArrow">▼</span></c:if>
            </a>
        </th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
</thead>
            <tbody>
                <c:forEach items="${list}" var="user" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <input type="hidden" class="user-id" value="${user.userId}">
                        <td>${user.name}</td>
                        <td><input type="text" class="user-email" value="${user.email}"></td>
				        <td>
				        <fmt:formatDate value="${user.createdAt}" pattern="yyyy-MM-dd" /> 가입
                        </td>
                        <td><input type="text" class="user-password" value="${user.password}"></td>
                        <td>
                            <input type="text" class="user-deptId" value="${user.deptId}">
                            <span>${user.deptName}</span>
                        </td>
                        <td>
                            <input type="text" class="user-gradeId" value="${user.gradeId}">
                            <span>${user.gradeName} (${user.role})</span>
                        </td>
                        <td>
                            <button type="button" class="updateBtn" data-userid="${user.userId}">edit</button>
                        </td>
                        <td>
                            <button type="button" class="deleteModal" data-userid="${user.userId}">X</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>

    <div class="openModal">
        <div class="modalBody">
            <h2><u>정말 삭제하시겠습니까?</u></h2>
            <button type="button" id="deleteBtn">삭제</button>
            <button type="button" class="closeModal">취소</button>
        </div>
    </div>
    
    <nav aria-label="Page navigation">
    <ul class="pagination">
        <li class="page-item ${paging.prev ? '' : 'disabled'}">
            <c:url var="prevLink" value="/user">
                <c:param name="page" value="${paging.startPage - 1}"/>
                <c:param name="search" value="${param.search}"/>
                <c:param name="select" value="${param.select}"/>
                <c:param name="orderBy" value="${param.orderBy}"/>
                <c:param name="orderDirection" value="${param.orderDirection}"/>
            </c:url>
            <a class="page-link" href="${prevLink}" aria-label="Previous">이전</a>
        </li>
        <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="page">
            <li class="page-item ${paging.page == page ? 'active' : ''}">
                <c:url var="pageLink" value="/user">
                    <c:param name="page" value="${page}"/>
                    <c:param name="search" value="${param.search}"/>
                    <c:param name="select" value="${param.select}"/>
                    <c:param name="orderBy" value="${param.orderBy}"/>
                    <c:param name="orderDirection" value="${param.orderDirection}"/>
                </c:url>
                <a class="page-link" href="${pageLink}">${page}</a>
            </li>
        </c:forEach>
        <li class="page-item ${paging.next ? '' : 'disabled'}">
            <c:url var="nextLink" value="/user">
                <c:param name="page" value="${paging.endPage + 1}"/>
                <c:param name="search" value="${param.search}"/>
                <c:param name="select" value="${param.select}"/>
                <c:param name="orderBy" value="${param.orderBy}"/>
                <c:param name="orderDirection" value="${param.orderDirection}"/>
            </c:url>
            <a class="page-link" href="${nextLink}" aria-label="Next">다음</a>
        </li>
    </ul>
</nav>
    
    <script>
        // 모달 열기
        $(".deleteModal").click(function() {
            $(".openModal").css("display","flex");
            const userId = $(this).data("userid");
            // 모달 내의 '삭제' 버튼에 userId를 저장합니다.
            $("#deleteBtn").data("userid", userId);
            console.log("모달 열기 - userId:", userId);
        });

        // 모달 닫기
        $(".closeModal").click(function() {
            $(".openModal").css("display","none");
        });
        
        // '삭제' 버튼 클릭 이벤트 (모달 내 버튼)
        $('#deleteBtn').click(function(e) {
            e.preventDefault();
            const userId = $(this).data("userid");
            console.log("삭제 버튼 클릭 - userId:", userId);

            if (userId) {
                $.ajax({
                    type: "post",
                    url: "/user/delete",
                    data: { userId: userId },
                    success: function(result){
                        alert("삭제가 완료되었습니다!");
                        location.reload();
                    },
                    error: function(xhr, status, error) {
                        alert("처리 중 오류가 발생하였습니다.");
                    }
                });
            } else {
                alert("사용자 정보를 찾을 수 없습니다.");
            }
        });

        // 유저 정보 수정 AJAX
        $('.updateBtn').click(function(e) {
            e.preventDefault();
            const row = $(this).closest('tr');
            
            const updateData = {
                userId: $(this).data('userid'),
                email: row.find('.user-email').val(),
                password: row.find('.user-password').val(),
                deptId: row.find('.user-deptId').val(),
                gradeId: row.find('.user-gradeId').val()
            };

            $.ajax({
                type: "post",
                url: "/user/update",
                data: updateData,
                success: function(result){
                    alert("수정이 완료되었습니다!");
                    location.reload();
                },
                error: function(xhr, status, error) {
                    alert("처리 중 오류가 발생하였습니다.");
                }
            });
        });
    </script>
</body>
</html>