<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<style>
  /* CSS 추가 */
  .submenu {
    max-height: 200; /* 기본적으로 서브메뉴 숨김 */
    overflow: hidden; /* 내용이 넘치면 숨김 */
    transition: max-height 0.3s ease-out; /* 부드러운 전환 효과 */
  }

  /* .open 클래스가 추가되면 서브메뉴를 보이게 함 */
  .menu-group.open .submenu {
    max-height: 200px; /* 충분히 큰 값으로 설정하여 모든 내용이 보이게 함 */
  }

  /* 현재 활성화된 메뉴 타이틀 스타일 (선택 사항) */
  .menu-title.active {
    font-weight: bold;
    color: #97dde9cc; /* 강조 색상 */
  }

  /* 현재 활성화된 서브메뉴 링크 스타일 (선택 사항) */
  .submenu a.active {
    background-color: #e9ecef; /* 활성화된 링크 배경색 */
    color: #0056b3; /* 활성화된 링크 텍스트 색상 */
  }
</style>

<div class="side">
  <h1 class="logo">
    <a id="logo" href="/"></a>
  </h1>
  <nav>
    <div class="menu-group">
      <div class="menu-title">프로젝트 관리</div>
      <div class="submenu">
        <a href="/project">프로젝트 목록</a>
        <a href="/rnd">임상/시험/연구개발</a>
        <!-- 단계별 -->
        <a href="/chem">시약 관리</a>
        <a href="/budget">예산 관리</a>
        <!-- 우선순위 낮음 -->
      </div>
    </div>
    <div class="menu-group">
      <div class="menu-title">일정 관리</div>
      <div class="submenu">
        <a href="/schedule">일정 목록</a>
        <a href="/calendar">스케쥴 관리 (캘린더)</a>
      </div>
    </div>
    <div class="menu-group">
      <div class="menu-title">고객 관리</div>
      <div class="submenu">
        <a href="/customer">고객 목록</a>
        <a href="#">클레임 처리</a>
      </div>
    </div>
  </nav>
</div>

<script>
  document.addEventListener("DOMContentLoaded", () => {
    const menuGroups = document.querySelectorAll(".menu-group");
    const currentPath = window.location.pathname; // 현재 페이지의 경로

    // 세션 스토리지에서 열려있던 메뉴 그룹 ID 배열 가져오기
    const openedGroups = JSON.parse(sessionStorage.getItem('openedMenuGroups')) || [];

    menuGroups.forEach((group) => {
      const menuTitle = group.querySelector(".menu-title");
      const submenu = group.querySelector(".submenu");
      const submenuLinks = submenu.querySelectorAll("a");
      const groupId = group.dataset.groupId; // 각 메뉴 그룹에 고유 ID 부여

      // 1. 메뉴 타이틀 클릭 시 드롭다운 토글 및 상태 저장
      menuTitle.addEventListener("click", () => {
        group.classList.toggle("open");

        // 세션 스토리지에 열린 상태 저장 또는 제거
        if (group.classList.contains("open")) {
          if (!openedGroups.includes(groupId)) {
            openedGroups.push(groupId);
          }
        } else {
          const index = openedGroups.indexOf(groupId);
          if (index > -1) {
            openedGroups.splice(index, 1);
          }
        }
        sessionStorage.setItem('openedMenuGroups', JSON.stringify(openedGroups));
      });

      // 2. 현재 페이지에 해당하는 서브메뉴 열기 및 링크 활성화
      let shouldOpenGroup = false;
      submenuLinks.forEach((link) => {
        // 링크의 href 속성을 가져와 현재 경로와 비교
        // 현재 경로가 링크의 href로 시작하는 경우 활성 상태로 간주
        if (
          link.getAttribute("href") &&
          currentPath.startsWith(link.getAttribute("href"))
        ) {
          // 'active' 클래스를 다른 링크에서 제거하고 현재 링크에만 추가 (단일 활성 유지)
          // 먼저 모든 링크에서 'active' 클래스를 제거 (새로운 페이지 로드 시 필요)
          submenuLinks.forEach(l => l.classList.remove('active'));
          link.classList.add("active"); // 활성 링크에 'active' 클래스 추가
          shouldOpenGroup = true; // 이 링크를 포함하는 메뉴 그룹을 열어야 함
        }
      });

      // 3. 페이지 로드 시, 세션 스토리지 정보와 현재 페이지 상태를 기반으로 메뉴 열기
      if (shouldOpenGroup || openedGroups.includes(groupId)) {
        group.classList.add("open"); // 해당 메뉴 그룹 열기
        menuTitle.classList.add("active"); // 해당 메뉴 타이틀 활성화 (선택 사항)
      }
    });
  });
</script>
