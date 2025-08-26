<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<%--@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"--%>

<style>
.company a {
    text-decoration: none;  /* 밑줄 제거 */
    color: inherit;         /* 부모 요소의 색상을 상속받음 */
}
</style>

<header>
	<h1 class="company"><a id="logo" href="/">Häagen-Dazo</a></h1>
		<form action="/project/searchBar" method="get" class="header-search">
		<input type="text" id="search" name="search" placeholder="검색을 원하시는 프로젝트를 입력해주세요.">
		<button type="submit">검색</button>
		</form>
		<div class="header-links">
		<p><a href="/admin">어드민</a></p>
		<p><a href="/login">로그인</a></p>
		<p><a href="/register">계정등록</a></p>
		<p><a href="/user">회원목록</a></p>
		<div>
			<a href="/mypage" class="user-name">
				<span id="userName">
				<!-- <sec:authentication property="principal.name" /> -->
				</span>님 안녕하세요
				<div class="role-tooltip">
				</div>
			</a>
		</div>
	</div>
</header>

<script>
//$(document).ready(function() {
//    $('.user-name').hover(
//        function() {
//            // 마우스가 올라갔을 때
//            const role = $(this).data('role');
//            if (role) {
//                // 툴팁 생성
//                const tooltip = $('<div>').addClass('role-tooltip').text(role);
//                $(this).append(tooltip);
//                tooltip.fadeIn(200);
//            }
//        },
//        function() {
//            // 마우스가 벗어났을 때
//            $(this).find('.role-tooltip').fadeOut(200, function() {
//                $(this).remove(); // 애니메이션 후 툴팁 제거
//            });
//       }
//    );
//});
</script>