<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div class="side">
  <h1 class="logo">
    <a id="logo" href="/"></a>
  </h1>
  <nav>
  
  <%--
  	일반적인 메뉴는 CRUD 기능 기반하며,
  	최초 노출되는 페이지는 SELECT ALL 형태에 따른다.
  	키워드 검색 및 조건 필터링 , 각 컬럼별 정렬 기능 포함 (리사이즈 기능, 일부 잠금)
  	
  	기본 기능 외 추가적인 기능의 경우,
  	개별 문서에서 서술한다. 
  --%>
  
  
    <div class="menu-group">
      <div class="menu-title">프로젝트 관리</div>
      <div class="submenu">
      
      	<a href="#">통계 및 현황 (관리자)</a>
         <%-- (로그인된 관리자 기준) 전체 프로젝트 조회 + 관련 기능
         	  (당일 날짜 기준) 최근 등록된 프로젝트 / 사용자 / 업로드 문저 확인 --%>
         
        <a href="/project/list">프로젝트 관리 (관리자)</a>
         <%-- (로그인된 관리자 기준) 전체 프로젝트 조회 및 관리 기능 --%>

        <a href="/project/list">나의 프로젝트 (연구원)</a>
         <%-- (로그인된 연구원 기준) 참여하고 있는 프로젝트 조회 --%>
         
        <a href="#">승인 대기 항목</a>
         <%-- (로그인된 연구원 기준) 승인해야 할, 요청한 승인 리스트 출력 --%>
         <%-- (로그인된 관리자 기준) + 리스트 추가, 수정, 승인할 수 있는 기능 추가 --%>
         
        <a href="/chemical/list">시약 관리 (관리자)</a>
         <%-- (로그인된 관리자 기준) + 일정 수량 미만일 경우, 경고창 노출 --%>
          
       	<a href="/chemical/list">사용 시약 알림 (연구원)</a>
         <%-- (로그인된 연구원 기준) 최근 사용한 시약 조회 및 수량 알림 --%>
         
        
      </div>
    </div>
    <div class="menu-group">
      <div class="menu-title">일정 관리</div>
      <div class="submenu">
      
      	<a href="/today">오늘의 일정</a>
         <%-- (로그인된 연구원 기준 / 당일 날짜 기준) 진행 중인 스케쥴 조회 --%>
         
        <a href="/schedule">스케쥴 캘린더</a>
        <%-- FULLCALENDAR.API 를 활용하여 DB와 연동될 수 있게끔 설정 --%>
        
      </div>
    </div>
    <div class="menu-group">
      <div class="menu-title">고객 관리</div>
      <div class="submenu">
      
        <a href="/customer">고객 목록 조회 (관리자)</a>
        <%-- (로그인된 관리자 기준) 고객 리스트 조건별 조회 기능 --%>
        
        <a href="/customer/log">클레임 관리 (담당자)</a>
        <%-- (로그인된 연구원 기준) 본인에게 배정된 클레임 리스트 확인 --%>
        <%-- (로그인된 관리자 기준) + 전체 클레임 리스트 조회 및 담당자 배분 가능 --%>
        <%-- (로그인된 유저가 '고객서비스부' 일 경우) + 편집 및 로그 작성 기능 추가 --%>
        
        <a href="/customer/board">게시판 작성 화면 (담당자)</a>
        <%-- (게스트) 클레임 작성 가능 --%>
        <%-- (로그인된 관리자 기준) 공지사항 작성 가능 --%>
        
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
